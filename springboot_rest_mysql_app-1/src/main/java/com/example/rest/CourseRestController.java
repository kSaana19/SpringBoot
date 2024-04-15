package com.example.rest;

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

import com.example.Service.CourseService;
import com.example.demo.binding.Course;

@RestController
public class CourseRestController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<String>  createCourse(@RequestBody Course course){
		String status = courseService.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<Course>getCourse(@PathVariable Integer id){
		Course course = courseService.getbyId(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@GetMapping("/course")
	public ResponseEntity<List<Course>> getAllCourses(){
		List<Course> allcourses = courseService.getAllCourses();
		return new ResponseEntity<>(allcourses, HttpStatus.OK);
	}
	
	@PutMapping("/course")
	public ResponseEntity<String>  updateCourse(@RequestBody Course course){
		String status = courseService.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.OK);
	
	}
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Course>deleteCourse(@PathVariable Integer id){
		String status = courseService.deleteById(id);
		return new ResponseEntity(status, HttpStatus.OK);
	}
	
}
	
	
	

