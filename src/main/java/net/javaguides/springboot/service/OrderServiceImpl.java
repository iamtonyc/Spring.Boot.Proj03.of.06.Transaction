package net.javaguides.springboot.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import net.javaguides.springboot.dto.OrderRequest;
import net.javaguides.springboot.dto.OrderResponse;
import net.javaguides.springboot.entity.Order;
import net.javaguides.springboot.entity.Payment;
import net.javaguides.springboot.exception.PaymentException;
import net.javaguides.springboot.repository.OrderRepository;
import net.javaguides.springboot.repository.PaymentRepository;
@Service
public class OrderServiceImpl implements OrderService{

	
	private OrderRepository orderRepository;
	private PaymentRepository paymentRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository)
	{
		this.orderRepository=orderRepository;
		this.paymentRepository=paymentRepository;
		
	}
	
	@Override
	@Transactional
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		
		Order order =orderRequest.getOrder();
		order.setStatus("INPROGRESS");
		order.setOrderTrackingNumber(UUID.randomUUID().toString());
		orderRepository.save(order);
		
		Payment payment=orderRequest.getPayment();
		
		if(!payment.getType().equals("DEBIT")) {
			throw new PaymentException("Payment card type do not support");
		}
		
		payment.setOrderId(order.getId());
		paymentRepository.save(payment);
		
		OrderResponse orderResponse=new OrderResponse();
		orderResponse.setOrderTackingNumber(order.getOrderTrackingNumber());
		orderResponse.setStatus(order.getStatus());
		orderResponse.setMessage("SUCCESS");
		return orderResponse;
	}
}


