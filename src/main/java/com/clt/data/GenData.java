package com.clt.data;

import com.clt.constant.Const;
import com.clt.controller.BookController;
import com.clt.dao.BookDao;
import com.clt.entity.Book;
import com.clt.entity.Type;
import com.clt.entity.User;
import com.clt.enums.BookEnum;
import com.clt.service.BookService;
import com.clt.service.TypeService;
import com.clt.utils.DateUtils;
import com.clt.utils.UUIDUtil;
import org.apache.commons.lang3.RandomUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
@Component
public class GenData {
    private static final Logger logger = LoggerFactory.getLogger(GenData.class);

    @Resource
    private BookService bookService;

    @Resource
    private TypeService typeService;

    public static void main(String[] args) throws IOException {
//        reptiteBookTypeData("http://book.dangdang.com/");
//        System.out.println(RandomDataUtil.getRandomName());
        System.setProperty("http.proxyHost", "172.16.25.75");
        System.setProperty("http.proxyPort", "808");
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
                book.setScore(Float.valueOf(RandomDataUtil.getRandomNum(0, 100)) / 20);
                book.setZanNumber(RandomDataUtil.getRandomNum(10, 10000));
                books.add(book);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    public List<Type> reptiteBookTypeData(String url) throws IOException {
        System.setProperty("http.proxyHost", "172.16.25.75");
        System.setProperty("http.proxyPort", "808");
        final Connection connect = Jsoup.connect(url);
        final Document document = connect.get();
        Element body = document.body();
        List<Type> fistTypes = new ArrayList<>();
        List<Type> secondTypes = new ArrayList<>();
        List<Type> thirdTypes = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        final Elements level_ones = body.getElementsByClass("level_one");
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
                            List<Book> books = reptiteBookData(href, thirdType.getId());
                            bookService.insertBatch(books);
                            typeService.insert(thirdType);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                typeService.insert(secondType);
            }
            typeService.insert(firstType);
        }
//        fistTypes.addAll(secondTypes);
//        fistTypes.addAll(thirdTypes);
        return fistTypes;
    }

    public List<User> randomGenUserData() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            User user = new User();
            user.setUserId(UUIDUtil.getUUID());
            user.setCredit(RandomDataUtil.getRandomNum(30, 90));
            user.setUserName(RandomDataUtil.getChineseFamilyName() + RandomDataUtil.getRandomName());
            final Map<String, String> randomAddressCode = RandomDataUtil.getRandomAddressCode();
            user.setAddress("[\"430000\",\"" + randomAddressCode.entrySet().iterator().next().getKey() + "\",\"" + randomAddressCode.entrySet().iterator().next().getValue() + "\"]");
            user.setEmail(RandomDataUtil.getRandomEmail());
            user.setRole("0");
            user.setCreateTime(RandomDataUtil.getRandomDate("2019-01-01", "2020-05-01"));
            user.setLastLoginTime(RandomDataUtil.getRandomDate("2020-04-01", "2020-05-01"));
            user.setRegisterTime(user.getCreateTime());
            user.setSex(String.valueOf(RandomDataUtil.getRandomNum(0, 1)));
            user.setStatus("1");
            user.setTel(RandomDataUtil.getRandomTel());
//            user.setClassId();
            users.add(user);
        }
        return users;
    }
}
