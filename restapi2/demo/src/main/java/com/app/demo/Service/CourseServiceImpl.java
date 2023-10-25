package com.app.demo.Service;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.Entities.Courses;
import com.app.demo.dao.CourseDao;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	//List <Courses> list;
	public CourseServiceImpl() {
		/*
		 * list = new ArrayList<>(); list.add(new
		 * Courses(145,"java core","basics of java")); list.add(new
		 * Courses(234,"j2ee","advanced java springboot"));
		 */
	}
	@Override
	public List<Courses> getCourses() 
	{
	  // return list;
		return courseDao.findAll();
	}

	
	@Override
	public Courses getCourse(long CourseId)
	{
		/*
		 * Courses c = null; for(Courses course:list) { if(course.getId()==CourseId) { c
		 * = course; break; } }
		 */
		return courseDao.getOne(CourseId);
	}
	@Override
	public Courses addCourse(Courses course) {
		/*
		 * list.add(course); return course;
		 */
		courseDao.save(course);
		return course;
	}
	@Override
	public Courses updateCourse(Courses course) {
		/*
		 * list.forEach(e -> { if(e.getId()==course.getId()) {
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription()); }
		 * });
		 */
		courseDao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(long parseLong)
	{
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect((Collectors.toList()));
	     Courses entity = courseDao.getOne(parseLong);
	     courseDao.delete(entity);
	}
	

}
