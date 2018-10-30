package com.Service;

import java.util.ArrayList;
import java.util.List;


import com.al.dao.OrderExistsException;
import com.al.model.Client;
import com.al.model.Order;
import com.al.model.Product;

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

	@Override
	public void getOrderFromUser(int orderId, int clientId, int productId, int quantityRequired,
			String orderPlacedDate, String deadline) {
		Order order = new Order();
		order.setOrderId(orderId);
		Client client =clientDao.getClient(clientId);
		order.setClient(client);
		Product product = productDao.getProduct(productId);
		order.setProduct(product);
		order.setQuantityRequired(quantityRequired);
		order.setOrderPlacedDate(orderPlacedDate);
		order.setDeadline(deadline);
		
		try {
			orderDao.addOrder(order);
		} catch (OrderExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Order> getOrderOfParticularClient(int clientId)
	{
		List<Order> ClientsOrder=new ArrayList<Order>();
		List<Order> allOrders = getAllOrders();
		for(Order order:allOrders)
		{
			int clientId2 = order.getClient().getClientId();
			if(clientId2==clientId)
				ClientsOrder.add(order);
		}
		return ClientsOrder;
	}
	
}
