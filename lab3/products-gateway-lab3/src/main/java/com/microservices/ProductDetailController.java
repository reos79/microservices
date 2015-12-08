package com.microservices;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductDetailController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	private String getServiceUrl(String service) {
	    ServiceInstance instance = discoveryClient.getInstances(service).get(0);
	    return instance.getUri().toString();
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/products/{id}")
	@ResponseBody
	public ProductDetail findProduct(@PathVariable("id") Integer id){
		RestTemplate restTemplate = new RestTemplate();
		ProductDetail detail = new ProductDetail();
		Product product = restTemplate.getForObject(getServiceUrl("ProductsMicroservice") + "/products/{id}", Product.class, id);
		detail.setProduct(product);
		
		ResponseEntity<Review[]> reviews = restTemplate.getForEntity(getServiceUrl("ReviewsMicroservice") + "/products/{productId}/reviews", Review[].class, id);
		detail.setReviews(Arrays.asList(reviews.getBody()));
		
		return detail;	
	}
	
	/*
	@RequestMapping(method=RequestMethod.GET, value= "/products/{id}")
	@ResponseBody
	public ProductDetail findProduct(@PathVariable("id") Integer id){
		RestTemplate restTemplate = new RestTemplate();
		ProductDetail detail = new ProductDetail();
		Product product = restTemplate.getForObject("http://localhost:8080/products/{id}", Product.class, id);
		detail.setProduct(product);
		
		ResponseEntity<Review[]> reviews = restTemplate.getForEntity("http://localhost:8181/products/{productId}/reviews", Review[].class, id);
		detail.setReviews(Arrays.asList(reviews.getBody()));
		
		return detail;	
	}*/
}
