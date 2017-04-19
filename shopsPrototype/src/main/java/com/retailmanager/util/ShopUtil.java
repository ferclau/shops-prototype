package com.retailmanager.util;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.util.CollectionUtils;

import com.retailmanager.model.Shop;
import com.retailmanager.model.ShopAddress;


public class ShopUtil {

	//Post a shop (new or update)
	public static String postShop (final String shopName, final ShopAddress address, final HashMap<String, Shop> hmShop) {
		Shop shop = hmShop.get(shopName);
		String response = new String();
		if (shop == null) {
			addShop(shopName, address, hmShop);
			response = "New Shop created";
		} else {
			updateShop(shop, address);
			response = "Shop " + shop.getShopName() + " updated";
		}
		return response;
	}
	
	private static void addShop(final String shopName, final ShopAddress address, final HashMap<String, Shop> hmShop) {
		hmShop.put(shopName, new Shop(shopName, address));
	}

	private static void updateShop(Shop shop, ShopAddress address) {
		shop.setShopAddress(address);

	}
	
	//Get the nearest shop to the customer position
	public static Shop getNearest(String lat, String lng, Collection<Shop> collection) {
		Shop nearestShop = null;

		if (!CollectionUtils.isEmpty(collection)) {

			double closestDistance = Double.MAX_VALUE;
			
			for (Shop shop : collection){
				double distance = Haversine.distance(Double.parseDouble(lat), Double.parseDouble(lng), Double.parseDouble((shop).getShopLat()), Double.parseDouble((shop).getShopLong()));
				if (distance < closestDistance) {
					closestDistance = distance;
					nearestShop = shop;
				}
			}
		}
		
		else
		{
			System.out.println("There aren't shops");
		}		
		return nearestShop;
	}	
}
