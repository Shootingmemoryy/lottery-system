package com.bite.lotterysystem;


import com.bite.lotterysystem.common.utils.SMSUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: yibo
 */
@SpringBootTest
public class SMSTest {

    @Autowired
    private SMSUtil smsUtil;

    @Test
    void smsTest() {
        smsUtil.sendMessage(
                "SMS_475730500",
                "15847503090",
                "{\"code\":\"1234\"}");
        // {"code":"1234"}
    }

}
