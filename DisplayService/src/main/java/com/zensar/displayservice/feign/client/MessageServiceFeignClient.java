package com.zensar.displayservice.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 * @author Vijay
 * below annotation value is name of microservice as registered with Eureka
 *
 */
@FeignClient(value = "apigateway")
public interface MessageServiceFeignClient {
	
	/**
	 * 
	 * following method signature Must match with signature
	 * In our case this method signature MUST with MessageRestController - generateMessage()
	 * 
	 * following method name can be anything
	 * 
	 * URL pattern written here must be URL pattern of getMessage() method\
	 * 
	 */
	@GetMapping("/api/message")
	public String callGetMessage();
	
	@GetMapping("/api/message/data/{m}")
	public String callGetData(@PathVariable String m);
	
	

}
