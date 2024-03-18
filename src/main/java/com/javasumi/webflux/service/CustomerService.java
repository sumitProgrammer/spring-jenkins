package com.javasumi.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasumi.webflux.dao.CustomerDao;
import com.javasumi.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> loadAllCustomers(){
		long startTime=System.currentTimeMillis();
		List<Customer> customersList=customerDao.getCustomers();
		long endTime=System.currentTimeMillis();
		System.out.println("Total Execution Time:"+(endTime-startTime));
		return customersList;
	}
	
	public Flux<Customer> loadAllCustomersStream(){
		long startTime=System.currentTimeMillis();
		Flux<Customer> customersFlux=customerDao.getCustomersStream();
		long endTime=System.currentTimeMillis();
		System.out.println("Total Execution Time:"+(endTime-startTime));
		return customersFlux;
	}
	
}
