package com.mb.redis;


import com.mb.redis.models.Student;
import com.mb.redis.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
@Slf4j
public class RedisApplication implements ApplicationRunner {
    public static void main( String[] args )
    {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName("Tona");
        student.setAddress("PP");
        Student saved = studentService.save(student);
        log.info("Student Id {}", saved.getId());
    }

    @Autowired
    private StudentService studentService;
}
