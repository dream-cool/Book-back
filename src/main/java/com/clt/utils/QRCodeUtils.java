package com.clt.utils;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author ：clt
 * @Date ：Created in 22:25 2020/04/12
 */
public class QRCodeUtils {

    /**
     *
     *
     * @param content 显示的内容
     * @param imgPath  生成成功后存放的路径
     */
    public static void genQrcodeImage(String content, String imgPath) {

        int width = 235;

        int height = 235;
        // 实例化一个对象
        Qrcode qrcode = new Qrcode();
        // 编码方式
        qrcode.setQrcodeEncodeMode('E');
        // 设置拍错率
        qrcode.setQrcodeErrorCorrect('M');
        // 二维码的版本
        qrcode.setQrcodeVersion(15);
        // 绘制二维码
        // 画板
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 画笔
        Graphics2D gs = image.createGraphics();
        // 设置背景颜色 白色
        gs.setBackground(Color.white);
        // 设置二维码的颜色
        gs.setColor(Color.black);
        // 创建一个二维码的绘制区域
        gs.clearRect(0, 0, width, height);

        byte[] codeOut;
        try {
            codeOut = content.getBytes("utf-8");
            boolean[][] code = qrcode.calQrcode(codeOut);
            for (int i = 0; i < code.length; i++) {
                for (int j = 0; j < code.length; j++) {
                    if (code[j][i]) {
                        gs.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);
                    }
                }
            }
            ImageIO.write(image, "png", new File(imgPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
//        genQrcodeImage("123","f:/erweima.png");
        String circleImg = "C:\\Users\\Mrchen\\Desktop\\book\\BackEnd\\fileData\\favicon.jpg";
        String backgroundImg = "f:/erweima.png";
        drawCircle(backgroundImg, circleImg);
    }

    public static void drawCircle(String backgroundImg, String circleImg) throws IOException {

        BufferedImage avatarImage = ImageIO.read(new File(circleImg));
        int width = 120;
        // 透明底的图片
        BufferedImage formatAvatarImage = new BufferedImage(width, width, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D graphics = formatAvatarImage.createGraphics();
        //把图片切成一个圓
        {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //留一个像素的空白区域，这个很重要，画圆的时候把这个覆盖
            int border = 1;
            //图片是一个圆型
            Ellipse2D.Double shape = new Ellipse2D.Double(border, border, width - border * 2, width - border * 2);
            //需要保留的区域
            graphics.setClip(shape);
            graphics.drawImage(avatarImage, border, border, width - border * 2, width - border * 2, null);
            graphics.dispose();
        }
        //在圆图外面再画一个圆
        {
            //新创建一个graphics，这样画的圆不会有锯齿
            graphics = formatAvatarImage.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int border = 3;
            //画笔是4.5个像素，BasicStroke的使用可以查看下面的参考文档
            //使画笔时基本会像外延伸一定像素，具体可以自己使用的时候测试
            Stroke s = new BasicStroke(4.5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            graphics.setStroke(s);
            graphics.setColor(Color.WHITE);
            graphics.drawOval(border, border, width - border * 2, width - border * 2);
            graphics.dispose();
        }
        {
            BufferedImage srcImg = ImageIO.read(new File(backgroundImg));
            //scrImg加载完之后没有任何颜色
            BufferedImage blankImage = new BufferedImage(srcImg.getWidth(), srcImg.getHeight(), BufferedImage.TYPE_INT_RGB);
            graphics = blankImage.createGraphics();
            graphics.drawImage(srcImg, 0, 0, null);


            graphics.drawImage(formatAvatarImage.getScaledInstance(83,
                    83, Image.SCALE_SMOOTH), 75,75,null);
            try (OutputStream os = new FileOutputStream("f:/22.jpg")) {
                ImageIO.write(blankImage, "JPG", os);
            }
        }
    }
}
