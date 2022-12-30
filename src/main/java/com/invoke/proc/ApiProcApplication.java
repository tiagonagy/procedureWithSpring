package com.invoke.proc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class ApiProcApplication {

	@Autowired
	private DataDao dao;

	public static void main(String[] args) {
		SpringApplication.run(ApiProcApplication.class, args);
	}

	@Bean
	void exec() {
		dao.criarProcH2();
	}

}
