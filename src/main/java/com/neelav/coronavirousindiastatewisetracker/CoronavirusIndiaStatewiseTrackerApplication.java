package com.neelav.coronavirousindiastatewisetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronavirusIndiaStatewiseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusIndiaStatewiseTrackerApplication.class, args);
	}

}
