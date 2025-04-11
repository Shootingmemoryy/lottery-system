package com.bite.lotterysystem;


import com.bite.lotterysystem.service.VerificationCodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class VerificationCodeServiceTest {
    @Autowired
    private VerificationCodeService verificationCodeService;


    @Test
    void testSend() {
        verificationCodeService.sendVerificationCode("15847503090");
        System.out.println(
                verificationCodeService.getVerificationCode("15847503090")
        );
    }

}
