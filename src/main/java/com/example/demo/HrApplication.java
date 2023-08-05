package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.RegionRepository;
import com.example.demo.services.EmployeeService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.RegionRepository;
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
public class HrApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RegionRepository regionRepository;
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Hello World");
//	//	employeeService.findCountAll();
//		System.out.println("End");
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {

	            registry.addMapping("/**")
	                    .allowedOrigins("*")
	                    .allowedMethods("*")
	                    .allowedHeaders("*");

	        }
	    };
	}

}
