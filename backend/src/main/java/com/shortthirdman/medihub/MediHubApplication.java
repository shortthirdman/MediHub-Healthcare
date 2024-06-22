package com.shortthirdman.medihub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableKafka
@EnableJpaAuditing
@EnableJpaRepositories
@EnableAspectJAutoProxy
@EnableSpringDataWebSupport
@EnableTransactionManagement
@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"com.shortthirdman.medihub.*"})
public class MediHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediHubApplication.class, args);
	}

}
