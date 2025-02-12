package com.mahi.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.app.entities.Course;

@RestController
public class CourseController {

	private static final String template = "Hello, %s!";

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format(template, name);
	}

	@GetMapping("/course/")
	public String course() {
		return "<h1>Welcome-Page</h1>";
	}

	@GetMapping("/course/{id}")
	public String course(@PathVariable(value = "id", required = false) String id) {
		String pageId = (id == null) ? "Welcome-Page" : id;
		return "<h1>Course Page: " + pageId + "</h1>";
	}

	@GetMapping("/course/all")
	public List<Course> courses() {
		return Arrays.asList(new Course("1", "Learn Java", "Srisailam K"),
				new Course("2", "Learn Spring", "Rajkumar P"), new Course("3", "Learn Security", "Pavan S"));
	}

}
