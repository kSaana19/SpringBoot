package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.binding.Course;
import com.example.repo.CourseRepository;

@Service
public class CourseServiceimp implements CourseService {
	
	@Autowired 
	private CourseRepository courserepo;
	
    @Override
	public String upsert(Course course) {
		courserepo.save(course);  //internally perform upsert(insert /update )
		return " Success";
	}

	@Override
	public Course getbyId(Integer id) {
		Optional<Course> findById =courserepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		 return courserepo.findAll();
		
	}

	@Override
	public String deleteById(Integer id) {
		if(courserepo.existsById(id)) {
			courserepo.deleteById(id);
			return "delete success";
		}else {
			return "No record Found";
		}
		
	}

}
