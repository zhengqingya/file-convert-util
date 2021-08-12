package com.zhengqing.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * wkhtmltopdf 工具
 * </p>
 *
 * @author zhengqingya
 * @description https://wkhtmltopdf.org
 * html转pdf： wkhtmltopdf https://zhengqing.blog.csdn.net zhengqingya.pdf
 * html转图片： wkhtmltoimage https://zhengqing.blog.csdn.net zhengqingya.png
 * @date 2021/8/11 9:54 下午
 */
@Slf4j
public class WKHtmlToPdfUtil {

    public String getCommandByImage(String sourceFilePath, String targetFilePath) {
        String system = System.getProperty("os.name");
        if (system.contains("Windows")) {
            return "D:/zhengqingya/soft/soft-dev/wkhtmltopdf/bin/wkhtmltoimage.exe " + sourceFilePath + " " + targetFilePath;
        } else if (system.contains("Linux") || system.contains("Mac OS X")) {
            return "wkhtmltoimage " + sourceFilePath + " " + targetFilePath;
        }
        return "";
    }

    public String getCommandByPdf(String sourceFilePath, String targetFilePath) {
        String system = System.getProperty("os.name");
        if (system.contains("Windows")) {
            return "D:/zhengqingya/soft/soft-dev/wkhtmltopdf/bin/wkhtmltopdf.exe " + sourceFilePath + " " + targetFilePath;
        } else if (system.contains("Linux") || system.contains("Mac OS X")) {
            return "wkhtmltoimage " + sourceFilePath + " " + targetFilePath;
        }
        return "";
    }

    public static void main(String[] args) throws Exception {
        String sourceFilePath = "https://zhengqing.blog.csdn.net";

        WKHtmlToPdfUtil util = new WKHtmlToPdfUtil();
        String commandByImage = util.getCommandByImage(sourceFilePath, "zhengqingya.png");
        Process processByImage = Runtime.getRuntime().exec(commandByImage);
        // 这个调用比较关键，就是等当前命令执行完成后再往下执行
        processByImage.waitFor();
        log.info("=============== image finish ===============");

        String commandByPdf = util.getCommandByPdf(sourceFilePath, "zhengqingya.pdf");
        Process processByPdf = Runtime.getRuntime().exec(commandByPdf);
        processByPdf.waitFor();
        log.info("=============== pdf finish ===============");
    }

}
