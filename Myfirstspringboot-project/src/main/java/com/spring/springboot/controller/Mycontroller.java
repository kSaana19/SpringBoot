package com.spring.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

	@GetMapping("/")
	public String myhello()
	{
		return "hello welcome to my first spring boot application";
	}
}
