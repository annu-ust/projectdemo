package com.inn.restaurant.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.inn.restaurant.pojo.Bill;

public interface BillService {

	ResponseEntity<String> generateReport(Map<String, Object> requestMap);

	ResponseEntity<List<Bill>> getBills();

	ResponseEntity<byte[]> getpdf(Map<String, Object> requestMap);

	ResponseEntity<String> deleteBill(Long id);

}
