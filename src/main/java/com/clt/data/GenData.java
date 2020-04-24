package com.clt.data;

import com.clt.entity.Book;
import com.clt.enums.BookEnum;
import com.clt.enums.BorrowingEnum;
import com.clt.utils.DateUtils;
import com.clt.utils.UUIDUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：clt
 * @Date ：Created in 18:54 2020/04/24
 */
public class GenData {
    public static void main(String[] args) throws IOException {
        reptiteBookData();
    }

    public static boolean downloadImgByURL(String httpUrl, String  fileName){
        URL url;
        BufferedInputStream in;
        FileOutputStream file;
        try {
            System.out.println("获取网络图片");
            String filePath = "C:\\Users\\Mrchen\\Desktop\\book\\BackEnd\\fileData\\";
            url = new URL(httpUrl);
            in = new BufferedInputStream(url.openStream());
            final File fileImg = new File(filePath + fileName);
            if (!fileImg.exists()){
                fileImg.createNewFile();
            }
            file = new FileOutputStream(fileImg);
            int t;
            while ((t = in.read()) != -1) {
                file.write(t);
            }
            file.close();
            in.close();
            System.out.println("图片获取成功");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static  List<Book> reptiteBookData() throws IOException {
        final Connection connect = Jsoup.connect("http://39.97.239.108:8088/");
        final Document document = connect.get();
        Element body = document.body();
        final Elements names = body.getElementsByClass("name");
        final Elements prices = body.getElementsByClass("price");
        final Elements pictures = body.getElementsByClass("pic");
        final Elements search_book_authors = body.getElementsByClass("search_book_author");
        final Elements details = body.getElementsByClass("detail");
        List<Book> books = new ArrayList<>(60);
        for (int i = 0; i < names.size(); i++) {
            Book book = new Book();
            String id = UUIDUtil.getUUID();
            book.setBookId(id);
            Element picture = pictures.get(i);
            String imgUrl = picture.getElementsByTag("img").get(0).attr("src");
            if (!imgUrl.startsWith("http://")){
                imgUrl = picture.getElementsByTag("img").get(0).attr("data-original");
            }
            downloadImgByURL(imgUrl, id+".jpg");
            book.setImg(id+".jpg");
            Element name = names.get(i);
            book.setBookName(name.getElementsByTag("a").get(0).text());
            Element price =  prices.get(i);
            book.setPrice(Double.valueOf(price.getElementsByTag("span").get(0).text().substring(1)));
            book.setBookDescribe(details.get(i).getElementsByTag("p").get(0).text());
            Element author = search_book_authors.get(i);
            book.setAuthor(author.getElementsByTag("a").get(0).text());
            book.setInputTime(DateUtils.stringDateToStandardDate(author.getElementsByTag("span").get(1).text().substring(1)));
            book.setPublished(author.getElementsByTag("span").get(2).getElementsByTag("a").get(0).text());
            book.setCategoryId("26");
            book.setEbook(0);
            book.setUpdateTime(new Date());
            book.setBookStatus(BookEnum.BOOK_STATUS_IN_LIBRARY.getCode());
            book.setBorrowingNumber(RandomDataUtil.getRandomNum(10, 200));
            book.setScore(Float.valueOf(RandomDataUtil.getRandomNum(0, 100))/20);
            book.setZanNumber(RandomDataUtil.getRandomNum(10,10000 ));
            books.add(book);
        }
        return books;
    }
}
