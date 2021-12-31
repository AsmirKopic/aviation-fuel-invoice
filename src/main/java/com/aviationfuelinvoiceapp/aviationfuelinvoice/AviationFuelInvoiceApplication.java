package com.aviationfuelinvoiceapp.aviationfuelinvoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AviationFuelInvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AviationFuelInvoiceApplication.class, args);
	}

}
