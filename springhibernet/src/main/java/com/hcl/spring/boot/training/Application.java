package com.hcl.spring.boot.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAutoConfiguration
@ComponentScan({ "com.hcl.spring.boot.training", "com.custom.logger.custom"})

@ComponentScan
@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages={"com.hcl.spring.model"})


public class Application {

  public static void main(String[] args) {
	
	SpringApplication.run(Application.class, args);
  }

}
