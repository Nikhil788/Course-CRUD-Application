package com.app.demo.Service;

import java.util.List;

import com.app.demo.Entities.Courses;

public interface CourseService {
	
	public List<Courses> getCourses();
	
	public Courses getCourse(long CourseId);

	public Courses addCourse(Courses course);

	public Courses updateCourse(Courses course);

	public void deleteCourse(long parseLong);

}
