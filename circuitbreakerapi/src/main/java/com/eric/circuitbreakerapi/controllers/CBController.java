package com.eric.circuitbreakerapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eric.circuitbreakerapi.handlers.CBHandler;
import com.eric.circuitbreakerapi.vos.JWTRequest;

import io.opentracing.Span;
import io.opentracing.Tracer;



@RestController
public class CBController {
    @Autowired
	private CBHandler cbHandler;
    private Tracer tracer;

    public CBController(Tracer tracer) {
    	this.tracer=tracer;
    	
    }
    
    
	@PostMapping("/")
	public ResponseEntity<?> sendRequest(@RequestBody JWTRequest jwtRequest) {
		Span span = tracer.buildSpan("create cb controller...").start();
 
		ResponseEntity<String> responseEntity=this.cbHandler.
				requestHandler(jwtRequest,span);
		if(responseEntity!=null) 
			span.setTag("http.status_code", 201);

		else
			span.setTag("http.status_code", 500);
		
		span.finish();
		return responseEntity;

	}
}
