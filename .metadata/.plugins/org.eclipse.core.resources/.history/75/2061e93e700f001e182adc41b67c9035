package com.inn.restaurant.restImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.inn.restaurant.constents.RestaurantConstents;
import com.inn.restaurant.rest.ProductRest;
import com.inn.restaurant.service.ProductService;
import com.inn.restaurant.utils.RestaurantUtils;
import com.inn.restaurant.wrapper.ProductWrapper;

@RestController
public class ProductRestImpl implements  ProductRest {

	
	@Autowired
	ProductService productservice;
	
	@Override
	public ResponseEntity<String> addNewproduct(Map<String, String> requestMap) {
		try 
		{
			return productservice.addNewProduct(requestMap);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<ProductWrapper>> getAllProduct() {
		try {
			
			return productservice.getAllProduct();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> updateproduct(Map<String, String> requestMap) {
		try {
			
			return productservice.updateProduct(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> deleteproduct(Integer id) {
		try {
			
			return productservice.deleteProduct(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> updatestatus(Map<String, String> requestMap) {
		try {
			
			return productservice.updatestatus(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<ProductWrapper>> getbycategory(Integer id) {
		try {
			return productservice.getbycategory(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<ProductWrapper> getproductbyid(Integer id) {
		try {
			return productservice.getproductbyid(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ProductWrapper(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
}
