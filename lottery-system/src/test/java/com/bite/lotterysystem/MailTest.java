package com.bite.lotterysystem;
import com.bite.lotterysystem.common.utils.MailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Shootingmemory
 * @create 2025-04-02-12:14
 */
@SpringBootTest
public class MailTest {

    @Autowired
    private MailUtil mailUtil;

    @Test
    void sendMessage() {
        mailUtil.sendSampleMail("3858582874@qq.com", "标题", "正文");
    }

}