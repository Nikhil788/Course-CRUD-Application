package com.app.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.Entities.Courses;
import com.app.demo.Service.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home()
	{
		return "welcome to courses application";
	}
	
	//get the courses
	
	@GetMapping("/courses")
	public List <Courses> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	
	@GetMapping("/courses/{courseId}")
	public Courses getcourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	//course add
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses Course)
	{
		return this.courseService.addCourse(Course);
	}
	//update course
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses course)
	{
		return this.courseService.updateCourse(course);
		
	}
	//delete course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse (@PathVariable String courseId)
	{
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
			}
		catch ( Exception e )
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
