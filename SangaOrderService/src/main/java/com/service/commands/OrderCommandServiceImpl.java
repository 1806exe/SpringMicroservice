package com.service.commands;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.aggregates.OrderStatus;
import com.dto.commands.OrderCreateDTO;
import com.ecommerce.commands.CreateOrderCommand;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {
	private final CommandGateway commandGateway;

	public OrderCommandServiceImpl(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}
	
	
	@Override
	public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO){
		System.out.println("receive order fro creating order " + orderCreateDTO.getItemType() + 
				": status is created " 
				
				);
		
		return commandGateway.send(
				new CreateOrderCommand(UUID.randomUUID().toString(), 
				orderCreateDTO.getItemType(), 
				orderCreateDTO.getPrice(), 
				orderCreateDTO.getCurrency(),
				String.valueOf(OrderStatus.CREATED)
				));
		
	}
	
	

}
