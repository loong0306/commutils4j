package com.git.comm.utils.u4img;

import com.git.comm.utils.u4string.StringUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by dragon on 1/21/2018.
 */
public class ImageUtils {

    /**
     * 将文字生成图片
     * @param text
     * @param width
     * @param height
     * @param fontSize
     * @return
     */
    public String textToPic(String text, int width, int height, int fontSize) {
        String textPath = "";
        try {
            String fileName = StringUtils.getUUID() + ".png";
            // 修改filePath
            String filePath = "" + fileName;
            File file = new File(filePath);
            Font font = new Font("华文隶书", Font.BOLD, fontSize);
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g2 = (Graphics2D) bi.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setFont(font);
            g2.setPaint(Color.red);
            paintString(g2, text,1,270, fontSize);
            g2.dispose();
            ImageIO.write(bi, "png", file);
            // BufferedImage 转换 InputStream
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
            ImageIO.write(bi, "png", imageOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textPath;
    }

    public static void paintString(Graphics2D g2d, String str, int x, int y, int fontSize) {
        FontMetrics metrics = g2d.getFontMetrics();
        for (char ca : str.toCharArray()) {
            int px = metrics.stringWidth("" + ca);
            g2d.drawString("" + ca, x + (fontSize - px) / 2, y);
            x += fontSize;
        }
    }

    /**
     * 对图片进行成比例缩小
     * @param originalImage 原始图片
     * @param times 缩小倍数
     * @return 缩小后的Image
     */
    public static BufferedImage zoomOutImage(BufferedImage originalImage, Integer times){
        // 50是自己新增的，可删除
        int width = originalImage.getWidth() / times + 50;
        int height = originalImage.getHeight() / times + 50;
        BufferedImage newImage = new BufferedImage(width, height, originalImage.getType());
        Graphics g = newImage.getGraphics();
        g.drawImage(originalImage, 0, 0, width, height,null);
        g.dispose();
        return newImage;

    }

    /**
     * 传入的图像必须是正方形的 才会 圆形  如果是长方形的比例则会变成椭圆的
     * @return
     * @throws IOException
     */
    public static BufferedImage convertCircular(BufferedImage bi1, String url) throws IOException{
        //透明底的图片
        BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        // 第一个值x 和第二个值y 是圈定图片选中的位置
        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0,bi1.getWidth(), bi1.getHeight());
        Graphics2D g2 = bi2.createGraphics();
        g2.setClip(shape);
        // 使用 setRenderingHint 设置抗锯齿
        g2.drawImage(bi1,0,0,null);
        g2.dispose();
        return bi2;
    }

}
