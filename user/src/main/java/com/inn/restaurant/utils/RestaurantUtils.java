package com.inn.restaurant.utils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Strings;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

//import com.google.gson.JsonArray;
@Slf4j
public class RestaurantUtils {
	public  final static String SOMETHING_WENT_WRONG = null;
	private RestaurantUtils() {
		
	}
	public static ResponseEntity<String> getResponseEntity(String responseMessage , HttpStatus httpStatus){
		return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}",httpStatus);
	}

	public static String getuid() {
		Date date = new Date();
		long time =date.getDate();
		return "Bill+" + time;
	}
	

	public static JSONArray getjsonArrayFromString(String data) throws Exception{
		JSONArray jsonarray= new JSONArray(data);
		return jsonarray;
	}
	public static Map<String, Object> getMapFromJson(String data){
		if(!Strings.isNullOrEmpty(data)) {
			return new Gson().fromJson(data,new TypeToken<Map<String, Object>>(){
				
			}.getType());
		}
		return new HashMap<>();	
	}
	public static boolean isFileExist(String path) {
		
//		log.info("inside isFileExist {}", path);
		try {
			File file =new File(path);
			return (file!= null &&  file.exists()) ? Boolean.TRUE :Boolean.FALSE;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}return false;
	}
}
