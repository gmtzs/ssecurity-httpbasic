package com.utils.example.ssecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="testapi")
@Slf4j
public class RestService {
	
	
	
	@GetMapping
	public String user(@RequestParam(value="name", defaultValue = "World!!") String name) {
		log.debug("path User  RequestName: " + name);
		return String.format("Hello %s !! ",name) ;
	}

	
	@GetMapping("/admin")
	public String noAuth() {
		return "Hello World Admin!!!";
	}

	
	
}
