package com.ari.demo.holdings.bean;

public class StockPrice {
	private String companyName;
	private double stockPrice;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("StockPrice [ ");
		sb.append(" companyName : ");
		sb.append(this.companyName);
		sb.append(" ; stockPrice : ");
		sb.append(this.stockPrice);
		sb.append(" ] ");
		
		return sb.toString();
	}
}
