package com.retailmanager;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import com.retailmanager.model.*;

@SpringBootApplication
public class ShopLauncher {

	public static HashMap<String,Shop> hmShop;
	
	public static void main(String[] args) {
		//Initialize the list of shops with the next example
		hmShop=new HashMap<String,Shop>();
		ShopAddress add1 = new ShopAddress ("streetGodella", "46100");
		Shop one = new Shop ("FirstSupermarket", add1, "-0.412626", "39.510361");
		hmShop.put(one.getShopName(), one);
		
		SpringApplication.run(ShopLauncher.class,args);
	}
	
}
