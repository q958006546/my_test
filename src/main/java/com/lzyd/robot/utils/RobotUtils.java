package com.lzyd.robot.utils;

import java.awt.*;
import java.awt.event.InputEvent;
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
        if (robot == null){
            synchronized (RobotUtils.class){
                if (robot == null){
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
            robot.mouseMove(x,y);
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




}
