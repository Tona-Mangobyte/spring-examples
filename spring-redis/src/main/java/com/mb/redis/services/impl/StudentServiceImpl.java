package com.mb.redis.services.impl;

import com.mb.redis.models.Student;
import com.mb.redis.repositories.StudentRepository;
import com.mb.redis.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Iterable<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}
