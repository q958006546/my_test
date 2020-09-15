package com.lzyd.com.my_test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.imageio.ImageIO;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.SampleModel;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    public static void main2(String[] args) throws IOException {
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

    public static void main3(String[] args) throws IOException, InterruptedException {


        long            startTime =System.currentTimeMillis();
        ExecutorService pool      = Executors.newFixedThreadPool(16);
        String          url       ="http://www.xbiquge.la/xiaoshuodaquan/";
        Document document = Jsoup.connect(url).get();
        Elements results  = document.select(".novellist");

        for (Element element : results) {
            String taxon=element.select("h2").text();
            Elements select = element.select("ul>li>a");
            for (Element element2 : select) {
                String name = element2.text();//小说名称
                String nameAttr = element2.attr("abs:href");//小说地址

                Document document2 = Jsoup.connect(nameAttr).get();//解析每本小说的地址
                Element        first  = document2.select(".box_con>#list>dl>dd>a").first();
                final String[] urlAll = {first.attr("abs:href")};//每本小说的第一章地址
                System.err.println(name+"的第一章地址:"+ urlAll[0]);
                pool.execute(new Thread(new Runnable() {

                    @Override
                    public void run() {
                        int i=1;
                        long startTime = System.currentTimeMillis();
                        String path="D://小说/笔趣阁/"+taxon+"/"+name+".txt";
                        System.err.println(Thread.currentThread().getName()+"正在爬取"+name+"......");
                        File file = new File(path);
                        if(!file.exists()) {
                            try {
                                File dir = new File(file.getParent());
                                dir.mkdirs();
                                file.createNewFile();
                            } catch (IOException e) {
                                e.toString();
                            }
                        }
                        BufferedWriter bw;
                        try {
                            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

                            while(true) {
                                try {
                                    Document document3 = Jsoup.connect(urlAll[0]).get();
                                    String chapterName = document3.select("h1").text();
                                    bw.write(chapterName);
                                    bw.newLine();
                                    bw.flush();
                                    String chapterText = document3.select("#content").text();
                                    bw.write(chapterText);
                                    bw.newLine();
                                    bw.flush();

                                    Element aEl = document3.select(".bottem2>a[href*=html]").last();
                                    if (aEl == null) {
                                        break;
                                    }
                                    int size =1;
                                    if(i==1) {
                                        size = document3.select(".bottem2>a[href*=html]").size()+1;
                                        i++;
                                    }else{
                                        size = document3.select(".bottem2>a[href*=html]").size();
                                    }
                                    if(size<2) {
                                        long endTime = System.currentTimeMillis();
                                        System.err.println("爬取"+"《"+name+"》"+"总用时"+(endTime-startTime)/1000+"秒！");
                                        break;
                                    }
                                    urlAll[0] = aEl.attr("abs:href");



                                } catch (Exception e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                        } catch (FileNotFoundException e1) {
                            e1.toString();
                        }

                    }
                }));

                Thread.sleep(1000);

            }
            break;
        }
        pool.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("获取整个网站的小说需要"+(endTime+startTime)/1000+"秒");
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("/{c/}");
        Matcher matcher = pattern.matcher("Control-M");
        System.out.println(matcher.find());


    }

   




}



