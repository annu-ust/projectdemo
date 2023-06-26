package com.inn.restaurant.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inn.restaurant.pojo.Bill;

@RequestMapping("/bill")
public interface BillRest {
	
	@PostMapping("/generatereport")
	ResponseEntity<String> generateReport(@RequestBody Map<String, Object> requestMap);
	
	@PostMapping("/getpdf")
	ResponseEntity<byte[]> getpdf(@RequestBody Map<String, Object> requestMap);
	
	@PostMapping("/delete/{id}")
	ResponseEntity<String> deleteBill(@PathVariable Long id);
	
	@GetMapping("/getbills")
	ResponseEntity<List<Bill>> getBills();

}
