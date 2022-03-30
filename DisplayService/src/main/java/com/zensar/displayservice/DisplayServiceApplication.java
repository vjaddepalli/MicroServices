package com.zensar.displayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/**
 * 
 * @author Vijay
 * @EnableEurekaClient not mandatory
 * just having the dependency
 * but recommended to use annotation @EnableEurekaDiscoveryClient
 * 
 *
 */

@EnableEurekaClient
@EnableFeignClients(basePackages = "com.zensar.displayservice.feign.client")
public class DisplayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayServiceApplication.class, args);
	}

}
