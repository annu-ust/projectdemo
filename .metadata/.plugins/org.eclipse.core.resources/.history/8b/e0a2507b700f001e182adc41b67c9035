package com.inn.restaurant.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inn.restaurant.dao.BillDao;
import com.inn.restaurant.dao.CategoryDao;
import com.inn.restaurant.dao.ProductDao;
import com.inn.restaurant.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService{

	@Autowired
	CategoryDao categorydao;
	
	@Autowired
	ProductDao productdao;
	
	@Autowired
	BillDao billdao;
	
	
	@Override
	public ResponseEntity<Map<String, Object>> getCount() {
		Map<String, Object> map =new HashMap<>();
		map.put("Category", categorydao.count());
		map.put("Product", productdao.count());
		map.put("Bill", billdao.count());
		
		return new ResponseEntity<>(map ,HttpStatus.OK);
	}

}
