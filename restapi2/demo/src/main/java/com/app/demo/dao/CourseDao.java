package com.app.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.Entities.Courses;

public interface CourseDao extends JpaRepository<Courses, Long>{

	List<Courses> findAll();

}
