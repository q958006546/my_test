package com.lzyd.com.my_test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.imageio.ImageIO;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.SampleModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import static jdk.nashorn.internal.objects.Global.print;

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

    public static void main1(String[] args) throws AWTException, IOException {

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


    public static void main(String[] args) throws IOException {
        String userName = "syt";
        String pwd = "syt";

        //第一次请求
        Connection con=Jsoup.connect("https://www.baidu.com/s?wd=a");//获取连接
        con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");//配置模拟浏览器
        Response      rs = con.execute();//获取响应
        Document      d1 =Jsoup.parse(rs.body());//转换为Dom树
        List<Element> et = d1.select(".el-input-group__prepend");//获取form表单，可以通过查看页面源码代码得知

        //获取，cooking和表单属性，下面map存放post时的数据
        Map<String, String> datas=new HashMap<>();
        for(Element e:et.get(0).getAllElements()){
            if(e.attr("name").equals("name")){
                e.attr("value", userName);//设置用户名
            }

            if(e.attr("name").equals("password")){
                e.attr("value",pwd); //设置用户密码
            }

            if(e.attr("name").length()>0){//排除空值表单属性
                datas.put(e.attr("name"), e.attr("value"));
            }
        }


        /**
         * 第二次请求，post表单数据，以及cookie信息
         *
         * **/
        Connection con2 = Jsoup.connect("http://www.iteye.com/login");
        con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
        //设置cookie和post上面的map数据
        Response login =con2.ignoreContentType(true).method(Connection.Method.POST).data(datas).cookies(rs.cookies()).execute();
        //打印，登陆成功后的信息
        System.out.println(login.body());

        //登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
        Map<String, String> map =login.cookies();
        for(String s:map.keySet()){
            System.out.println(s+"      "+map.get(s));
        }

    }
    private CountDownLatch a;
    private CyclicBarrier barrier;// 使用CyclicBarrier保证任务按组执行



   




}



