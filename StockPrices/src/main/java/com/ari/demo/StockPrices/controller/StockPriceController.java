package com.ari.demo.StockPrices.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ari.demo.StockPrices.bean.StockPrice;
import com.ari.demo.StockPrices.constant.LoggerConstants;
@RestController
public class StockPriceController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String LOGGER_CLASS = "StockPriceController :: ";
	
	Map<String, Integer>  conmapyWeightage = new HashMap<>();
	
	{
		conmapyWeightage.put("IBM", 1000);
		conmapyWeightage.put("CITI", 2000);
		conmapyWeightage.put("DEUTSCHE", 900);
		
	}
	
	@GetMapping("/price")
	public Map<String, Double> getAllCurrentStockPrice(){
		String LOGGER_METHOD = "getAllCurrentStockPrice() :: ";
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_START);
		Map<String, Double> priceMap = new HashMap<>();
		conmapyWeightage.forEach((k,v)->{
			priceMap.put(k, v*Math.random());
		});
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_END);
		return priceMap;
	}
	
	@GetMapping("/price/{companyName}")
	public StockPrice getCurrentStockPrice(@PathVariable String companyName){
		String LOGGER_METHOD = "getCurrentStockPrice() :: ";
		companyName = companyName.toUpperCase();
		double price = 0.0;
		StockPrice stockPrice = new StockPrice();
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_START);
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+" Company Name :: "+companyName);
		stockPrice.setCompanyName(companyName); 
		if(!StringUtils.isEmpty(companyName) && conmapyWeightage.containsKey(companyName)){
			Integer weightage = conmapyWeightage.get(companyName);
			price = weightage*Math.random();
			logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+" Generated Stock Price ==>> "+price);
		}else{
			logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+" ==>> Incorrect Key ==<<<<<<<<<<<<<<<<");
		}
		stockPrice.setStockPrice(price);
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_END);
		return stockPrice;
	}

}
