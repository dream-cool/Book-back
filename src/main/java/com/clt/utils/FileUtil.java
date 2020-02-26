package com.clt.utils;

import com.clt.constant.Const;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：clt
 * @Date ：Created in 19:09 2020/02/25
 */
public class FileUtil {
    public static String getCharset(String fileName) throws IOException {
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();
        String code = null;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        return code;
    }

    public static String charset(String path) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        try {
            boolean checked = false;
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
            // 读者注： bis.mark(0);修改为 bis.mark(100);我用过这段代码，需要修改上面标出的地方。
            bis.mark(0);
            // Wagsn注：不过暂时使用正常，遂不改之
            int read = bis.read(first3Bytes, 0, 3);
            if (read == -1) {
                bis.close();
                return charset;
            } else if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8";
                checked = true;
            }
            bis.reset();
            if (!checked) {
                while ((read = bis.read()) != -1) {
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF)
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF)
                            // (0x80 - 0xBF),也可能在GB编码内
                            continue;
                        else
                            break;
                    } else if (0xE0 <= read && read <= 0xEF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return charset;
    }


    public static List<String> getFileContent(int page, int rows, String fileName) {
        List<String> list = new ArrayList<>();
        list.add(fileName);
        rows = rows == 0 ? 100 : rows;
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), charset(fileName)))
        ) {
            String str;
            int i = 1;
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
                if (i % rows == 0) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *      * 获取文件大小
     *      * 
     *      * @param size
     *      * @return
     */
    public static String getPrintSize(long size) {
        DecimalFormat df=new DecimalFormat("0.00");
        if (size < Const.BYTE){
            return size+"B";
        } else if (size < Const.KB){
            return df.format((float)size/Const.BYTE)+"KB";
        } else if (size < Const.MB){
            return df.format((float)size/Const.KB)+"MB";
        } else {
            return df.format((float)size/Const.MB)+"GB";
        }
    }


    public static void main(String[] args) throws IOException {
        //getFileContent(1,100,"C:/Users/mrchen/Desktop/真龙.txt");
        //System.out.println(charset("C:/Users/mrchen/Desktop/魔道祖师.txt"));

        File file = new File("C:/Users/mrchen/Desktop/魔道祖师.txt");
        getPrintSize(file.length());
    }

}
