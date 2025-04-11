package com.bite.lotterysystem.controller;


import com.bite.lotterysystem.common.errorcode.ControllerErrorCodeConstants;
import com.bite.lotterysystem.common.exception.ControllerException;
import com.bite.lotterysystem.common.pojo.CommonResult;
import com.bite.lotterysystem.common.utils.JacksonUtil;
import com.bite.lotterysystem.controller.param.ShortMessageLoginParam;
import com.bite.lotterysystem.controller.param.UserPasswordLoginParam;
import com.bite.lotterysystem.controller.param.UserRegisterParam;
import com.bite.lotterysystem.controller.result.BaseUserInfoResult;
import com.bite.lotterysystem.controller.result.UserLoginResult;
import com.bite.lotterysystem.controller.result.UserRegisterResult;
import com.bite.lotterysystem.service.UserService;
import com.bite.lotterysystem.service.VerificationCodeService;
import com.bite.lotterysystem.service.dto.UserDTO;
import com.bite.lotterysystem.service.dto.UserLoginDTO;
import com.bite.lotterysystem.service.dto.UserRegisterDTO;
import com.bite.lotterysystem.service.enums.UserIdentityEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author: yibo
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private VerificationCodeService verificationCodeService;

    /**
     * 注册
     */
    // @PostMapping
    @RequestMapping("/register")
    public CommonResult<UserRegisterResult> userRegister(
            @Validated @RequestBody UserRegisterParam param) {
        // 日志打印
        logger.info("userRegister UserRegisterParam:{}", JacksonUtil.writeValueAsString(param));
        // 调用Service层服务进行访问
        UserRegisterDTO userRegisterDTO = userService.register(param);
        return CommonResult.success(convertToUserRegisterResult(userRegisterDTO));
    }

    /**
     * 发送验证码
     *
     * @param phoneNumber
     * @return
     */
    @RequestMapping("/verification-code/send")
    public CommonResult<Boolean> sendVerificationCode(String phoneNumber) {
        logger.info("sendVerificationCode phoneNumber:{}", phoneNumber);
        verificationCodeService.sendVerificationCode(phoneNumber);
        return CommonResult.success(Boolean.TRUE);
    }


    @RequestMapping("/password/login")
    public CommonResult<UserLoginResult> userPasswordLogin(
            @Validated @RequestBody UserPasswordLoginParam param) {
        logger.info("userPasswordLogin UserPasswordLoginParam:{}",
                JacksonUtil.writeValueAsString(param));
        UserLoginDTO userLoginDTO = userService.login(param);
        return CommonResult.success(convertToUserLoginResult(userLoginDTO));

    }

    /**
     * 短信验证码登录
     *
     * @param param
     * @return
     */
    @RequestMapping("/message/login")
    public CommonResult<UserLoginResult> shortMessageLogin(
            @Validated @RequestBody ShortMessageLoginParam param) {
        logger.info("shortMessageLogin ShortMessageLoginParam:{}",
                JacksonUtil.writeValueAsString(param));
        UserLoginDTO userLoginDTO = userService.login(param);
        return CommonResult.success(convertToUserLoginResult(userLoginDTO));

    }

    @RequestMapping("/base-user/find-list")
    public CommonResult<List<BaseUserInfoResult>> findBaseUserInfo(String identity) {
        logger.info("findBaseUserInfo identity:{}", identity);
        List<UserDTO> userDTOList = userService.findUserInfo(
                UserIdentityEnum.forName(identity));
        return CommonResult.success(convertToList(userDTOList));
    }

    private List<BaseUserInfoResult> convertToList(List<UserDTO> userDTOList) {
        if (CollectionUtils.isEmpty(userDTOList)) {
            return Arrays.asList();
        }

        return userDTOList.stream()
                .map(userDTO -> {
                    BaseUserInfoResult result = new BaseUserInfoResult();
                    result.setUserId(userDTO.getUserId());
                    result.setUserName(userDTO.getUserName());
                    result.setIdentity(userDTO.getIdentity().name());
                    return result;
                }).collect(Collectors.toList());

    }

    private UserLoginResult convertToUserLoginResult(UserLoginDTO userLoginDTO) {
        if (null == userLoginDTO) {
            throw new ControllerException(ControllerErrorCodeConstants.LOGIN_ERROR);
        }
        UserLoginResult result = new UserLoginResult();
        result.setToken(userLoginDTO.getToken());
        result.setIdentity(userLoginDTO.getIdentity().name());
        return result;
    }

    private UserRegisterResult convertToUserRegisterResult(UserRegisterDTO userRegisterDTO) {
        UserRegisterResult result = new UserRegisterResult();
        if (null == userRegisterDTO) {
            throw new ControllerException(ControllerErrorCodeConstants.REGISTER_ERROR);
        }
        result.setUserId(userRegisterDTO.getUserId());
        return result;
    }

}
