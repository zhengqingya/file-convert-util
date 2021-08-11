package com.zhengqing.demo.html2img;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.xhtmlrenderer.swing.Java2DRenderer;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * <p>
 * html 转 图片 工具类 （core-renderer-R8）
 * </p>
 *
 * @author zhengqingya
 * @description 可参考： https://flyingsaucerproject.github.io/flyingsaucer/r8/guide/users-guide-R8.html
 * @date 2021/8/11 9:15
 */
@Slf4j
public class Html2ImgUtil {

    /**
     * `html` 转 `jpg` (注：宽高注意设置，否则图片显示内容不完整)
     *
     * @param htmlBytes: html字节码
     * @return 图片字节码数据
     * @author zhengqing
     * @date 2020/11/25 17:17
     */
    @SneakyThrows(Exception.class)
    public static byte[] htmlBytes2JpgBytes(byte[] htmlBytes) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(htmlBytes);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(byteArrayInputStream);
        Java2DRenderer renderer = new Java2DRenderer(document, 800, 1000);
        BufferedImage bufferedImage = renderer.getImage();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

}
