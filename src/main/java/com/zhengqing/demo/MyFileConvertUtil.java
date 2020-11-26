package com.zhengqing.demo;

import java.io.File;
import java.util.List;

import com.zhengqing.demo.doc2docx.Doc2DocxUtil;
import com.zhengqing.demo.excel2pdf.Excel2PdfUtil;
import com.zhengqing.demo.html2img.Html2PngUtil;
import com.zhengqing.demo.html2pdf.Html2PdfUtil;
import com.zhengqing.demo.html2word.Htm2WordlUtil;
import com.zhengqing.demo.word2html.Word2HtmlUtil;
import com.zhengqing.demo.word2img.Word2JpegUtil;
import com.zhengqing.demo.word2img.Word2PngUtil;
import com.zhengqing.demo.word2pdf.Word2PdfUtil;

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
    public static byte[] wordBytes2HtmlBytes(byte[] wordBytes) {
        return Word2HtmlUtil.wordBytes2HtmlBytes(wordBytes);
    }

    /**
     * `word` 转 `html`
     *
     * @param wordBytes:
     *            word字节码
     * @return: html文件内容
     * @author : zhengqing
     * @date : 2020/11/23 16:21
     */
    public static String wordBytes2HtmlStr(byte[] wordBytes) {
        byte[] htmlBytes = Word2HtmlUtil.wordBytes2HtmlBytes(wordBytes);
        return new String(htmlBytes);
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
    public static File wordBytes2HtmlFile(byte[] wordBytes, String htmlFilePath) {
        return Word2HtmlUtil.wordBytes2HtmlFile(wordBytes, htmlFilePath);
    }

    /**
     * `word` 转 `pdf`
     *
     * @param wordBytes:
     *            word字节码
     * @return: 生成的`pdf`字节码
     * @author : zhengqing
     * @date : 2020/11/26 13:39
     */
    public static byte[] wordBytes2PdfBytes(byte[] wordBytes) {
        return Word2PdfUtil.wordBytes2PdfBytes(wordBytes);
    }

    /**
     * `word` 转 `pdf`
     *
     * @param wordBytes:
     *            word字节码
     * @param pdfFilePath:
     *            需转换的`pdf`文件路径
     * @return: 生成的`pdf`文件数据
     * @author : zhengqing
     * @date : 2020/11/26 13:39
     */
    public static File wordBytes2PdfFile(byte[] wordBytes, String pdfFilePath) {
        return Word2PdfUtil.wordBytes2PdfFile(wordBytes, pdfFilePath);
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
    public static byte[] docBytes2DocxBytes(byte[] docBytes) {
        return Doc2DocxUtil.docBytes2DocxBytes(docBytes);
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
    public static File docBytes2DocxFile(byte[] docBytes, String docxFilePath) {
        return Doc2DocxUtil.docBytes2DocxFile(docBytes, docxFilePath);
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
    public static byte[] htmlBytes2WordBytes(byte[] htmlBytes) {
        return Htm2WordlUtil.htmlBytes2WordBytes(htmlBytes);
    }

    /**
     * `html` 转 `word` 【 注：本地图片不支持显示！！！ 需转换成在线图片 】
     *
     * @param html:
     *            html内容
     * @return: word文件字节码
     * @author : zhengqing
     * @date : 2020/11/24 11:52
     */
    public static byte[] html2WordBytes(String html) {
        return Htm2WordlUtil.htmlBytes2WordBytes(html.getBytes());
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
    public static File htmlBytes2WordFile(byte[] htmlBytes, String wordFilePath) {
        return Htm2WordlUtil.htmlBytes2WordFile(htmlBytes, wordFilePath);
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
    public static byte[] htmlBytes2PdfBytes(byte[] htmlBytes) {
        return Html2PdfUtil.htmlBytes2PdfBytes(htmlBytes);
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
    public static File htmlBytes2PdfFile(byte[] htmlBytes, String pdfFilePath) {
        return Html2PdfUtil.htmlBytes2PdfFile(htmlBytes, pdfFilePath);
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
    public static byte[] excelBytes2PdfBytes(byte[] excelBytes) {
        return Excel2PdfUtil.excelBytes2PdfBytes(excelBytes);
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
    public static File excelBytes2PdfFile(byte[] excelBytes, String pdfFilePath) {
        return Excel2PdfUtil.excelBytes2PdfFile(excelBytes, pdfFilePath);
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
    public static List<byte[]> wordBytes2JpegBytes(byte[] wordBytes) {
        return Word2JpegUtil.wordBytes2JpegBytes(wordBytes);
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
    public static List<File> wordBytes2JpegFileList(byte[] wordBytes, String imgRootPath) {
        return Word2JpegUtil.wordBytes2JpegFileList(wordBytes, imgRootPath);
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
    public static List<byte[]> wordBytes2PngBytes(byte[] wordBytes) {
        return Word2PngUtil.wordBytes2PngBytes(wordBytes);
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
    public static List<File> wordBytes2PngFileList(byte[] wordBytes, String imgRootPath) {
        return Word2PngUtil.wordBytes2PngFileList(wordBytes, imgRootPath);
    }

    /**
     * `html` 转 `png`
     *
     * @param htmlBytes:
     *            html字节码
     * @return: 图片字节码数据列表
     * @author : zhengqing
     * @date : 2020/11/25 17:17
     */
    public static List<byte[]> htmlBytes2PngBytes(byte[] htmlBytes) {
        return Html2PngUtil.htmlBytes2PngBytes(htmlBytes);
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
    public static List<File> htmlBytes2PngFileList(byte[] htmlBytes, String imgRootPath) {
        return Html2PngUtil.htmlBytes2PngFileList(htmlBytes, imgRootPath);
    }

}
