package com.lzyd.robot.demo;


import com.lzyd.robot.utils.RobotUtils;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/09/15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
@RequestMapping("/robot/")
public class RobotDemo2 {
    static RobotUtils robotUtils = new RobotUtils();
    //刷tb
    public static void main(String[] args) throws AWTException, IOException {
        Robot robot = robotUtils.getRobot();
        robot.delay(3000);
        robotUtils.setMouseMove(557,1072);
        robotUtils.mouseMoveClick(InputEvent.BUTTON1_MASK);
        robotUtils.setMouseMove(330,64);
        robotUtils.mouseMoveClick(InputEvent.BUTTON1_MASK);
        robot.delay(500);
//        robot.keyE


//        String bfImageFromPath = "C:\\Users\\sun\\Desktop\\娱乐\\image.jpg";
//        File outputfile = new File(bfImageFromPath);
//        BufferedImage fullScreenShot = robotUtils.getFullScreenShot();
//        ImageIO.write(fullScreenShot, "jpg", outputfile);

//        robotUtils.keyClick(KeyEvent.VK_X);
//        robot.delay(1000);
//        robotUtils.keyClick(KeyEvent.VK_SPACE);
//        robot.delay(1000);
//        robotUtils.setMouseMove(1417,155);
//        robotUtils.mouseMoveClick(InputEvent.BUTTON1_MASK);
    }
    //发微信
    @GetMapping("/test")
    public String test(Integer num) throws AWTException, IOException {
        System.out.println(num + "---data:" + new Date());
        Robot robot = robotUtils.getRobot();
        for (int i = 1; i <= 10; i++) {
            System.out.println("还剩下" + (10 - i) + "秒");
            robot.delay(1000);
        }
        robotUtils.setMouseMove(958,1061);
        robotUtils.mouseMoveClick(InputEvent.BUTTON1_MASK);
        robotUtils.setMouseMove(160,554);
        robotUtils.mouseMoveClick(InputEvent.BUTTON1_MASK);
//        robotUtils.keyClick(KeyEvent.VK_B);
//        robotUtils.keyClick(KeyEvent.VK_E);
//        robotUtils.keyClick(KeyEvent.VK_N);
//        robotUtils.keyClick(KeyEvent.VK_1);
        robotUtils.keyClick(KeyEvent.VK_B);
        robotUtils.keyClick(KeyEvent.VK_I);
        robotUtils.keyClick(KeyEvent.VK_E);
        robotUtils.keyClick(KeyEvent.VK_K);
        robotUtils.keyClick(KeyEvent.VK_A);
        robotUtils.keyClick(KeyEvent.VK_N);
        robotUtils.keyClick(KeyEvent.VK_L);
        robotUtils.keyClick(KeyEvent.VK_1);
        robot.delay(100);
        for (int i = 0; i < 2; i++) {
            robotUtils.keyClick(KeyEvent.VK_H);
            robotUtils.keyClick(KeyEvent.VK_A);
            robotUtils.keyClick(KeyEvent.VK_N);
            robotUtils.keyClick(KeyEvent.VK_1);
            robot.delay(100);
        }
        robotUtils.keyClick(KeyEvent.VK_ENTER);
        robot.delay(100);
        robotUtils.setMouseMove(621,478);
        robotUtils.mouseMoveClick(InputEvent.BUTTON1_MASK);
        return "看微信呀:" + num ;
    }

}
