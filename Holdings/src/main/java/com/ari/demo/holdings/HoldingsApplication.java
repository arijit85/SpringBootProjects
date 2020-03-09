package com.ari.demo.holdings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class HoldingsApplication {	
	

	public static void main(String[] args) {
		SpringApplication.run(HoldingsApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSapmler(){
		return Sampler.ALWAYS_SAMPLE;
	}
	
	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}*/
	
	/*@Bean
	public StockPriceClient stockPriceClient(){
		return new StockPriceClient();
	}*/
 
    

}
