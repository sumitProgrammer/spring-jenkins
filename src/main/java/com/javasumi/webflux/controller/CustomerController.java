package com.javasumi.webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasumi.webflux.dto.Customer;
import com.javasumi.webflux.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping(value="/",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllCustomers() {
		return customerService.loadAllCustomers();
	}
	
	
	@GetMapping(value="/stream", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getAllCustomersStream() {
		return customerService.loadAllCustomersStream();
	}
}
