package com.blog.demo;

import com.blog.demo.repository.UniqueIdGenerator;
import com.blog.demo.repository.jpa.InMemoryUniqueIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    public UniqueIdGenerator<UUID> uniqueIdGenerator() {
        return new InMemoryUniqueIdGenerator();
    }

}
