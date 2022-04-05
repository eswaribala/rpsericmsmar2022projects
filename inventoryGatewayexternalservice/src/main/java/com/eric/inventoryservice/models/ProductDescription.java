package com.eric.inventoryservice.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Embeddable
public class ProductDescription {
	@Column(name="ProductName",nullable = false,length = 150)
	private String productName;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="Expiry_Date")
	private LocalDate expiryDate;

}
