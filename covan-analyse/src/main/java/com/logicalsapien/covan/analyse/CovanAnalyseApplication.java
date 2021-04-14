package com.logicalsapien.covan.analyse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class CovanAnalyseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovanAnalyseApplication.class, args);
	}

}
