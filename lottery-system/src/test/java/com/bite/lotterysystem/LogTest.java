package com.bite.lotterysystem;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Shootingmemory
 * @create 2025-03-14-17:37
 */

@SpringBootTest
public class LogTest {
    private final static Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    void logTest() {
        System.out.println("hello world");
        logger.info("info");
    }

}