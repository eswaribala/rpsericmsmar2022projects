package com.eric.ribbonlb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;






@RestController
public class RibbonController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private RestTemplate restTemplate;
	
    @Autowired
    private LoadBalancerClient loadBalancer;   

    @Value("${serviceId}")
    private String serviceId;
	
    @GetMapping("/")
    public List<ServiceInstance> accessAPI() {
    	
    	// (Need!!) eureka.client.fetchRegistry=true
        List<ServiceInstance> instances = this.discoveryClient
        		.getInstances(serviceId);
        
	   return instances;
    }
	

}
