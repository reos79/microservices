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
public class ReviewController {

	@Autowired
	private ReviewRepository reviewRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/products/{productId}/reviews")
	@ResponseBody
	public Iterable<Review> findAllUserReviews(@PathVariable("productId") Integer productId) {
		return reviewRepository.findByProductId(productId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/reviews")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveReview(@RequestBody Review review) {
		reviewRepository.save(review);
	}	
}
