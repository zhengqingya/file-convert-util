package com.zhengqing.demo.config;

import com.aspose.words.License;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

/**
 * <p>
 * `aspose-words`授权处理
 * </p>
 *
 * @author zhengqing
 * @description
 * @date 2020/12/30$ 11:33$
 */
@Slf4j
public class MatchLicense {

    public static void init() {
        try {
            log.info("实现`aspose-words`授权 -> 去掉头部水印");
            /*
              实现匹配文件授权 -> 去掉头部水印 `Evaluation Only. Created with Aspose.Words. Copyright 2003-2018 Aspose Pty Ltd.` |
                                          `Evaluation Only. Created with Aspose.Cells for Java. Copyright 2003 - 2020 Aspose Pty Ltd.`
             */
            InputStream is = new ClassPathResource("license.xml").getInputStream();
            License license = new License();
            license.setLicense(is);
        } catch (Exception e) {
            log.error("《`aspose-words`授权》 失败： {}", e.getMessage());
        }
    }

}
