package com.anyang.management.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling  //定时任务
@EnableAsync //异步操作
@EnableJpaAuditing //jpa
@ComponentScan(basePackages = {"com.anyang.management.platform.utils"})
@SpringBootApplication
@EntityScan(basePackages = {"com.anyang.management.platform.domain"})
@EnableJpaRepositories(basePackages = {"com.anyang.management.platform.repository"})
public class ManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }
}
