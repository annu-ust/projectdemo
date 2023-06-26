package com.inn.restaurant.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inn.restaurant.wrapper.ProductWrapper;

@RequestMapping("/product")
public interface ProductRest {
	
	@PostMapping("/add")
	ResponseEntity<String> addNewproduct(@RequestBody Map<String, String> requestMap);
	
	@PostMapping("/update")
	ResponseEntity<String> updateproduct(@RequestBody Map<String, String> requestMap);
	
	@PostMapping("/updatestatus")
	ResponseEntity<String> updatestatus(@RequestBody Map<String, String> requestMap);
	
	@PostMapping("/delete/{id}")
	ResponseEntity<String> deleteproduct(@PathVariable Integer id);
	
	
	@GetMapping("/get")
	ResponseEntity<List<ProductWrapper>> getAllProduct();
	
	@GetMapping("/getbycategory/{id}")
	ResponseEntity<List<ProductWrapper>> getbycategory(@PathVariable Integer id);
	
	@GetMapping("/getbyid/{id}")
	ResponseEntity<ProductWrapper> getproductbyid(@PathVariable Integer id);

}
