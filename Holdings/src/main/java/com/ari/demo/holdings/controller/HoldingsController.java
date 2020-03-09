package com.ari.demo.holdings.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ari.demo.holdings.constant.LoggerConstants;
import com.ari.demo.holdings.bean.Holding;
import com.ari.demo.holdings.bean.StockPrice;
import com.ari.demo.holdings.client.StockPriceClient;

import io.micrometer.core.instrument.util.StringUtils;

@RestController
public class HoldingsController {
	@Autowired
	StockPriceClient stockPriceClient;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String LOGGER_CLASS = "HoldingsController :: ";
	
	Map<String, Holding> holdings = new HashMap<>();
	
	{
		Holding ibmHolding = new Holding("IBM", "Indina-Book", "Hari-Portfolio", 100);
		Holding citiHolding = new Holding("Citi Bank", "Canadian-Book", "Jordon-Portfolio", 200, 85.0);
		Holding dbHolding = new Holding("Deutsche", "German-Book", "Scheumakher-Portfolio", 150, 105.50);
		
		holdings.put("IBM", ibmHolding);
		holdings.put("CITI", citiHolding);
		holdings.put("DEUTSCHE", dbHolding);
	}
	
	@GetMapping("/valuation")
	public List<Holding> getHoldings(){
		String LOGGER_METHOD = "getHoldings() :: ";
		logger.debug(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_START);
		logger.debug(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_END);
		return new ArrayList<Holding>(holdings.values());
	}
	
	@GetMapping("/valuation/{companyName}")
	public Holding getHoldingByCompany(@PathVariable String companyName){
		String LOGGER_METHOD = "getHoldingByCompany() :: ";
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_START);
		Holding holding = null;
		if(!StringUtils.isEmpty(companyName)  ){
			holding = holdings.get(companyName.toUpperCase());
			StockPrice stockPrice = stockPriceClient.getStockPrice(companyName);
			holding.setStockPrice(stockPrice.getStockPrice());
			logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+holding);			 
		}else{
			logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+"==>> Incorrect Key <<==");
		}
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_END);
		return holding;
	}

}
