package com.eric.zuulgateway.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

	private String userName;
	private String userPwd;
	

	
}
