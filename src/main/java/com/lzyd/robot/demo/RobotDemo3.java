package com.lzyd.robot.demo;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/09/16]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class RobotDemo3 {


    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
            //testInputStr();
            //testSwipe();
            testTap();
//            testTapForTwoAndroid();

        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /**
     * 两台手机点击一下
     */
    private static void testTapForTwoAndroid() {
        try {
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb -s 13b6e4c4 shell input tap 400 400 ");
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb -s 296ec3e2 shell input tap 400 400 ");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 控制手机点击一下
     */
    private static void testTap() {
        try {
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input tap 400 400 ");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 控制手机滑动
     */
    private static void testSwipe() {
        try {
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input swipe 800 800 100 100");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 控制手机输入0-9
     */
    private static void testInputStr() {
        try {
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input keyevent 7");
            Thread.sleep(1000);
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input keyevent 8");
            Thread.sleep(1000);
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input keyevent 9");
            Thread.sleep(1000);
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input keyevent 10");
            Thread.sleep(1000);
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input keyevent 11");
            Thread.sleep(1000);
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input keyevent 12");
            Thread.sleep(1000);
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input keyevent 13");
            Thread.sleep(1000);
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input keyevent 14");
            Thread.sleep(1000);
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input keyevent 15");
            Thread.sleep(1000);
            Runtime.getRuntime()
                    .exec("D:\\android\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb shell input keyevent 16");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
