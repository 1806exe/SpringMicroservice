package com.dto.commands;

import java.math.BigDecimal;

public class OrderCreateDTO {
	
	
	private String itemType;
	private BigDecimal price;
	private String currency;
	
	
	private String getItemType() {
		return itemType;
	}


	public OrderCreateDTO() {
		super();
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	@Override
	public String toString() {
		return "OrderCreateDTO [itemType=" + itemType + ", price=" + price + ", currency=" + currency + "]";
	}
	
	

}

// 5zWWJ7