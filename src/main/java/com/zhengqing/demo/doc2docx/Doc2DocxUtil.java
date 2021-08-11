package com.zhengqing.demo.doc2docx;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * <p>
 * Doc 转 Docx 工具类
 * </p>
 *
 * @author zhengqing
 * @description
 * @date 2020/11/24 11:23
 */
@Slf4j
public class Doc2DocxUtil {

    /**
     * `doc` 转 `docx`
     *
     * @param docBytes: doc文件字节码
     * @return 生成的`docx`文件字节码
     * @author zhengqing
     * @date 2020/11/24 11:26
     */
    @SneakyThrows(Exception.class)
    public static byte[] docBytes2DocxBytes(byte[] docBytes) {
        Document document = new Document(new ByteArrayInputStream(docBytes));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.save(outputStream, SaveFormat.DOCX);
        return outputStream.toByteArray();
    }

    /**
     * `doc` 转 `docx`
     *
     * @param docBytes:     doc文件字节码
     * @param docxFilePath: docx文件路径
     * @return 生成的`docx`文件数据
     * @author zhengqing
     * @date 2020/11/24 11:26
     */
    @SneakyThrows(Exception.class)
    public static File docBytes2DocxFile(byte[] docBytes, String docxFilePath) {
        Document document = new Document(new ByteArrayInputStream(docBytes));
        document.save(docxFilePath, SaveFormat.DOCX);
        return new File(docxFilePath);
    }

    /**
     * `doc` 转 `docx`
     *
     * @param fileRootPath:    文件根位置
     * @param wordFileName:    需转换的`doc`文件名
     * @param wordFileNameNew: 待生成的的`docx`文件名
     * @return 生成的`docx`文件路径
     * @author zhengqing
     * @date 2020/11/24 11:26
     */
    @SneakyThrows(Exception.class)
    public static String docBytes2DocxFile(String fileRootPath, String wordFileName, String wordFileNameNew) {
        // word 文件路径
        final String wordFilePath = fileRootPath + "/" + wordFileName;
        final String wordFilePathNew = fileRootPath + "/" + wordFileNameNew;
        // 将`doc`格式转换成`docx`
        Document document = new Document(wordFilePath);
        document.save(wordFilePathNew);
        // 返回生成的`docx`文件路径
        return wordFilePathNew;
    }

}
