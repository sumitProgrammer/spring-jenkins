package com.javasumi.webflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.javasumi.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {
	public List<Customer> getCustomers(){
		return IntStream.rangeClosed(1, 10)
				.peek(CustomerDao::sleepExecution)
				.peek(i->System.out.println("processing count:"+i))
		.mapToObj(i->new Customer(i,"customer"+i)).collect(Collectors.toList());
	}
	
	private static void sleepExecution(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public Flux<Customer> getCustomersStream(){
		return Flux.range(1, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i->System.out.println("processing count in Stream flow:"+i))
				.map(i->new Customer(i,"customer"+i));
	}
	
	
	public Flux<Customer> getCustomersStreamList(){
		return Flux.range(1, 50)
				.doOnNext(i->System.out.println("processing count in Stream flow:"+i))
				.map(i->new Customer(i,"customer"+i));
	}

}
