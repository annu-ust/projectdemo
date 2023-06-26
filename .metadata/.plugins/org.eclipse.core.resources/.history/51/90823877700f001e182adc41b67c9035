package com.inn.restaurant.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inn.restaurant.JWT.JwtFilter;
import com.inn.restaurant.constents.RestaurantConstents;

import com.inn.restaurant.dao.ProductDao;
import com.inn.restaurant.pojo.Category;
import com.inn.restaurant.pojo.Product;
import com.inn.restaurant.service.ProductService;

import com.inn.restaurant.utils.RestaurantUtils;
import com.inn.restaurant.wrapper.ProductWrapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productdao;
	
	@Autowired
	JwtFilter jwtfilter;
	
	@Override
	public ResponseEntity<String> addNewProduct(Map<String, String> requestMap) {
		try {
			
			
			if(jwtfilter.isAdmin()) {
				if(validateProductMap(requestMap, false)) {
					
					productdao.save(getProductFromMap(requestMap, false));
					return RestaurantUtils.getResponseEntity("Product added succesfully", HttpStatus.OK);
					
				}
				return RestaurantUtils.getResponseEntity(RestaurantConstents.INVALID_DATA, HttpStatus.BAD_REQUEST);
				
			}else {
				
				return RestaurantUtils.getResponseEntity(RestaurantConstents.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			
		}return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	

	private boolean validateProductMap(Map<String, String> requestMap, boolean validateId) {
		
		if(requestMap.containsKey("name")) {
			if(requestMap.containsKey("id") && validateId) {
				return true;
			}
			else if(!validateId){
				
				return true;
				
			}
			
		}return false;
	}
	private Product getProductFromMap(Map<String, String> requestMap, boolean isAdd) {
		
		Category category = new Category();
		category.setId(Integer.parseInt(requestMap.get("CategoryId")));
		Product product =new Product();
		if(isAdd){
			product.setId(Integer.parseInt(requestMap.get("id")));
		}
		else {
			product.setStatus("true");
		}
		product.setCategory(category);
		product.setName(requestMap.get("name"));
		product.setDescription(requestMap.get("description"));
		product.setPrice(requestMap.get("price"));
		return product;
		
		
		
	}



	@Override
	public ResponseEntity<List<ProductWrapper>> getAllProduct() {
		try {
			return new ResponseEntity<>(productdao.getAllProduct(),HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new  ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}



	@Override
	public ResponseEntity<String> updateProduct(Map<String, String> requestMap) {
		try {
			
			if(jwtfilter.isAdmin()) {
				if(validateProductMap(requestMap,true)) {
					
					Optional<Product> optional= productdao.findById(Integer.parseInt(requestMap.get("id")));
					if(!optional.isEmpty()) {
						Product product = getProductFromMap(requestMap, true);
						product.setStatus(optional.get().getStatus());
						productdao.save(product);
						return RestaurantUtils.getResponseEntity("product updated" , HttpStatus.OK);
						
					}else {
						return RestaurantUtils.getResponseEntity("product id doesnot exit", HttpStatus.OK);
					}
					
				}else {
					return RestaurantUtils.getResponseEntity(RestaurantConstents.UNAUTHORIZED_ACCESS, HttpStatus.BAD_REQUEST);
				}
				
			}return RestaurantUtils.getResponseEntity(RestaurantConstents.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}



	@Override
	public ResponseEntity<String> deleteProduct(Integer id) {
		try {
			if(jwtfilter.isAdmin()) {
				Optional optional= productdao.findById(id);
				if(!optional.isEmpty()) {
					productdao.deleteById(id);
					return RestaurantUtils.getResponseEntity("product deleted succesfully", HttpStatus.OK);
					
				}else {
					
				}return RestaurantUtils.getResponseEntity("product id doesnot exit", HttpStatus.OK);
				
			}else {
				
			}return RestaurantUtils.getResponseEntity(RestaurantConstents.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}



	@Override
	public ResponseEntity<String> updatestatus(Map<String, String> requestMap) {
		try {
			if(jwtfilter.isAdmin()) {
				
			 Optional optional =productdao.findById(Integer.parseInt(requestMap.get("id")));
			 if(!optional.isEmpty()) {
					productdao.updateProductStatus(requestMap.get("status"), Integer.parseInt(requestMap.get("id")));
					return RestaurantUtils.getResponseEntity("product status updated succesfully", HttpStatus.OK);
					
				}else {
					
				}return RestaurantUtils.getResponseEntity("product id doesnot exit", HttpStatus.OK);
			}else {
				return RestaurantUtils.getResponseEntity(RestaurantConstents.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}



	@Override
	public ResponseEntity<List<ProductWrapper>> getbycategory(Integer id) {
		try {
			return new ResponseEntity<>(productdao.getProductByCategory(id), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}



	@Override
	public ResponseEntity<ProductWrapper> getproductbyid(Integer id) {
	
		try {
			return new ResponseEntity<>(productdao.getproductbyid(id),HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ProductWrapper(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
