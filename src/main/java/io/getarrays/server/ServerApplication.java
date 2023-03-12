package io.getarrays.server;

import io.getarrays.server.model.Product;
import io.getarrays.server.repo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServerApplication.class, args);
	}
	@Bean
	CommandLineRunner run(ProductRepo productRepo) {
		return args -> {
			productRepo.save(new Product(null,"Apple",10.00,true));
			productRepo.save(new Product(null,"Shoes",20.00,false));
			productRepo.save(new Product(null,"Watch",30.00,true));
		};
	}

}
