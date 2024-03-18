package com.javasumi.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.javasumi.webflux.dao.CustomerDao;
import com.javasumi.webflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {
  
	@Autowired
	private CustomerDao customerDao;

	public Mono<ServerResponse> getCustomers(ServerRequest request){
		    Flux<Customer> customerStream=customerDao.getCustomersStream();
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(customerStream,Customer.class);
	}
}
