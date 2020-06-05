package com.clt.data;

import com.alibaba.fastjson.JSON;
import com.clt.constant.Const;
import com.clt.controller.BookController;
import com.clt.dao.BookDao;
import com.clt.dao.PermissionDao;
import com.clt.dao.UserDao;
import com.clt.entity.*;
import com.clt.enums.BookEnum;
import com.clt.enums.UserEnum;
import com.clt.service.*;
import com.clt.service.impl.DictionaryDataServiceImpl;
import com.clt.utils.DateUtils;
import com.clt.utils.ResultUtil;
import com.clt.utils.UUIDUtil;
import org.apache.commons.lang3.RandomUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ：clt
 * @Date ：Created in 18:54 2020/04/24
 */
@RestController
public class GenData {
    private static final Logger logger = LoggerFactory.getLogger(GenData.class);

    @Resource
    private BookService bookService;

    @Resource
    private TypeService typeService;

    @Resource
    private UserClassService userClassService;

    @Resource
    private DictionaryDataService dictionaryDataService;

    @Resource
    private LocationService locationService;

    @Resource
    private CommentService commentService;

    @Resource
    private PermissionDao permissionDao;

    public static void main(String[] args) throws IOException {
//        reptiteBookTypeData("http://book.dangdang.com/");
//        System.out.println(RandomDataUtil.getRandomName());
        System.setProperty("http.proxyHost", "172.16.25.75");
        System.setProperty("http.proxyPort", "808");
        List<Book> bookList = new ArrayList<>();
        Book b = new Book();
        b.setBookId("!11");
        b.setRemark1("111");
        bookList.add(b);
        genBookCommentData(bookList);
//        reptiteBookTypeData("http://book.dangdang.com/");
    }

