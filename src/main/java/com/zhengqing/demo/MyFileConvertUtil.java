package com.zhengqing.demo;

import java.io.File;
import java.util.List;

import com.zhengqing.demo.doc2docx.Doc2DocxUtil;
import com.zhengqing.demo.excel2pdf.Excel2PdfUtil;
import com.zhengqing.demo.html2pdf.Html2PdfUtil;
import com.zhengqing.demo.html2word.Htm2WordlUtil;
import com.zhengqing.demo.word2Img.Word2JpegUtil;
import com.zhengqing.demo.word2Img.Word2PngUtil;
import com.zhengqing.demo.word2html.Word2HtmlUtil;

import lombok.SneakyThrows;
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
     * @param wordBytes:
     *            word字节码
     * @return: html文件字节码数据
     * @author : zhengqing
     * @date : 2020/11/23 16:21
     */
    public static byte[] word2Html(byte[] wordBytes) {
        return Word2HtmlUtil.word2Html(wordBytes);
    }

    /**
     * `word` 转 `html`
     *
     * @param wordBytes:
     *            word字节码
     * @param htmlFilePath:
     *            html文件路径
     * @return: html文件数据
     * @author : zhengqing
     * @date : 2020/11/23 16:21
     */
    public static File word2Html(byte[] wordBytes, String htmlFilePath) {
        return Word2HtmlUtil.word2Html(wordBytes, htmlFilePath);
    }

    /**
     * `doc` 转 `docx`
     *
     * @param docBytes:
     *            doc文件字节码
     * @return: 生成的`docx`文件字节码
     * @author : zhengqing
     * @date : 2020/11/24 11:26
     */
    public static byte[] doc2Docx(byte[] docBytes) {
        return Doc2DocxUtil.doc2Docx(docBytes);
    }

    /**
     * `doc` 转 `docx`
     *
     * @param docBytes:
     *            doc文件字节码
     * @param docxFilePath:
     *            待生成的的`docx`文件路径
     * @return: 生成的`docx`文件数据
     * @author : zhengqing
     * @date : 2020/11/24 11:26
     */
    public static File doc2Docx(byte[] docBytes, String docxFilePath) {
        return Doc2DocxUtil.doc2Docx(docBytes, docxFilePath);
    }

    /**
     * `html` 转 `word` 【 注：本地图片不支持显示！！！ 需转换成在线图片 】
     *
     * @param htmlBytes:
     *            html字节码
     * @return: word文件字节码
     * @author : zhengqing
     * @date : 2020/11/24 11:52
     */
    public static byte[] html2Word(byte[] htmlBytes) {
        return Htm2WordlUtil.html2Word(htmlBytes);
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
        return Htm2WordlUtil.html2Word(htmlBytes, wordFilePath);
    }

    /**
     * `html` 转 `pdf`
     *
     * @param htmlBytes:
     *            html字节码
     * @return: 生成的`pdf`字节码
     * @author : zhengqing
     * @date : 2020/11/24 11:26
     */
    public static byte[] html2Pdf(byte[] htmlBytes) {
        return Html2PdfUtil.html2Pdf(htmlBytes);
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
        return Html2PdfUtil.html2Pdf(htmlBytes, pdfFilePath);
    }

    /**
     * `excel` 转 `pdf`
     *
     * @param excelBytes:
     *            html字节码
     * @return: 生成的`pdf`文件流
     * @author : zhengqing
     * @date : 2020/11/24 11:26
     */
    public static byte[] excel2Pdf(byte[] excelBytes) {
        return Excel2PdfUtil.excel2Pdf(excelBytes);
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
        return Excel2PdfUtil.excel2Pdf(excelBytes, pdfFilePath);
    }

    /**
     * `word` 转 `jpeg`
     *
     * @param wordBytes:
     *            word字节码数据
     * @return: 图片字节码数据列表
     * @author : zhengqing
     * @date : 2020/11/24 11:52
     */
    public static List<byte[]> word2Jpeg(byte[] wordBytes) {
        return Word2JpegUtil.word2Jpeg(wordBytes);
    }

    /**
     * `word` 转 `jpeg`
     *
     * @param wordBytes:
     *            word字节码数据
     * @param imgRootPath:
     *            生成图片根路径
     * @return: 图片字节码数据列表
     * @author : zhengqing
     * @date : 2020/11/24 11:52
     */
    public static List<File> word2Jpeg(byte[] wordBytes, String imgRootPath) {
        return Word2JpegUtil.word2Jpeg(wordBytes, imgRootPath);
    }

    /**
     * `word` 转 `png`
     *
     * @param wordBytes:
     *            word字节码数据
     * @return: 图片字节码数据列表
     * @author : zhengqing
     * @date : 2020/11/24 11:52
     */
    @SneakyThrows(Exception.class)
    public static List<byte[]> word2Png(byte[] wordBytes) {
        return Word2PngUtil.word2Png(wordBytes);
    }

    /**
     * `word` 转 `png`
     *
     * @param wordBytes:
     *            word字节码数据
     * @param imgRootPath:
     *            生成图片路径
     * @return: 图片字节码数据列表
     * @author : zhengqing
     * @date : 2020/11/24 11:52
     */
    public static List<File> word2Png(byte[] wordBytes, String imgRootPath) {
        return Word2PngUtil.word2Png(wordBytes, imgRootPath);
    }

}
