package com.inn.restaurant.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.inn.restaurant.wrapper.ProductWrapper;

public interface ProductService {

	ResponseEntity<String> addNewProduct(Map<String, String> requestMap);
	
	ResponseEntity<List<ProductWrapper>> getAllProduct();
	
	ResponseEntity<List<ProductWrapper>> getbycategory( Integer id);

	ResponseEntity<String> updateProduct(Map<String, String> requestMap);

	ResponseEntity<String> deleteProduct(Integer id);

	ResponseEntity<String> updatestatus(Map<String, String> requestMap);

	ResponseEntity<ProductWrapper> getproductbyid(Integer id);

}
