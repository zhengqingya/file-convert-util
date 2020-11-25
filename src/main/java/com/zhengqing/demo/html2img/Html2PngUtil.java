package com.zhengqing.demo.html2img;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

import com.aspose.words.Document;
import com.aspose.words.ImageSaveOptions;
import com.aspose.words.SaveFormat;
import com.google.common.collect.Lists;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * html 转 png 工具类
 * </p>
 *
 * @author : zhengqing
 * @description :
 * @date : 2020/11/25 17:16
 */
@Slf4j
public class Html2PngUtil {

    /**
     * `html` 转 `png`
     *
     * @param htmlBytes:
     *            html字节码
     * @return: 图片字节码数据列表
     * @author : zhengqing
     * @date : 2020/11/25 17:17
     */
    @SneakyThrows(Exception.class)
    public static List<byte[]> htmlBytes2PngBytes(byte[] htmlBytes) {
        Document doc = new Document(new ByteArrayInputStream(htmlBytes));
        ImageSaveOptions iso = new ImageSaveOptions(SaveFormat.PNG);
        iso.setResolution(128);
        iso.setPrettyFormat(true);
        iso.setUseAntiAliasing(true);
        List<byte[]> pngList = Lists.newArrayList();
        for (int i = 0; i < doc.getPageCount(); i++) {
            iso.setPageIndex(i);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            doc.save(outputStream, iso);
            pngList.add(outputStream.toByteArray());
        }
        return pngList;
    }

    /**
     * `html` 转 `png`
     *
     * @param htmlBytes:
     *            html字节码
     * @param imgRootPath:
     *            需转换的`png`文件路径
     * @return: 图片文件数据列表
     * @author : zhengqing
     * @date : 2020/11/25 17:17
     */
    @SneakyThrows(Exception.class)
    public static List<File> htmlBytes2PngFileList(byte[] htmlBytes, String imgRootPath) {
        Document doc = new Document(new ByteArrayInputStream(htmlBytes));
        ImageSaveOptions iso = new ImageSaveOptions(SaveFormat.PNG);
        iso.setResolution(128);
        iso.setPrettyFormat(true);
        iso.setUseAntiAliasing(true);

        List<File> pngList = Lists.newArrayList();
        for (int i = 0; i < doc.getPageCount(); i++) {
            String imgPath = imgRootPath + "/" + (i + 1) + ".png";
            iso.setPageIndex(i);
            doc.save(imgPath, iso);
            pngList.add(new File(imgPath));
        }
        return pngList;
    }

}
