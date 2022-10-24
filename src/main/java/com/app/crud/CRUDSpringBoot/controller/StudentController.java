package com.app.crud.CRUDSpringBoot.controller;

import com.app.crud.CRUDSpringBoot.entity.Student;
import com.app.crud.CRUDSpringBoot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/students")
  public String registerStudent(@ModelAttribute("student") Student student) {
    studentService.saveStudent(student);
    return "redirect:/students";
  }

  @GetMapping("/students/edit/{id}")
  public String formEditStudent(@PathVariable Integer id, Model model) {
    model.addAttribute("student",studentService.getStudentById(id));
    return "edit_student";
  }

  @PostMapping("/students/{id}")
  public String updateStudent(@PathVariable Integer id,
                              @ModelAttribute("student") Student student,
                              Model model) {
    Student existingStudent = studentService.getStudentById(id);
    existingStudent.setName(student.getName());
    existingStudent.setLastName(student.getLastName());
    existingStudent.setEmail(student.getEmail());
    studentService.updateStudent(existingStudent);
    return "redirect:/students";
  }

  @GetMapping("/students/{id}")
  public String deleteStudent(@PathVariable Integer id) {
    studentService.deleteStudent(id);
    return "redirect:/students";
  }

}
