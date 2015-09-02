package org.test.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.test.boot.security.SecurityConfiguration;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.test.hibernate.repositories", "org.test.jpa.repositories"})
@EnableTransactionManagement
@ComponentScan(basePackages = "org.test")
@Import(SecurityConfiguration.class)
public class TestBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBootApplication.class, args);
	}
}
