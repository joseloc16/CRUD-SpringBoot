package com.app.crud.CRUDSpringBoot.service.impl;

import com.app.crud.CRUDSpringBoot.entity.Student;
import com.app.crud.CRUDSpringBoot.repository.StudentRepo;
import com.app.crud.CRUDSpringBoot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepo studentRepo;


  @Override
  public List<Student> listAllStudents() {
    return studentRepo.findAll();
  }

  @Override
  public Student saveStudent(Student student) {
    return studentRepo.save(student);
  }

}
