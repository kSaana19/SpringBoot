package com.example.Service;

import java.util.List;

import com.example.demo.binding.Course;


public interface CourseService {
	
	public String upsert(Course course);
	public Course getbyId(Integer id);
	public List<Course> getAllCourses();
	public String deleteById(Integer id);

}
