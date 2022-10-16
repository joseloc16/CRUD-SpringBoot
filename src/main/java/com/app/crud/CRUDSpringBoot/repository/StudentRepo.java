package com.app.crud.CRUDSpringBoot.repository;

import com.app.crud.CRUDSpringBoot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
