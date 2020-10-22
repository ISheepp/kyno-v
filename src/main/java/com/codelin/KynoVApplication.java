package com.codelin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.codelin.mapper")
public class KynoVApplication {

    public static void main(String[] args) {
        SpringApplication.run(KynoVApplication.class, args);
    }

}
