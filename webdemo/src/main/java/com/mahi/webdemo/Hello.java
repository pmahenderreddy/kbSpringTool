package com.mahi.webdemo;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	private static final String template = "Hello, %s!";

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format(template, name);
	}
	
	@GetMapping("/")
	public String page() {
		return "<h1>Page ID default: Welcome-Page</h1>";
	}
	
	@GetMapping("/{id:[a-z]+}")
	public String pageLower(@PathVariable(value = "id", required = false) String id) {
		String pageId = (id == null) ? "Welcome-Page" : id;
		return "<h1>Page ID lowercase: " + pageId + "</h1>";
	}
	@GetMapping("/{id:[A-Z]+}")
	public String pageUpper(@PathVariable(value = "id", required = false) String id) {
		String pageId = (id == null) ? "Welcome-Page" : id;
		return "<h1>Page ID uppercase: " + pageId + "</h1>";
	}
	
	@GetMapping("/{id:[0-9]+}")
	public String pageNumber(@PathVariable Optional<Integer> id) {
		Integer pageId = id.orElse(1111); // Set default value
		return "<h1>Post ID ... numbers: " + pageId + "</h1>";
	}
	
//	@GetMapping("/{id:[A-Za-z0-9]+.*}")
//	public String pageMisc(@PathVariable(value = "id", required = false) String id) {
//		String pageId = (id == null) ? "Welcome-Page" : id;
//		return "<h1>Page ID misc: " + pageId + "</h1>";
//	}
	
}
