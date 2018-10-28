package com.Service;

import java.util.List;

import com.al.dao.OrderDao;
import com.al.dao.OrderDaoImpl;
import com.al.dao.OrderExistsException;
import com.al.model.Order;

public interface OrderServiceInterface {
	
	OrderDao orderDao=new OrderDaoImpl();
	 
	Order getOrder(int orderId);
	 List<Order> getAllOrders();
	 void addOrder(Order order)throws OrderExistsException;
	 void updateOrder(Order order);
	 void deleteOrder(Order order);

}
