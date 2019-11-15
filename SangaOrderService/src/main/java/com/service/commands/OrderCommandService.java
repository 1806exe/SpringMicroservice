package com.service.commands;

import java.util.concurrent.CompletableFuture;

import com.dto.commands.OrderCreateDTO;

public interface OrderCommandService {
	
	public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO);

}
