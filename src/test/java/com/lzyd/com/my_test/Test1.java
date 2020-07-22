package com.lzyd.com.my_test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.SampleModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/07/21]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Test1 {

    public static void main(String[] args) throws AWTException, IOException {

        Robot r = new Robot();
        //new Rectangle(100, 100, 100, 100)坐标100，100的位置上取一个大小为100，100的像素矩形
        //r.createScreenCapture通过它来获取这个像素矩形里面的图片信息
        BufferedImage bi   = r.createScreenCapture(new Rectangle(100, 100, 100, 100));
        int           type = bi.getType();
        int height = bi.getHeight();
        int         width       = bi.getWidth();
        SampleModel sampleModel = bi.getSampleModel();
        int         dataType    = sampleModel.getDataType();
        System.out.println("type"+type);
        System.out.println("height"+height);//图片的高
        System.out.println("width"+width);//图片的宽
        System.out.println("sampleModel"+sampleModel);
        System.out.println("dataType"+dataType);
        //设定存在哪。存的文件名叫啥
        File f = new File("C:\\Users\\95800\\Desktop\\Qrcode\\save.png");
        //打开一个输出流
        OutputStream os = new FileOutputStream(f);
        bi.flush();
        //第一个参数传BufferedImage，第二个传图片类型，
        //支持，png,，pg,，gif
        //第三个传一个OutputStream流
        //成功写入磁盘
        ImageIO.write(bi, "png", os);

    }
}
