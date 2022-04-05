package com.eric.inventoryservice.configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eric.inventoryservice.filters.InventoryFilter;

@Configuration
public class InventoryFilterConfiguration {

	

	@Bean
	public FilterRegistrationBean<InventoryFilter> register()
	{
		FilterRegistrationBean<InventoryFilter> reg=new 
				FilterRegistrationBean<InventoryFilter>();
		InventoryFilter filter =new InventoryFilter();
		reg.setFilter(filter);
		reg.addUrlPatterns("/catalogs/*");
		reg.setOrder(1);
		return reg;
	}

}
