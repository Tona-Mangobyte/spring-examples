package com.mb.redis.repositories;

import com.mb.redis.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {}
