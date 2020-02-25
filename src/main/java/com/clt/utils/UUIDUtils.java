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

}
