package com.zhengqing.demo;

import java.io.File;
import java.util.List;

import com.google.common.collect.Lists;
import com.zhengqing.demo.doc2docx.Doc2DocxUtil;
import com.zhengqing.demo.excel2pdf.Excel2PdfUtil;
import com.zhengqing.demo.html2pdf.Html2PdfUtil;
import com.zhengqing.demo.html2word.Htm2WordlUtil;
import com.zhengqing.demo.utils.MyFileUtil;
import com.zhengqing.demo.word2Jpeg.Word2JpegUtil;
import com.zhengqing.demo.word2html.Word2HtmlUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 文件转换工具类$
 * </p>
 *
 * @author : zhengqing
 * @description :
 * @date : 2020/11/23$ 16:19$
 */
@Slf4j
public class MyFileConvertUtil {

    /**
     * `word` 转 `html`
     *
     * @param wordFile:
     *            word文件信息
     * @param htmlFilePath:
     *            html文件路径
     * @return: html文件数据
     * @author : zhengqing
     * @date : 2020/11/23 16:21
     */
    public static File word2Html(File wordFile, String htmlFilePath) {
        return Word2HtmlUtil.word2Html(wordFile, htmlFilePath);
    }

    /**
     * `doc` 转 `docx`
     *
     * @param docFile:
     *            doc文件数据
     * @param docxFilePath:
     *            待生成的的`docx`文件路径
     * @return: 生成的`docx`文件路径
     * @author : zhengqing
     * @date : 2020/11/24 11:26
     */
    public static File doc2Docx(File docFile, String docxFilePath) {
        byte[] docxBytes = Doc2DocxUtil.doc2Docx(MyFileUtil.readBytes(docFile.getAbsolutePath()));
        return MyFileUtil.writeFileContent(docxBytes, docxFilePath);
    }

    /**
     * `html` 转 `word` 【 注：本地图片不支持显示！！！ 需转换成在线图片 】
     *
     *
     * @param htmlBytes:
     *            html字节码
     * @param wordFilePath:
     *            待生成的word文件路径
     * @return: word文件信息
     * @author : zhengqing
     * @date : 2020/11/23 16:04
     */
    public static File html2Word(byte[] htmlBytes, String wordFilePath) {
        byte[] wordBytes = Htm2WordlUtil.html2Word(htmlBytes);
        return MyFileUtil.writeFileContent(wordBytes, wordFilePath);
    }

    /**
     * `html` 转 `pdf`
     *
     * @param htmlBytes:
     *            html文件数据
     * @param pdfFilePath:
     *            待生成的`pdf`文件路径
     * @return: 生成的`pdf`文件数据
     * @author : zhengqing
     * @date : 2020/11/24 11:26
     */
    public static File html2Pdf(byte[] htmlBytes, String pdfFilePath) {
        byte[] pdfBytes = Html2PdfUtil.html2Pdf(htmlBytes);
        return MyFileUtil.writeFileContent(pdfBytes, pdfFilePath);
    }

    /**
     * `excel` 转 `pdf`
     *
     * @param excelBytes:
     *            excel文件字节码
     * @param pdfFilePath:
     *            待生成的`pdf`文件路径
     * @return: 生成的`Pdf`文件数据
     * @author : zhengqing
     * @date : 2020/11/24 11:26
     */
    public static File excel2Pdf(byte[] excelBytes, String pdfFilePath) {
        byte[] pdfBytes = Excel2PdfUtil.excel2Pdf(excelBytes);
        return MyFileUtil.writeFileContent(pdfBytes, pdfFilePath);
    }

    /**
     * `word` 转 `jpeg`
     *
     * @param wordBytes:
     *            word字节码数据
     * @param imgPath:
     *            生成图片路径
     * @return: 图片字节码数据列表
     * @author : zhengqing
     * @date : 2020/11/24 11:52
     */
    public static List<File> word2Jpeg(byte[] wordBytes, String imgPath) {
        List<File> fileList = Lists.newArrayList();
        List<byte[]> jpegList = Word2JpegUtil.word2Jpeg(wordBytes);
        for (int i = 0; i < jpegList.size(); i++) {
            fileList.add(MyFileUtil.writeFileContent(jpegList.get(i), imgPath + "/" + i + ".jpg"));
        }
        return fileList;
    }

}
