package com.zensar.displayservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.displayservice.feign.client.MessageServiceFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class DisplayServiceImpl {
	
	@Autowired
	private MessageServiceFeignClient feignClient;
	
	@CircuitBreaker(name="messageservice", fallbackMethod = "handle")
	public String fetchData() {
		
		/**
         * Following call is making network call so it is risky , it might not work
         * String response = feignClient.callGenerateMessage();
         * e.g. Message service is down. If it is DeisplayService also will not work and if any other service calling display service
         * It won't work too, THis is cascading failure.
         * We don't want this situation in our application
         * So what is the solution?
         * Spring cloud gives you solution known as - CircuitBreaker/Fault Tolerance
         *
         * Fault Tolerance?
         *      It is ability of the system to work without problems despite of failures of one/more of its components
         */
		
		
		return feignClient.callGetMessage();
		
	}
	
	public String handle(Throwable t) {
		return "this is default message";
		
	}

}
