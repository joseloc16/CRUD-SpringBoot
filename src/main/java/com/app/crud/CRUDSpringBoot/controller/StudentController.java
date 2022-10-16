package com.app.crud.CRUDSpringBoot.controller;

import com.app.crud.CRUDSpringBoot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

  private StudentService studentService;

  @GetMapping({"/students","/"})
  public String listStudents(Model model) {
    model.addAttribute("students", studentService.listAllStudents());
    return "students"; //retorna el archivo students
  }
}
