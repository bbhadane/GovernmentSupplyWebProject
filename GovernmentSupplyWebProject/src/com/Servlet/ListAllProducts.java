package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Service.ProductService;
import com.al.model.Product;


/**
 * Servlet implementation class ListAllProducts
 */
@WebServlet("/ListAllProducts")
public class ListAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
			 requestDispatcher.include(request, response);
		}
		else
		{
			ProductService productService= new ProductService();
			List<Product> allProductList = productService.getAllProduct();
			
		
		request.setAttribute("AllProductList", allProductList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("GovernmentEmployeePortal.jsp");
		requestDispatcher.include(request, response);
		
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
