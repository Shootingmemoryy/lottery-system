package com.bite.lotterysystem;

import com.bite.lotterysystem.service.UserService;
import com.bite.lotterysystem.service.dto.UserDTO;
import com.bite.lotterysystem.service.enums.UserIdentityEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-03-26-23:02
 */
@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    void findBaseUserList() {

        List<UserDTO> userDTOList = userService.findUserInfo(UserIdentityEnum.ADMIN);
        for (UserDTO userDTO : userDTOList) {
            System.out.println(userDTO.getUserId() + " " + userDTO.getUserName() + " " + userDTO.getIdentity().name());
        }
    }

}