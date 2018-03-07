package xyz.nesting.example;

import java.math.BigDecimal;
import java.util.Arrays;

import org.bson.types.Decimal128;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// mvn spring-boot:run -Drun.arguments=--spring.profiles.active=prod
		SpringApplication.run(Application.class, args);
	}
	
}
