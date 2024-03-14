package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase")
@EnableFeignClients

public class N11TalentHubBackendBootcampFinalCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(N11TalentHubBackendBootcampFinalCaseApplication.class, args);
	}

}
