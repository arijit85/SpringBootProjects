package com.ari.demo.holdings.client;

import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ari.demo.holdings.RibbonConfiguration;
import com.ari.demo.holdings.bean.StockPrice;

//@FeignClient("stock-price")
@FeignClient("zuul-api-gateway-server")
@RibbonClient(name = "stock-price", configuration = RibbonConfiguration.class)
public interface StockPriceProxy {
	
	@GetMapping("/stock-price/market/price")
	public Map<String, Double> getAllCurrentStockPrice();
	
	@GetMapping("/stock-price/market/price/{companyName}")
	public StockPrice getCurrentStockPrice(@PathVariable(value="companyName") String companyName);

}
