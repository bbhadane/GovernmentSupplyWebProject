package com.Service;

import java.util.List;

import com.al.dao.ProductExistException;
import com.al.model.Product;

public class ProductService implements ProductServiceInterface {

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return productdao.getProduct(productId);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productdao.getAllProduct();
	}

	@Override
	public void addProduct(Product product) throws ProductExistException {
		// TODO Auto-generated method stub
			productdao.addProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productdao.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productdao.deleteProduct(product);
	}

}
