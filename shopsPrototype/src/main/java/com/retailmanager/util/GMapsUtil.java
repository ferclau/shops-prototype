package com.retailmanager.util;

import java.io.IOException;


import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.retailmanager.model.Shop;
import com.google.maps.model.GeocodingResult;

//Set Longitud and Latitude with the address provided using Google Maps API
public class GMapsUtil {

	static final String API_KEY = "AIzaSyCWbegXMFJ9M6-2bEJ9nmTftdRAKFytqKU";
		
	public static void setLongLat(Shop shop){
		
		GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
		GeocodingResult[] geoRes;
		try {
			geoRes = GeocodingApi.geocode(context, shop.getShopAddress().getNumber() + shop.getShopAddress().getPostCode()).await();
			String latitude = String.valueOf(geoRes[0].geometry.location.lat); 
			String longitude = String.valueOf(geoRes[0].geometry.location.lng);
			shop.setShopLat(latitude);
			shop.setShopLong(longitude);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
