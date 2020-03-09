package com.ari.demo.holdings.client;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ari.demo.holdings.bean.StockPrice;
import com.ari.demo.holdings.constant.LoggerConstants;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@Component
public class StockPriceClient {
	
	@Autowired
	StockPriceProxy stockPriceProxy;	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String LOGGER_CLASS = "StockPriceClient :: ";

	/**
	 * This method gets Compnay's stock price from the
	 * StockPrice application dynamically
	 * 
	 * @param companyName
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "defaultPrice",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
					//@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
			})
	public StockPrice getStockPrice(String companyName){
		String LOGGER_METHOD = "getStockPrice() :: ";
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_START);
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+" Thread Name $$$ "+Thread.currentThread().getName());
		StockPrice stockPrice = stockPriceProxy.getCurrentStockPrice(companyName);	
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+" Response received ==> "+stockPrice);
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+" Thread Name $$$ "+Thread.currentThread().getName());
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_END);
		return stockPrice;
		
	}
	
	/**
	 * This is the Fall back method of getStockPrice(String)
	 * Hence, it should have same signature as getStockPrice(String)
	 * 
	 * @param companyName
	 * @return
	 */
	public double defaultPrice(String companyName){
		String LOGGER_METHOD = "defaultPrice() :: ";
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_START);
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+" Thread Name $$$ "+Thread.currentThread().getName());
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+" Company Name =="+companyName);
		double price = 0.0;
		switch(companyName.toUpperCase()){
			case "IBM":
				price = 55.55;
				break;
			case "CITI":
			    price = 66.66;
			    break;
			case "DEUTSCHE":
				price = 77.77;
				break;
		}
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+" Thread Name $$$ "+Thread.currentThread().getName());
		logger.info(LoggerConstants.LOGGER_MOULE+LOGGER_CLASS+LOGGER_METHOD+LoggerConstants.LOGGER_END);
		return price;
	}
	
	public Map<String, Double> getAllStockPrice(){
		return null;
	}

}
