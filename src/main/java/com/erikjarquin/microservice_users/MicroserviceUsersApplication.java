package com.erikjarquin.microservice_users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
	info = @Info(title="Users API", version="v1", description = "Microservicio de Usuarios")
)

@EnableFeignClients(basePackages = "com.erikjarquin.microservice_users.client")
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUsersApplication.class, args);
	}
}