package com.eric.circuitbreakerapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eric.circuitbreakerapi.handlers.CBHandler;
import com.eric.circuitbreakerapi.vos.JWTRequest;




@RestController
public class CBController {
    @Autowired
	private CBHandler cbHandler;
    
	@PostMapping("/")
	public ResponseEntity<?> sendRequest(@RequestBody JWTRequest jwtRequest) {
		 return this.cbHandler.requestHandler(jwtRequest);
	}
}
