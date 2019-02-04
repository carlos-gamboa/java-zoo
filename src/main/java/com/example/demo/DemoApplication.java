package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.stockZoo(15, 4);
		zoo.openZoo();
	}

}

