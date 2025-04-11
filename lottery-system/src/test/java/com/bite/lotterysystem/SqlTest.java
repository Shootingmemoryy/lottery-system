package com.bite.lotterysystem;

import com.bite.lotterysystem.dao.dataobject.Encrypt;
import com.bite.lotterysystem.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Shootingmemory
 * @create 2025-03-16-23:03
 */
@SpringBootTest
public class SqlTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    void mailCount() {
        int count = userMapper.countByMail("123@qq.com");
        System.out.println("mailCount=" + count);
    }
    @Test
    void phoneCount() {
        int count = userMapper.countByPhone(new Encrypt("13111111111"));
        System.out.println("phoneCount=" + count);
    }
}
