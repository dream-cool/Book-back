package com.clt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author ：clt
 * @Date ：Created in 18:37 2020/04/21
 */
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static String sendGet(String url) {
        StringBuilder result = new StringBuilder(200);
        BufferedReader in = null;
        Object out = null;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gb2312"));

            String line;
            while((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception var15) {
            logger.error("第三方服务异常， url: [{}]", url);
            return  null;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    ((PrintWriter)out).close();
                }
            } catch (Exception var14) {
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = sendGet("http://whois.pconline.com.cn/jsFunction.jsp?ip=218.76.52.119");
        int start = result.indexOf('\'');
        int end = result.indexOf('\'', start + 1);
        System.out.println(result.substring(start+1, end ));
    }
}
