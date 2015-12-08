package com.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(method=RequestMethod.GET, value= "/products")
	@ResponseBody
	public Iterable<Product> findAllProducts(){
		return productRepository.findAll();		
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/products/{id}")
	@ResponseBody
	public Product findProduct(@PathVariable("id") Integer id){
		return productRepository.findOne(id);	
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "/products")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveProduct(@RequestBody Product product){
		productRepository.save(product);
	}
}
