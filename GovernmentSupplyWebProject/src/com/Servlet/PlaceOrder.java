package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Service.OrderService;
import com.al.dao.OrderDao;
import com.al.dao.OrderDaoImpl;
import com.al.model.Order;

/**
 * Servlet implementation class PlaceOrder
 */
@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 HttpSession session=request.getSession(true);
		Object count = session.getAttribute("Count");
		Object clientIdObj=session.getAttribute("clientId");
		Integer clientId = (Integer) clientIdObj; 
		
		Object productIdObj = session.getAttribute("productId");
		Integer productId = (Integer) productIdObj; 
		OrderService orderService=new OrderService();
		Integer countInt=(Integer)count;
		System.out.println(countInt);
		String parameter = request.getParameter("quantity1");
		System.out.println("quantity1"+ parameter);
		for(int i=1;i<=countInt;i++)
		{
			String quantity="quantity"+i;
			String OrderPlacedDate="OrderPlacedDate"+i;
			String DeadLine="deadLine"+i;
			
			//System.out.println("orderId"+OrderId);
			String quantityRequired = request.getParameter(quantity);
			String orderPlacedDate = request.getParameter(OrderPlacedDate);
			String deadline = request.getParameter(DeadLine);
				System.out.println(quantityRequired+orderPlacedDate+deadline);
			
			List<Order> allOrders = orderService.getAllOrders();
			int size = allOrders.size()-1;
			int orderId = allOrders.get(size).getOrderId();
			orderId++;
			orderService.getOrderFromUser(orderId, clientId,productId, Integer.parseInt(quantityRequired),orderPlacedDate, deadline);
			
			
		}
		
		List<Order> allOrders = orderService.getAllOrders();
		request.setAttribute("allOrders",allOrders);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("ViewOrders.jsp");
		requestDispatcher.include(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
