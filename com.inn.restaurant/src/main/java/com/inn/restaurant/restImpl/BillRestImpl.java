package com.inn.restaurant.restImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.inn.restaurant.constents.RestaurantConstents;
import com.inn.restaurant.pojo.Bill;
import com.inn.restaurant.rest.BillRest;
import com.inn.restaurant.service.BillService;
import com.inn.restaurant.utils.RestaurantUtils;

@RestController
public class BillRestImpl implements BillRest{

	
	@Autowired
	BillService billservice;
	
	@Override
	public ResponseEntity<String> generateReport(Map<String, Object> requestMap) {
		try {
			return billservice.generateReport(requestMap);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<Bill>> getBills() {
		try {
			return billservice.getBills();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}return null;
	}

	@Override
	public ResponseEntity<byte[]> getpdf(Map<String, Object> requestMap) {
		
		try {
			
			return billservice.getpdf(requestMap);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}return null;
	}

	@Override
	public ResponseEntity<String> deleteBill(Long id) {
		try {
			
			return billservice.deleteBill(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
