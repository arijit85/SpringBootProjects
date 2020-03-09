package com.ari.demo.StockPrices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class StockPricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPricesApplication.class, args);
	}

	@Bean
	public Sampler defaultSapmler(){
		return Sampler.ALWAYS_SAMPLE;
	}
}
