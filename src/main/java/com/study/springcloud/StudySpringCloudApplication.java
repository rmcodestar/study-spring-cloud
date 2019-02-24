package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableMongoAuditing
@SpringBootApplication
public class StudySpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringCloudApplication.class, args);
    }

}

