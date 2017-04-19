package com.retailmanager.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailmanager.ShopLauncher;
import com.retailmanager.model.Shop;
import com.retailmanager.util.GMapsUtil;
import com.retailmanager.util.ShopUtil;

@RestController
public class ShopController {
	//Get Method that list all shops
	@RequestMapping(value="/shops", method = RequestMethod.GET)
	public HashMap<String, Shop> getAllShops(){
		return ShopLauncher.hmShop;
	}
	
	//Post Method that add/update a shop
	@RequestMapping(value="/shops", method = RequestMethod.POST)
	@ResponseBody
	public String addShop(@RequestBody Shop shop){
		String response = new String();
		if (shop != null) {
			response = ShopUtil.postShop(shop.getShopName(), shop.getShopAddress(), ShopLauncher.hmShop);
			GMapsUtil.setLongLat(ShopLauncher.hmShop.get(shop.getShopName()));
		}
		return response;
	}
	
	//Get Method that return the nearest shop
	@RequestMapping(value="/closestStore", method=RequestMethod.GET)
	public String getNearestShop(@RequestParam("customerLat") String latitude, @RequestParam("customerLong") String longitude) {
		String response = null;
		Shop shopn = ShopUtil.getNearest(latitude, longitude, ShopLauncher.hmShop.values());
		response = "Shop: " + shopn.getShopName() + ". Latitude: " + shopn.getShopLat() +", Longitude: " + shopn.getShopLong();
		return response;
		
	}
}
