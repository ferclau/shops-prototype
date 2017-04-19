package com.retailmanager.model;

public class Shop {

	private String shopName;
	private ShopAddress shopAddress;
	private String shopLong;
	private String shopLat;
	
	
	public Shop() {
		super();
	}
	public Shop(String shopName, ShopAddress shopAddress) {
		super();
		this.shopName = shopName;
		this.shopAddress = shopAddress;
	}
	public Shop(String shopName, ShopAddress shopAddress, String shopLong, String shopLat) {
		super();
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.shopLong = shopLong;
		this.shopLat = shopLat;
	}
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public ShopAddress getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(ShopAddress shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShopLong() {
		return shopLong;
	}
	public void setShopLong(String shopLong) {
		this.shopLong = shopLong;
	}
	public String getShopLat() {
		return shopLat;
	}
	public void setShopLat(String shopLat) {
		this.shopLat = shopLat;
	}	
	
}
