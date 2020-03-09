package com.ari.demo.holdings.bean;

public class Holding {
	private String companyName;
	private String bookName;
	private String portfolioName;
	private int numberOfShares;
	private double stockPrice;
	
	// Default no-argument constructor;
	public Holding(){}
	
	public Holding(String companyName, String bookName, String portfolioName, int numberOfShares){
		this.companyName = companyName;
		this.bookName = bookName;
		this.portfolioName = portfolioName;
		this.numberOfShares = numberOfShares;
	}
	
	public Holding(String companyName, String bookName, String portfolioName, int numberOfShares, double stockPrice){
		this(companyName, bookName, portfolioName, numberOfShares);
		this.stockPrice = stockPrice;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
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
		sb.append("Holding [ ");
		sb.append(" companyName : ");
		sb.append(this.companyName);
		sb.append(" ; bookName : ");
		sb.append(this.bookName);
		sb.append(" ; portfolioName : ");
		sb.append(this.portfolioName);
		sb.append(" ; numberOfShares : ");
		sb.append(this.numberOfShares);
		sb.append(" ; stockPrice : ");
		sb.append(this.stockPrice);
		sb.append(" ] ");
		
		return sb.toString();
	}

}
