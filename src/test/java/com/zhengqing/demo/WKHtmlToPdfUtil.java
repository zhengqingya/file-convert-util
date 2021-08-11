package com.zhengqing.demo;

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
public class WKHtmlToPdfUtil {
    
    public String getCommand(String sourceFilePath, String targetFilePath) {
        String system = System.getProperty("os.name");
        if (system.contains("Windows")) {
            return "D:/zhengqingya/wkhtmltopdf/wkhtmltoimage.exe " + sourceFilePath + " " + targetFilePath;
        } else if (system.contains("Linux") || system.contains("Mac OS X")) {
            return "wkhtmltoimage " + sourceFilePath + " " + targetFilePath;
        }
        return "";
    }

    public static void main(String[] args) throws Exception {
        WKHtmlToPdfUtil util = new WKHtmlToPdfUtil();
        String command = util.getCommand("https://zhengqing.blog.csdn.net", "zhengqingya.png");
        Process process = Runtime.getRuntime().exec(command);
        // 这个调用比较关键，就是等当前命令执行完成后再往下执行
        process.waitFor();
        System.out.println("finish");
    }

}
