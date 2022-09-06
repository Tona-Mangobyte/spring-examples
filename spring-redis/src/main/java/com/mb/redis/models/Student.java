package com.mb.redis.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@RedisHash("students")
public class Student implements Serializable {
    private String id;
    private String name;
    private String address;
}
