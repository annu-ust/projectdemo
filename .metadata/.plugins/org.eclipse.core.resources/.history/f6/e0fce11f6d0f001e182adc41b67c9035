package com.inn.restaurant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.inn.restaurant.pojo.Bill;

public interface BillDao extends JpaRepository<Bill, Long>{

	List<Bill> getAllBills();

	List<Bill> getBillByUserName(@Param("username") String username);

}
