package com.aviationfuelinvoiceapp.aviationfuelinvoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication  //(exclude = SecurityAutoConfiguration.class)
public class AviationFuelInvoiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AviationFuelInvoiceApplication.class, args);
	}

}
