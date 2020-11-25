### 一、前言

目前支持：

1. `word` 转 `html`
2. `doc` 转 `docx`
3. `html` 转 `word`
4. `html` 转 `pdf`
5. `excel` 转 `pdf`
6. `word` 转 `jpeg`
7. `word` 转 `png`
8. `markdown` 转 `html`

### 二、项目地址

[https://gitee.com/zhengqingya/file-convert-util](https://gitee.com/zhengqingya/file-convert-util)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201125162115728.png#pic_center)


### 三、部分代码

> 具体代码请查看项目示例
> 

###### 1、主要调用工具类

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201125161730971.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MjI1NTU4,size_16,color_FFFFFF,t_70#pic_center)



```java
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

}
```


###### 2、测试类

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    private final String WORD_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.doc";
    private final String HTML_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.html";
    private final String EXCEL_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.xlsx";
    private final String MD_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.md";

    @Test
    public void testWord2Html() throws Exception {
        File htmlFile = MyFileConvertUtil.wordBytes2HtmlFile(MyFileUtil.readBytes(WORD_FILE_PATH),
            Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test.html");
        System.out.println(htmlFile);
    }

    @Test
    public void testHtml2Word() throws Exception {
        File wordFile = MyFileConvertUtil.htmlBytes2WordFile(MyFileUtil.readBytes(HTML_FILE_PATH),
            Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test.doc");
        System.out.println(wordFile);
    }

    @Test
    public void testDoc2Docx() throws Exception {
        File docxFile = MyFileConvertUtil.docBytes2DocxFile(MyFileUtil.readBytes(WORD_FILE_PATH),
            Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test.docx");
        System.out.println(docxFile);
    }

    @Test
    public void testHtml2Pdf() throws Exception {
        File pdfFile = MyFileConvertUtil.htmlBytes2PdfFile(MyFileUtil.readBytes(HTML_FILE_PATH),
            Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test-html.pdf");
        System.out.println(pdfFile);
    }

    @Test
    public void testExcel2Pdf() throws Exception {
        File pdfFile = MyFileConvertUtil.excelBytes2PdfFile(MyFileUtil.readBytes(EXCEL_FILE_PATH),
            Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test-excel.pdf");
        System.out.println(pdfFile);
    }

    @Test
    public void testWord2Jpg() throws Exception {
        byte[] wordFileBytes = MyFileUtil.readBytes(WORD_FILE_PATH);
        List<File> jpgFileList =
            MyFileConvertUtil.wordBytes2JpegFileList(wordFileBytes, Constants.DEFAULT_FOLDER_TMP_GENERATE);
        System.out.println(jpgFileList);
    }

    @Test
    public void testWord2Png() throws Exception {
        byte[] wordFileBytes = MyFileUtil.readBytes(WORD_FILE_PATH);
        List<File> pngFileList =
            MyFileConvertUtil.wordBytes2PngFileList(wordFileBytes, Constants.DEFAULT_FOLDER_TMP_GENERATE);
        System.out.println(pngFileList);
    }

    @Test // 【 注：转换格式不是太完善，存在一定问题！ 】
    public void testMarkdown2Html() throws Exception {
        FileFactory.produce(new File(MD_FILE_PATH), Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test-md.html");
    }

}
```

---

> 分享语句：
> 生活从来都不容易，总是伴随着一个又一个的坎坷和挑战。
聪明的人，懂得调节自己的情绪，不会被外在事物轻易地影响自己的心情，看淡世间沧桑，内心安然无恙。
说到底，很多人都毁在了自寻烦恼上。如果学会这三点，你将会快乐很多。
