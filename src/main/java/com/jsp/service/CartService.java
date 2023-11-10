package com.jsp.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import com.jsp.dao.CartDao;
import com.jsp.dao.ProductDao;
import com.jsp.entity.Cart;
import com.jsp.entity.Product;

public class CartService {
	CartDao cartDao = new CartDao();
	ProductDao productDao = new ProductDao();
	Cart cart = new Cart();
	Product product = new Product();
	Scanner sc = new Scanner(System.in);

	public void createCart() {
		if (cart != null) {
			String message = cartDao.createCart(cart);
			System.out.println(message);
		}

	}

	public void addProductToCart() {
		System.out.println("Enter any Number to view Products");
		int products = sc.nextInt();

		List<Product> allProducts = productDao.getAllProducts();
		for (Product product : allProducts) {
			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getProductPrice()
					+ " " + product.getProductQuantity());
		}

		System.out.println("Enter cartId to add the Product");
		int cartId = sc.nextInt();
		
		System.out.println("Enter ProductId to add  ");
		int productId = sc.nextInt();
		
		if (cart != null) {

			String message = cartDao.addProductToCart(cart, cartId, productId);
			System.out.println(message);
		}

	}
	public void removeProductFromCart() {
	    System.out.println("Enter cartId to remove the product from");
	    int cartId = sc.nextInt();

	    System.out.println("Enter productId to remove from the cart");
	    int productId = sc.nextInt();

	    String message = cartDao.removeProductFromCart(cart,cartId, productId);
	    System.out.println(message);
	}


}
