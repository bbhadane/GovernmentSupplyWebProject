package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.ProductService;
import com.al.model.Product;

/**
 * Servlet implementation class SelectedProducts
 */
@WebServlet("/SelectedProducts")
public class SelectedProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectedProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		ProductService productService=new ProductService();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	 String[] selectedValues = request.getParameterValues("checkboxGroup");
	Object object;
	
	
	 List<Product> selectedProducts=new ArrayList<Product>();
			for(int i=0;i<selectedValues.length;i++)
			{
				Integer selectedProductId=Integer.parseInt(selectedValues[i]);
				Product productObj = productService.getProduct(selectedProductId);
				selectedProducts.add(productObj);
				
			}
		request.setAttribute("selectedProductsList",selectedProducts);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("PlaceOrder.jsp");
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
