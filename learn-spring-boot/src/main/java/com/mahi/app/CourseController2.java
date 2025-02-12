package com.mahi.app;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mahi.app.entities.Course;

@Controller
public class CourseController2 {

	@GetMapping("/course/list")
	public String coursesList(Model model) {
		model.addAttribute("courses", Arrays.asList(new Course("1", "Learn Java", "Srisailam K"),
				new Course("2", "Learn Spring", "Rajkumar P"), new Course("3", "Learn Security", "Pavan S")));
		return "listCourses";
	}

}
