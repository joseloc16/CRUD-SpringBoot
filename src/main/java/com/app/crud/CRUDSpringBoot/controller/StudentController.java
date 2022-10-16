package com.app.crud.CRUDSpringBoot.controller;

import com.app.crud.CRUDSpringBoot.entity.Student;
import com.app.crud.CRUDSpringBoot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @GetMapping({"/students","/"})
  public String listStudents(Model model) {
    model.addAttribute("students", studentService.listAllStudents());
    return "students"; //retorna el archivo students
  }

  @GetMapping("/students/register")
  public String formRegisterStudent(Model model) {
    Student student = new Student();
    model.addAttribute("student", student);
    return "register_student";
  }


}