    public boolean downloadImgByURL(String httpUrl, String fileName) {
        URL url;
        BufferedInputStream in;
        FileOutputStream file;
        try {
            logger.info("获取网络图片 {}", httpUrl);
            String filePath = Const.filePath;
            url = new URL(httpUrl);
            in = new BufferedInputStream(url.openStream());
            final File fileImg = new File(filePath + File.separator + fileName);
            if (!fileImg.exists()) {
                fileImg.createNewFile();
            }
            file = new FileOutputStream(fileImg);
            int t;
            while ((t = in.read()) != -1) {
                file.write(t);
            }
            file.close();
            in.close();
            logger.info("图片获取成功 {}", fileImg);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @GetMapping("/genbookData/reptite")
    public ResultUtil<Boolean> genBookData(
            @RequestParam("url") String url,
            @RequestParam("categoryId") String categoryId
    ) throws IOException {
        reptiteBookData(url, categoryId);
        return ResultUtil.success(true);
    }

    @GetMapping("/genTypeData/reptite")
    public ResultUtil<Boolean> genBookData(
            @RequestParam("url") String url
    ) throws IOException {
        System.setProperty("http.proxyHost", "172.16.25.75");
        System.setProperty("http.proxyPort", "808");
        reptiteBookTypeData(url);
        return ResultUtil.success(true);
    }

    @Resource
    private UserDao userDao;

    @GetMapping("/genUserData/random")
    public ResultUtil<Boolean> genUserData() {
        randomGenUserData();
        return ResultUtil.success(true);
    }

    @GetMapping("/genUserPermissionData")
    public ResultUtil<Boolean> genPermissionData() {
        genUserPermissionData();
        return ResultUtil.success(true);
    }

    @GetMapping("/genClassData/All")
    public ResultUtil<Boolean> genClassDataAll() {
        genClassData();
        return ResultUtil.success(true);
    }

    @GetMapping("/genBookLocationData/All")
    public ResultUtil<Boolean> genBookLocationAll() {
        genBookLocationData();
        return ResultUtil.success(true);
    }

    public List<Book> reptiteBookData(String url, String categoryId) throws IOException {
        final Connection connect = Jsoup.connect(url);
        final Document document = connect.get();
        Element body = document.body();
        final Elements names = body.getElementsByClass("name");
        final Elements prices = body.getElementsByClass("price");
        final Elements pictures = body.getElementsByClass("pic");
        final Elements search_book_authors = body.getElementsByClass("search_book_author");
        final Elements details = body.getElementsByClass("detail");
        List<Book> books = new ArrayList<>(60);
        for (int i = 0; i < names.size(); i++) {
            try {
                Book book = new Book();
                String id = UUIDUtil.getUUID();
                book.setBookId(id);
                Element picture = pictures.get(i);
                String imgUrl = picture.getElementsByTag("img").get(0).attr("src");
                if (!imgUrl.startsWith("http://")) {
                    imgUrl = picture.getElementsByTag("img").get(0).attr("data-original");
                }
//                downloadImgByURL(imgUrl, id + ".jpg");
//                book.setImg(id + ".jpg");
                book.setImg(imgUrl);
                Element name = names.get(i);
                book.setBookName(picture.attr("title"));
                book.setRemark1(picture.attr("href"));
                Element price = prices.get(i);
                book.setPrice(Double.valueOf(price.getElementsByTag("span").get(0).text().substring(1)));
                book.setBookDescribe(details.get(i).getElementsByTag("p").get(0).text());
                Element author = search_book_authors.get(i);
                book.setAuthor(author.getElementsByTag("a").get(0).text());
                String date = author.getElementsByTag("span").get(1).text();
                if (date != null && date.length() > 2) {
                    DateUtils.stringDateToStandardDate(date.substring(1));
                } else {
                    book.setInputTime(RandomDataUtil.getRandomDate("2019-04-26", "2020-04-26"));
                }
                if (author.getElementsByTag("span") != null && author.getElementsByTag("span").get(2).getElementsByTag("a") != null) {
                    book.setPublished(author.getElementsByTag("span").get(2).getElementsByTag("a").get(0).text());
                }

                book.setCategoryId(categoryId);
                book.setEbook(0);
                book.setUpdateTime(new Date());
                book.setBookStatus(BookEnum.BOOK_STATUS_IN_LIBRARY.getCode());
                book.setBorrowingNumber(RandomDataUtil.getRandomNum(10, 200));
                book.setScore(Float.valueOf(RandomDataUtil.getRandomNum(80, 100)) / 20);
                book.setZanNumber(RandomDataUtil.getRandomNum(10, 10000));
                books.add(book);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    public void reptiteBookTypeData(String url) throws IOException {
        System.setProperty("http.proxyHost", "172.16.25.75");
        System.setProperty("http.proxyPort", "808");
        final Connection connect = Jsoup.connect(url);
        final Document document = connect.get();
        Element body = document.body();
        int i = 0;
        int j = 0;
        int k = 0;
        final Elements level_ones = body.getElementsByClass("level_one");
        List<Book> books = new ArrayList<>(35000);
        Date now = new Date();
        for (Element levelOneElement : level_ones) {
            i++;
            String levelOneName = "";
            if (i == 2) {
                continue;
            }
            if (i < 2) {
                levelOneName = levelOneElement.getElementsByClass("con primary_dl").get(0).getElementsByClass("con").text();
            } else {
                levelOneName = levelOneElement.getElementsByTag("dt").get(0).text();
            }
            Type firstType = new Type();
            firstType.setId((String.format("%3d", i).replace(" ", "0")));
            firstType.setLevel(1);
            firstType.setCreateTime(now);
            firstType.setSort(i);
            firstType.setTitle(levelOneName);
            Elements levelTwoElements = levelOneElement.getElementsByClass("inner_dl");
            for (Element levelTwoElement : levelTwoElements) {
                String levelTwoName = levelTwoElement.getElementsByTag("dt").get(0).text();
                j++;
                Type secondType = new Type();
                secondType.setPid(firstType.getId());
                secondType.setPName(firstType.getName());
                secondType.setId((String.format("%3d", i).replace(" ", "0") + String.format("%3d", j).replace(" ", "0")));
                secondType.setLevel(2);
                secondType.setCreateTime(now);
                secondType.setSort(Integer.valueOf(i + "" + j));
                secondType.setTitle(levelTwoName);
                Elements levelThreeElements = levelTwoElement.getElementsByTag("dd").get(0).getElementsByTag("a");
                for (Element levelThreeElement : levelThreeElements) {
                    try {
                        final String levelThreeName = levelThreeElement.attr("title");
                        final String href = levelThreeElement.attr("href");
                        k++;
                        Type thirdType = new Type();
                        thirdType.setPid(secondType.getId());
                        thirdType.setPName(secondType.getName());
                        thirdType.setId((String.format("%3d", i).replace(" ", "0") + String.format("%3d", j).replace(" ", "0") + String.format("%3d", k).replace(" ", "0")));
                        thirdType.setLevel(3);
                        thirdType.setCreateTime(now);
                        thirdType.setSort(Integer.valueOf(i + "" + j + "" + k));
                        thirdType.setTitle(levelThreeName);
                        if (href.startsWith("http://category.dangdang.com/")) {
                            books.addAll(reptiteBookData(href, thirdType.getId()));
//                            typeService.insert(thirdType);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
//                typeService.insert(secondType);
            }
//            typeService.insert(firstType);
        }
        List<Location> locations = locationService.queryAllByLimit(0, 2000);
        books.stream().forEach(book -> {
            book.setLocation(locations.get(RandomDataUtil.getRandomNum(0,locations.size()-1)).getLocationId());
        });
        bookService.insertBatch(books);
        return;
    }

    public void randomGenUserData() {
        List<User> users = new ArrayList<>();
        List<UserClass> userClasses = userClassService.queryAllByLimit(0, 2000);

        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setUserId(UUIDUtil.getUUID());
            user.setCredit(RandomDataUtil.getRandomNum(30, 90));
            user.setUserName(RandomDataUtil.getChineseFamilyName() + RandomDataUtil.getRandomName());
            final Map<String, String> randomAddressCode = RandomDataUtil.getRandomAddressCode();
            user.setAddress("[\"430000\",\"" + randomAddressCode.entrySet().iterator().next().getKey() + "\",\"" + randomAddressCode.entrySet().iterator().next().getValue() + "\"]");
            user.setEmail(RandomDataUtil.getRandomEmail());
            user.setPassword(Const.INITIAL_PASSWORD);
            Object md5PassWord = new SimpleHash(Const.ENCRYPTION_ALGORITHM, user.getPassword(),
                    user.getUserName(), Const.ENCRYPTION_TIMES);
            user.setPassword(md5PassWord.toString());
            user.setRole(String.valueOf(RandomDataUtil.getRandomNum(0, 3)));
            user.setCreateTime(RandomDataUtil.getRandomDate("2019-01-01", "2020-05-01"));
            user.setLastLoginTime(RandomDataUtil.getRandomDate("2020-04-01", "2020-05-01"));
            user.setRegisterTime(user.getCreateTime());
            user.setSex(String.valueOf(RandomDataUtil.getRandomNum(0, 1)));
            user.setStatus("1");
            user.setTel(RandomDataUtil.getRandomTel());
            user.setClassId(userClasses.get(RandomDataUtil.getRandomNum(0,userClasses.size()-1)).getClassId());
            users.add(user);
        }
        userDao.insertBatch(users);
    }

    public void genUserPermissionData(){
        List<User> users = userDao.queryAllByLimit(0, 10001);
        List<Permission> userPermissionList = new ArrayList<>(users.size());
        for (User user : users) {
            Permission permissionRecord = new Permission();
            if ("3".equals(user.getRole())){
                permissionRecord.setPrivilege(true);
                permissionRecord.setUserId(user.getUserId());
                userPermissionList.add(permissionRecord);
            }
            if (UserEnum.USER_ROLE_ADMIN.getCode().equals(user.getRole())){
                permissionRecord.setUserId(user.getUserId());
                userPermissionList.add(permissionRecord);
            }

        }
        permissionDao.insertBatch(userPermissionList);
    }

    public void genClassData(){
        ResultUtil<List<DictionaryData>> classInfo = dictionaryDataService.getClassInfo();
        List<String> classInfoArrary = new ArrayList<>(4);
        classInfoArrary.add(0,"");
        classInfoArrary.add(1,"");
        classInfoArrary.add(2,"");
        classInfoArrary.add(3,"");
        classInfo.getData().stream().forEach( grade -> {

            classInfoArrary.set(0, grade.getValue());
            grade.getChildren().stream().forEach(depart -> {
                classInfoArrary.set(1, depart.getValue());
                depart.getChildren().stream().forEach(major -> {
                    classInfoArrary.set(2, major.getValue());
                    major.getChildren().stream().forEach(classNumber -> {
                        classInfoArrary.set(3, classNumber.getValue());
                        String classId = JSON.toJSONString(classInfoArrary);
                        UserClass userClass = new UserClass();
                        userClass.setClassId(classId);
                        userClassService.insert(userClass);
                    });
                });
            });
        });
    }


    public void genBookLocationData(){
        ResultUtil<List<DictionaryData>> bookLocation = dictionaryDataService.getLocationInfo();
        List<String> bookLocationArrary = new ArrayList<>(4);
        bookLocationArrary.add(0,"");
        bookLocationArrary.add(1,"");
        bookLocationArrary.add(2,"");
        bookLocationArrary.add(3,"");
        bookLocation.getData().stream().forEach( area -> {
            bookLocationArrary.set(0, area.getValue());
            area.getChildren().stream().forEach(floor -> {
                bookLocationArrary.set(1, floor.getValue());
                floor.getChildren().stream().forEach(room -> {
                    bookLocationArrary.set(2, room.getValue());
                    room.getChildren().stream().forEach(shelf -> {
                        bookLocationArrary.set(3, shelf.getValue());
                        String locationId = JSON.toJSONString(bookLocationArrary);
                        Location location = new Location();
                        location.setLocationId(locationId);
                        locationService.insert(location);
                    });
                });
            });
        });
    }

    public static void genBookCommentData(List<Book> books){
        books.stream().forEach( book -> {
            List<Comment> commentList = new ArrayList<>();
            if (book.getRemark1() != null){
//                final Connection connect = Jsoup.connect(book.getRemark1());
                final Connection connect = Jsoup.connect("http://product.dangdang.com/27925828.html");
                final Document document;
                try {
                    document = connect.get();
                    Element body = document.getElementsByClass("mbox3 book_comment").first();
                    Elements comment_items = body.getElementsByClass("comment_items clearfix");
                    comment_items.stream().forEach( comment -> {
                        Comment comment_i = new Comment();
                        String score = comment.getElementsByTag("em").get(0).text();
                        comment_i.setCommentId(UUIDUtil.getUUID());
                        comment_i.setReplyFlag(false);
                        Date comment_time = DateUtils.stringTimeToStandardTime(comment.getElementsByClass("starline clearfix").get(0).getElementsByTag("span").text());
                        comment_i.setCommentTime(comment_time);
                        comment_i.setZanNumber(Integer.valueOf(comment.getElementsByClass("support").get(0).getElementsByTag("a").get(0).text()));
                        comment_i.setContent(comment.getElementsByClass("describe_detail").get(0).getElementsByTag("a").text());

                        comment_i.setBookId(book.getBookId());
                        comment_i.setReplyUserName("admin");
                        comment_i.setUserId("1");
                        commentList.add(comment_i);
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            commentService.insertBatch(commentList);
        });
    }
}
