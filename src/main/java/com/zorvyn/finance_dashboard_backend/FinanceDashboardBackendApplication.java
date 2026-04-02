package com.zorvyn.finance_dashboard_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class FinanceDashboardBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceDashboardBackendApplication.class, args);
	}

}
