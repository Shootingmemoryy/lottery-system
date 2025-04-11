package com.bite.lotterysystem.service.impl;


import com.bite.lotterysystem.common.errorcode.ServiceErrorCodeConstants;
import com.bite.lotterysystem.common.exception.ServiceException;
import com.bite.lotterysystem.common.utils.*;
import com.bite.lotterysystem.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;


@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {


    private static final String VERIFICATION_CODE_PREFIX = "VERIFICATION_CODE_";
    private static final Long VERIFICATION_CODE_TIMEOUT = 60L;
    private static final String VERIFICATION_CODE_TEMPLATE_CODE = "SMS_475730500 ";

    @Autowired
    private SMSUtil smsUtil;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void sendVerificationCode(String phoneNumber) {
        // 校验手机号
        if (!RegexUtil.checkMobile(phoneNumber)) {
            throw new ServiceException(ServiceErrorCodeConstants.PHONE_NUMBER_ERROR);
        }

        // 生成随机验证码
        String code = CaptchaUtil.getCaptcha(4);
        // 发送验证码
        // {"code":"xxxx"}
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        smsUtil.sendMessage(
                VERIFICATION_CODE_TEMPLATE_CODE,
                phoneNumber,
                JacksonUtil.writeValueAsString(map));
        // 缓存验证码
        // 131xxxxxxxx: code
        redisUtil.set(VERIFICATION_CODE_PREFIX + phoneNumber, code, VERIFICATION_CODE_TIMEOUT);
    }

    @Override
    public String getVerificationCode(String phoneNumber) {
        // 校验手机号
        if (!RegexUtil.checkMobile(phoneNumber)) {
            throw new ServiceException(ServiceErrorCodeConstants.PHONE_NUMBER_ERROR);
        }

        return redisUtil.get(VERIFICATION_CODE_PREFIX + phoneNumber);
    }
}
