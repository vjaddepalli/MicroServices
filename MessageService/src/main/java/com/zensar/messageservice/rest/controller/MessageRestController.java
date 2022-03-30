package com.zensar.messageservice.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/message")
public class MessageRestController {
	
	@Value("${organization}")
	private String company;

	@GetMapping()
	public String getMessage() {

		return "Welocmoe to "+company;

	}
	
	@GetMapping("/data/{m}")
	public String getData(@PathVariable String m) {
		m=m.toUpperCase();
		return m;
	}

}
