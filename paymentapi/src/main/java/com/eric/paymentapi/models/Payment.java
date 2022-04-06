package com.eric.paymentapi.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	private long transactionId;
	@ApiModelProperty(hidden = true)
	private Order order;
	private PaymentMode paymentMode;

}
