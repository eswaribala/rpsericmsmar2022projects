package com.eric.inventoryservice.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class InventoryFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		log.info("Remote Host"+"--->"+request.getRemoteHost());
		if(request.getRemoteHost().equals("0:0:0:0:0:0:1:1"))
			throw new RuntimeException("No Permission");
		filterChain.doFilter(httpRequest, httpResponse);

	}

}
