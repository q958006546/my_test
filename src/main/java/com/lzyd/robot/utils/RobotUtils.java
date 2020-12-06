package com.lzyd.robot.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/09/15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class RobotUtils {
    private Robot robot;


    public Robot getRobot() {
        if (robot == null) {
            synchronized (RobotUtils.class) {
                if (robot == null) {
                    try {
                        robot = new Robot();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return robot;

    }

    /**
     * 鼠标移动
     */
    public void setMouseMove(int x, int y) {
        for (int i = 0; i < 10; i++) {
            robot.mouseMove(x, y);
        }
        robot.delay(1000);
    }

    /**
     * 鼠标点击
     */
    public void mouseMoveClick(int clickNum) {
        robot.mousePress(clickNum);
        robot.delay(new Random().nextInt(100) + 101);
        robot.mouseRelease(clickNum);
        robot.delay(new Random().nextInt(100) + 101);
    }

    /**
     * 按键点击
     */
    public void keyClick(int clickNum) {
        robot.keyPress(clickNum);
        robot.delay(new Random().nextInt(100) + 101);
        robot.keyRelease(clickNum);
        robot.delay(new Random().nextInt(100) + 101);
    }


    BufferedImage screenShotImage;    //屏幕截图
    BufferedImage keyImage;           //查找目标图片

    int scrShotImgWidth;              //屏幕截图宽度
    int scrShotImgHeight;             //屏幕截图高度

    int keyImgWidth;                  //查找目标图片宽度
    int keyImgHeight;                 //查找目标图片高度

    int[][] screenShotImageRGBData;   //屏幕截图RGB数据
    int[][] keyImageRGBData;          //查找目标图片RGB数据

    int[][][] findImgData;            //查找结果，目标图标位于屏幕截图上的坐标数据


    public void ImageFindDemo(String keyImagePath) {
        screenShotImage = this.getFullScreenShot();
        keyImage = this.getBfImageFromPath(keyImagePath);
        screenShotImageRGBData = this.getImageGRB(screenShotImage);
        keyImageRGBData = this.getImageGRB(keyImage);
        scrShotImgWidth = screenShotImage.getWidth();
        scrShotImgHeight = screenShotImage.getHeight();
        keyImgWidth = keyImage.getWidth();
        keyImgHeight = keyImage.getHeight();

        //开始查找
        this.findImage();

    }

    /**
     * 51      * 全屏截图
     * 52      * @return 返回BufferedImage
     * 53
     */
    public BufferedImage getFullScreenShot() {
        BufferedImage bfImage = null;
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        try {
            Robot robot = new Robot();
            bfImage = robot.createScreenCapture(new Rectangle(0, 0, width, height));
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return bfImage;
    }

    /**
     * 从本地文件读取目标图片
     *
     * @param keyImagePath - 图片绝对路径
     * @return 本地图片的BufferedImage对象
     */
    public BufferedImage getBfImageFromPath(String keyImagePath) {
        BufferedImage bfImage = null;
        try {
            bfImage = ImageIO.read(new File(keyImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bfImage;
    }

    /**
     * 根据BufferedImage获取图片RGB数组
     *
     * @param bfImage
     * @return
     */
    public int[][] getImageGRB(BufferedImage bfImage) {
        int width = bfImage.getWidth();
        int height = bfImage.getHeight();
        int[][] result = new int[height][width];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                //使用getRGB(w, h)获取该点的颜色值是ARGB，而在实际应用中使用的是RGB，所以需要将ARGB转化成RGB，即bufImg.getRGB(w, h) & 0xFFFFFF。
                result[h][w] = bfImage.getRGB(w, h) & 0xFFFFFF;
            }
        }
        return result;
    }


    /**
     * 查找图片
     */
    public void findImage() {
        findImgData = new int[keyImgHeight][keyImgWidth][2];
        //遍历屏幕截图像素点数据
        for (int y = 0; y < scrShotImgHeight - keyImgHeight; y++) {
            for (int x = 0; x < scrShotImgWidth - keyImgWidth; x++) {
                //根据目标图的尺寸，得到目标图四个角映射到屏幕截图上的四个点，
                //判断截图上对应的四个点与图B的四个角像素点的值是否相同，
                //如果相同就将屏幕截图上映射范围内的所有的点与目标图的所有的点进行比较。
                if ((keyImageRGBData[0][0] ^ screenShotImageRGBData[y][x]) == 0
                        && (keyImageRGBData[0][keyImgWidth - 1] ^ screenShotImageRGBData[y][x + keyImgWidth - 1]) == 0
                        && (keyImageRGBData[keyImgHeight - 1][keyImgWidth - 1] ^ screenShotImageRGBData[y + keyImgHeight - 1][x + keyImgWidth - 1]) == 0
                        && (keyImageRGBData[keyImgHeight - 1][0] ^ screenShotImageRGBData[y + keyImgHeight - 1][x]) == 0) {

                    boolean isFinded = isMatchAll(y, x);
                    //如果比较结果完全相同，则说明图片找到，填充查找到的位置坐标数据到查找结果数组。
                    if (isFinded) {
                        for (int h = 0; h < keyImgHeight; h++) {
                            for (int w = 0; w < keyImgWidth; w++) {
                                findImgData[h][w][0] = y + h;
                                findImgData[h][w][1] = x + w;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    /**
     * 判断屏幕截图上目标图映射范围内的全部点是否全部和小图的点一一对应。
     *
     * @param y - 与目标图左上角像素点想匹配的屏幕截图y坐标
     * @param x - 与目标图左上角像素点想匹配的屏幕截图x坐标
     * @return
     */
    public boolean isMatchAll(int y, int x) {
        int biggerY = 0;
        int biggerX = 0;
        int xor = 0;
        for (int smallerY = 0; smallerY < keyImgHeight; smallerY++) {
            biggerY = y + smallerY;
            for (int smallerX = 0; smallerX < keyImgWidth; smallerX++) {
                biggerX = x + smallerX;
                if (biggerY >= scrShotImgHeight || biggerX >= scrShotImgWidth) {
                    return false;
                }
                xor = keyImageRGBData[smallerY][smallerX] ^ screenShotImageRGBData[biggerY][biggerX];
                if (xor != 0) {
                    return false;
                }
            }
            biggerX = x;
        }
        return true;
    }

    /**
     * 输出查找到的坐标数据
     */
    private void printFindData() {
        for (int y = 0; y < keyImgHeight; y++) {
            for (int x = 0; x < keyImgWidth; x++) {
                System.out.print("(" + this.findImgData[y][x][0] + ", " + this.findImgData[y][x][1] + ")");
            }
            System.out.println();
        }
    }





}