package com.Service;

import java.util.List;


import com.al.dao.OrderExistsException;
import com.al.model.Order;

public class OrderService implements OrderServiceInterface {

	@Override
	public Order getOrder(int orderId) {
		
		return orderDao.getOrder(orderId);
	}

	@Override
	public List<Order> getAllOrders() {
		
		return orderDao.getAllOrders();
	}

	@Override
	public void addOrder(Order order) throws OrderExistsException {
		orderDao.addOrder(order);
		
	}

	@Override
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
		
	}

	@Override
	public void deleteOrder(Order order) {
		orderDao.deleteOrder(order);
		
	}

	
}
