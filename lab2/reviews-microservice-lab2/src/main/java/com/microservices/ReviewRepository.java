package com.microservices;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer>{

	public Iterable<Review> findByProductId(Integer productId);
}
