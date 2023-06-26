package com.inn.restaurant.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@NamedQuery(name ="Bill.getAllBills",query="select b from Bill b order by b.id desc")
@NamedQuery(name="Bill.getBillByUserName", query="select b from Bill b where b.createdby=:username order by b.id desc")

//@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="bill")
public class Bill implements Serializable {


	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@Column(name="id")
	private Long id;
	
	@Column(name="uuid")
	private Long uuid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contactnumber")
	private String contactNumber;
	
	@Column(name="paymentmethod")
	private String paymentmethod;
	
	@Column(name="total")
	private double total;
	
	@Column(name="productdetails",columnDefinition="json")
	private String productdetails;
	
	@Column(name="createdby")
	private String createdby;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getProductdetails() {
		return productdetails;
	}

	public void setProductdetails(String productdetails) {
		this.productdetails = productdetails;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Bill(Long id, Long uuid, String name, String email, String contactNumber, String paymentmethod, double total,
			String productdetails, String createdby) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.paymentmethod = paymentmethod;
		this.total = total;
		this.productdetails = productdetails;
		this.createdby = createdby;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
