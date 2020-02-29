package com.clt.utils;

import java.util.UUID;

/**
 * @author ：clt
 * @Date ：Created in 18:56 2020/02/25
 */
public class UUIDUtils {
    private UUIDUtils(){}

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }


    public static void main(String[] args) {

        String str1 = "abc";

        String str2 = "abc";

        String str3 = new String("abc");

        System.out.println("str1 == str2 :"+(str1 == str2));

        System.out.println("str2 == str3 :"+(str2 == str3));


    }
}
