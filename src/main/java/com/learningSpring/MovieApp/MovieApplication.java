package com.learningSpring.MovieApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
//		ApplicationContext context =
		SpringApplication.run(MovieApplication.class, args);
//		System.out.println("Check Beans");
//		String[] beanNames = context.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
	}

}