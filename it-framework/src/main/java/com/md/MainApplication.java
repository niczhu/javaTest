package com.md;

import com.md.mp.MpApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TestApplication
 *
 * @author zhuhaipeng6 in 2020/7/10 18:49
 * @version 1.0
 **/
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpApplication.class, args);
    }
}
