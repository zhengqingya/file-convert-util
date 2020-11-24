### 一、前言

目前支持：

1. `word` 转 `html`
2. `doc` 转 `docx`
3. `html` 转 `word`
4. `html` 转 `pdf`
5. `excel` 转 `pdf`
6. `word` 转 `jpeg`

### 二、项目地址

[https://gitee.com/zhengqingya/file-convert-util](https://gitee.com/zhengqingya/file-convert-util)


### 三、部分代码

> 具体代码请查看项目示例

###### 1、主要调用工具类

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201124221112811.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MjI1NTU4,size_16,color_FFFFFF,t_70#pic_center)


```java
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
```


###### 2、测试类

```java
public class AppTest {

    private final String WORD_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.doc";
    private final String HTML_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.html";
    private final String EXCEL_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.xlsx";
    private final String MD_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.md";

    @Test // 【 https://gitee.com/cevin15/MD2File 】 【 注：转换格式不是太完善，存在一定问题！ 】
    public void markdown2Html() throws Exception {
        FileFactory.produce(new File(MD_FILE_PATH), Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test-md.html");
    }

    @Test
    public void testWord2Html() throws Exception {
        File htmlFile =
            MyFileConvertUtil.word2Html(new File(WORD_FILE_PATH), Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test.html");
        System.out.println(htmlFile);
    }

    @Test
    public void testHtml2Word() throws Exception {
        File wordFile = MyFileConvertUtil.html2Word(MyFileUtil.readBytes(HTML_FILE_PATH),
            Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test.doc");
        System.out.println(wordFile);
    }

    @Test
    public void testDoc2Docx() throws Exception {
        File docxFile =
            MyFileConvertUtil.doc2Docx(new File(WORD_FILE_PATH), Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test.docx");
        System.out.println(docxFile);
    }

    @Test
    public void testHtml2Pdf() throws Exception {
        File pdfFile = MyFileConvertUtil.html2Pdf(MyFileUtil.readBytes(HTML_FILE_PATH),
            Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test-html.pdf");
        System.out.println(pdfFile);
    }

    @Test
    public void testExcel2Pdf() throws Exception {
        File pdfFile = MyFileConvertUtil.excel2Pdf(MyFileUtil.readBytes(EXCEL_FILE_PATH),
            Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test-excel.pdf");
        System.out.println(pdfFile);
    }

    @Test
    public void testWord2Jpg() throws Exception {
        byte[] wordFileBytes = MyFileUtil.readBytes(WORD_FILE_PATH);
        List<File> jpgFileList = MyFileConvertUtil.word2Jpeg(wordFileBytes, Constants.DEFAULT_FOLDER_TMP_GENERATE);
        System.out.println(jpgFileList);
    }

}
```



---

> 今日分享语句：
> 生活从来都不容易，总是伴随着一个又一个的坎坷和挑战。
聪明的人，懂得调节自己的情绪，不会被外在事物轻易地影响自己的心情，看淡世间沧桑，内心安然无恙。
说到底，很多人都毁在了自寻烦恼上。如果学会这三点，你将会快乐很多。
