package com.javasumi.webflux.router;

import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.javasumi.webflux.dto.Customer;
import com.javasumi.webflux.handler.CustomerHandler;
import com.javasumi.webflux.handler.CustomerStreamHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Configuration
public class RouterConfig {
	
	@Autowired
	private CustomerHandler customerHandler;
	
	@Autowired
	private CustomerStreamHandler customerStreamHandler;
	
	@Bean
	@RouterOperations({

			@RouterOperation(path = "/router/customers", produces = {
					MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET, beanClass = CustomerHandler.class, beanMethod = "loadCustomers", operation = @Operation(operationId = "loadCustomers", responses = {

							@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Customer.class))) })),

			@RouterOperation(

					path = "/router/customer/{input}", produces = {
							MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET, beanClass = CustomerHandler.class, beanMethod = "findCustomer", operation = @Operation(operationId = "findCustomer", responses = {

									@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Customer.class))),

									@ApiResponse(responseCode = "404", description = "customer not found with given id") }, parameters = {
											@Parameter(in = ParameterIn.PATH, name = "input") }

					)

			)

	// next
	})
	 
	
	public RouterFunction<ServerResponse> routerFunction(){
		return RouterFunctions.route()
				.GET("/router/customers",customerHandler::loadCustomers)
				.GET("/router/customers/stream",customerStreamHandler::getCustomers)
				.GET("/router/customer/{input}",customerHandler::findCustomer)
				.POST("/router/customer/save",customerHandler::saveCustomer)
				.build();
	}
}
