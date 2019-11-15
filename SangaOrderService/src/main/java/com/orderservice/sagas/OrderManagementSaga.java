package com.orderservice.sagas;

import java.util.UUID;

import javax.inject.Inject;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import com.aggregates.OrderStatus;
import com.ecommerce.commands.CreateInvoiceCommand;
import com.ecommerce.commands.CreateShippingCommand;
import com.ecommerce.commands.UpdateOrderStatusCommand;
import com.ecommerce.events.InvoiceCreatedEvent;
import com.ecommerce.events.OrderCreatedEvent;
import com.ecommerce.events.OrderShippedEvent;
import com.ecommerce.events.OrderUpdatedEvent;


@Saga
public class OrderManagementSaga {
	
	@Inject
	private transient CommandGateway commandGateway;
	
	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	private void handle(OrderCreatedEvent orderCreatedEvent) {
		
		String paymentId = UUID.randomUUID().toString();
		System.out.println("saga invoked");
		
		
		// saga associate 
		
		SagaLifecycle.associateWith("paymentId", paymentId);
		
		System.out.println("Saga sending order id " + orderCreatedEvent.orderId  + " "
				+ "to create invoice command");
		
		
		commandGateway.send(new CreateInvoiceCommand(paymentId, orderCreatedEvent.orderId));
		
	}
	
	
	  @SagaEventHandler(associationProperty = "paymentId")
	    public void handle(InvoiceCreatedEvent invoiceCreatedEvent){
	        String shippingId = UUID.randomUUID().toString();

	        System.out.println("Saga continued");

	        //associate saga with shipping
	        SagaLifecycle.associateWith("shipping", shippingId);
	        System.out.println("Saga sending shipping id" + shippingId+" to create shipping command");
	        //send the create shipping command
	        commandGateway.send(new CreateShippingCommand(shippingId, invoiceCreatedEvent.orderId, invoiceCreatedEvent.paymentId));
	    }

	    @SagaEventHandler(associationProperty = "orderId")
	    public void handle(OrderShippedEvent orderShippedEvent){
	    	System.out.println("Saga sending shipping id" + orderShippedEvent.orderId+" to order shipping event:"+orderShippedEvent.shippingId);
	        commandGateway.send(new UpdateOrderStatusCommand(orderShippedEvent.orderId, String.valueOf(OrderStatus.SHIPPED)));
	    }

	    @SagaEventHandler(associationProperty = "orderId")
	    public void handle(OrderUpdatedEvent orderUpdatedEvent){
	    	System.out.println("Saga sending update event" + orderUpdatedEvent.orderId+" to end"+orderUpdatedEvent.orderStatus);
	        SagaLifecycle.end();
	    }

}
