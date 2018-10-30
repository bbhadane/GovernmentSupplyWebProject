package com.ws.soap;

import java.util.List;

import com.al.model.Order;

public interface GetAllOrdersInterface
{
	String operationNameParam = "getAllOrders";
	public List<Order> getAllOrders();
}
