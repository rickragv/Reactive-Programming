package com.here.kafka.kafka.basics;

import com.here.kafka.kafka.producer.Sender;
import com.here.kafka.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan(basePackages = {"com.here.kafka"})
public class Application {

@Autowired
private Sender sender;

@PostConstruct
public void init(){
	sender.send("json.t",new Data("2","hello"));
}
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		System.out.println("hello");

		//sender.send("Java","Hello");
	}
}
