package com.zensar.displayservice.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.displayservice.feign.client.MessageServiceFeignClient;
import com.zensar.displayservice.service.impl.DisplayServiceImpl;

@RestController
@RequestMapping("/api/display")
@RefreshScope
public class DisplayRestController {

	//todo make necessary changes  so that this property is accessible here DisplayService
	
	@Value("${organization}")
	private String company;
	
	@Autowired
	private DisplayServiceImpl service;

	@GetMapping()
	public String getMessage() {
		System.out.println("From DisplayRestController");
		String response=service.fetchData();
		return "Message From message service is :"+response+" and "+this.company;
	}
	
//	@GetMapping("/data/{msg}")
//	public String getData(@PathVariable String msg) {
//	
//		String response ="";
//		return "Data From message service is : " + response;
//		
//	}

}
