package com.mb.redis.services;

import com.mb.redis.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Iterable<Student> findAll();
    Optional<Student> findById(String id);
    Student save(Student student);
    void deleteById(String id);
}
