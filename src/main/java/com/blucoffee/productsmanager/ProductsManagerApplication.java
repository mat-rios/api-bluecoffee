package com.blucoffee.productsmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RestController
@SpringBootApplication
public class ProductsManagerApplication {

	@RequestMapping("/")
	public String home() {
		return "Rest BlueCoffeeApi";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductsManagerApplication.class, args);
	}

}
