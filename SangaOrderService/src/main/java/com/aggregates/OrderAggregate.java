package com.aggregates;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.ecommerce.commands.CreateOrderCommand;
import com.ecommerce.commands.UpdateOrderStatusCommand;
import com.ecommerce.events.OrderCreatedEvent;
import com.ecommerce.events.OrderUpdatedEvent;

@Aggregate
public class OrderAggregate {
	
	@AggregateIdentifier
	private String orderId;
	private ItemType itemType;
	private BigDecimal price;
	private String currency;
	private OrderStatus orderStatus;
	
	public OrderAggregate() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderAggregate(CreateOrderCommand createOrderCommand) {
		AggregateLifecycle.apply(new OrderCreatedEvent(createOrderCommand.orderId, 
				createOrderCommand.itemType, 
				createOrderCommand.price, 
				createOrderCommand.currency, 
				createOrderCommand.orderStatus));
	}
	
	@CommandHandler
	private void on(OrderCreatedEvent orderCreatedEvent) {
		// TODO Auto-generated method stub
		this.orderId = orderCreatedEvent.orderId;
		this.itemType = ItemType.valueOf(orderCreatedEvent.itemType);
		this.price = orderCreatedEvent.price;
		this.currency = orderCreatedEvent.currency;
		this.orderStatus = OrderStatus.valueOf(orderCreatedEvent.orderStatus);
	}
	
	
	@CommandHandler
	protected void on(UpdateOrderStatusCommand updateOrderStatusCommand) {
		AggregateLifecycle.apply(new OrderUpdatedEvent(updateOrderStatusCommand.orderId, 
				updateOrderStatusCommand.orderStatus));
	}
	
	
	@EventSourcingHandler
	private void on(OrderUpdatedEvent orderUpdatedEvent) {
		// TODO Auto-generated method stub
		this.orderId = orderId;
		this.orderStatus = OrderStatus.valueOf(orderUpdatedEvent.orderStatus);

	}
	
	
	
	

}
