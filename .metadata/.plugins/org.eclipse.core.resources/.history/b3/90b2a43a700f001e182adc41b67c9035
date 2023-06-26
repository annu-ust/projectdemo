package com.inn.restaurant.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.inn.restaurant.rest.DashboardRest;
import com.inn.restaurant.service.DashboardService;

@RestController
public class DashboardRestImpl implements DashboardRest{
	@Autowired
	DashboardService dashboardservice;

	@Override
	public ResponseEntity<Map<String, Object>> getCount() {
		return dashboardservice.getCount();
	}

}
