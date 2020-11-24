package com.zhengqing.demo.doc2docx;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Doc 转 Docx 工具类 【注： 需`aspose-words`包】
 * </p>
 *
 * @author : zhengqing
 * @description :
 * @date : 2020/11/24 11:23
 */
@Slf4j
public class Doc2DocxUtil {

    /**
     * 将`doc`格式转换成`docx`
     *
     * @param data:
     *            doc文件字节码
     * @return: 生成的`docx`文件字节码
     * @author : zhengqing
     * @date : 2020/11/24 11:26
     */
    @SneakyThrows(Exception.class)
    public static byte[] doc2Docx(byte[] data) {
        Doc2DocxUtil.matchWordLicense();
        Document document = new Document(new ByteArrayInputStream(data));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.save(outputStream, SaveFormat.DOCX);
        return outputStream.toByteArray();
    }

    /**
     * 将`doc`格式转换成`docx`
     *
     * @param fileRootPath:
     *            文件根位置
     * @param wordFileName:
     *            需转换的`doc`文件名
     * @param wordFileNameNew:
     *            待生成的的`docx`文件名
     * @return: 生成的`docx`文件路径
     * @author : zhengqing
     * @date : 2020/11/24 11:26
     */
    @SneakyThrows(Exception.class)
    public static String doc2Docx(String fileRootPath, String wordFileName, String wordFileNameNew) {
        Doc2DocxUtil.matchWordLicense();
        // word 文件路径
        final String wordFilePath = fileRootPath + "/" + wordFileName;
        final String wordFilePathNew = fileRootPath + "/" + wordFileNameNew;
        // 将`doc`格式转换成`docx`
        Document document = new Document(wordFilePath);
        document.save(wordFilePathNew);
        // 返回生成的`docx`文件路径
        return wordFilePathNew;
    }

    /**
     * 实现匹配文件授权 -> 去掉头部水印 `Evaluation Only. Created with Aspose.Words. Copyright 2003-2018 Aspose Pty Ltd.`
     *
     * @author : zhengqing
     * @date : 2020/11/24 15:44
     */
    @SneakyThrows(Exception.class)
    public static void matchWordLicense() {
        InputStream is = Doc2DocxUtil.class.getClassLoader().getResourceAsStream("license.xml");
        License wordLicense = new License();
        wordLicense.setLicense(is);
    }

}
