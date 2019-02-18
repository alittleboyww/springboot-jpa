package com.springboot.hibernatejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;

@ComponentScan(basePackages = {"com.springboot.hibernatejpa"})//扫描改包路径下的所有spring组件
@EnableJpaRepositories("com.springboot.hibernatejpa.dao")//JPA扫描该包路径下的Repositorie
@EntityScan("com.springboot.hibernatejpa.model")//扫描实体类
@SpringBootApplication
@EnableScheduling
public class HibernateJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}

	@RequestMapping("/")
	public String index(){
		return "hello spring boot";
	}
}
