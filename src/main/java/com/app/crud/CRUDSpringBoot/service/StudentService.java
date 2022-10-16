package com.app.crud.CRUDSpringBoot.service;

import com.app.crud.CRUDSpringBoot.entity.Student;

import java.util.List;

public interface StudentService {
  List<Student> listAllStudents();
}
