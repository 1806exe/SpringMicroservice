package com.contollers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.axonframework.axonserver.connector.query.AxonServerRemoteQueryHandlingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.commands.OrderCreateDTO;
import com.service.commands.OrderCommandService;


@RestController

@RequestMapping(value = "/api/orders")
public class OrderCammandController {
	
	private OrderCommandService orderCommandService;
	
	public OrderCammandController(OrderCommandService orderCommandService) {
		// TODO Auto-generated constructor stub
		this.orderCommandService = orderCommandService;
	}
	
	@PostMapping
	public CompletableFuture<String> createOrder(@RequestBody OrderCreateDTO orderCreateDTO){
		System.out.println("Contoller received order for creation ");
		CompletableFuture<String> future = orderCommandService.createOrder(orderCreateDTO);
				
		try {
			System.out.println(future.get());
		}catch (InterruptedException | ExecutionException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return future;
	}

}
