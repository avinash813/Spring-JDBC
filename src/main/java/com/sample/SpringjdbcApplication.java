package com.sample;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sample.Employee.Employee;
import com.sample.dao.Dao;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringjdbcApplication.class, args);
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
	    Dao daoObj = context.getBean(Dao.class);
	    
//	    daoObj.operation().forEach(x->System.out.println(x));
	    
	    List<Employee> emp = daoObj.operation();
	    System.out.println(emp);
	    
	}

}
