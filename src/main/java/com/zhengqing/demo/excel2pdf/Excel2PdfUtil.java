package com.zhengqing.demo.excel2pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.aspose.cells.License;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;
import com.zhengqing.demo.html2pdf.Html2PdfUtil;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Excel 转 Pdf 工具类 【注： 需`aspose-words`包】
 * </p>
 *
 * @author : zhengqing
 * @description :
 * @date : 2020/11/24 11:23
 */
@Slf4j
public class Excel2PdfUtil {

    /**
     * 将`excel`格式转换成`pdf`
     *
     * @param excelBytes:
     *            html字节码
     * @return: 生成的`pdf`文件流
     * @author : zhengqing
     * @date : 2020/11/24 11:26
     */
    @SneakyThrows(Exception.class)
    public static byte[] excel2Pdf(byte[] excelBytes) {
        matchExcelLicense();
        Workbook workbook = new Workbook(new ByteArrayInputStream(excelBytes));

        // 设置pdf保存的格式以及强制所有列都在同一页
        PdfSaveOptions pso = new PdfSaveOptions();
        pso.setAllColumnsInOnePagePerSheet(true);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // workbook.save(outputStream, SaveFormat.PDF);
        workbook.save(outputStream, pso);
        // 返回生成的`pdf`文件字节码
        return outputStream.toByteArray();
    }

    /**
     * 实现匹配文件授权 -> 去掉头部水印 `Evaluation Only. Created with Aspose.Cells for Java. Copyright 2003 - 2020 Aspose Pty Ltd.`
     *
     * @author : zhengqing
     * @date : 2020/11/24 15:44
     */
    @SneakyThrows(Exception.class)
    public static void matchExcelLicense() {
        InputStream is = Html2PdfUtil.class.getClassLoader().getResourceAsStream("license.xml");
        License excelLicense = new License();
        excelLicense.setLicense(is);
    }

}
