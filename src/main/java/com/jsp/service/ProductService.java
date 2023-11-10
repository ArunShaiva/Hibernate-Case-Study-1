package com.jsp.service;

import java.util.List;
import java.util.Scanner;

import com.jsp.dao.ProductDao;
import com.jsp.entity.Product;

public class ProductService {

	ProductDao pdao = new ProductDao();
	Scanner sc = new Scanner(System.in);

	public void addProduct() {
		System.out.println("Enter product name");
		String name = sc.next();

		System.out.println("Enter product price");
		double price = sc.nextDouble();

		System.out.println("Enter product quantiry");
		int quantity = sc.nextInt();

		Product product = new Product();
		product.setProductName(name);
		product.setProductPrice(price);
		product.setProductQuantity(quantity);

		String message = pdao.addProduct(product);
		System.out.println(message);
	}

	public void getProductById() {
		System.out.println("Enter the productId");
		int id = sc.nextInt();
		Product product = pdao.getProductById(id);
		System.out.println(
				product.getProductName() + " " + product.getProductPrice() + " " + product.getProductQuantity());

	}

	public void getAllProduct() {
		List<Product> allProducts = pdao.getAllProducts();
		for (Product product : allProducts) {
			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getProductPrice()
					+ " " + product.getProductQuantity());
		}
	}

	public void updateProduct() {
		System.out.println("Enter the productId to update");
		int id = sc.nextInt();

		Product product = pdao.getProductById(id);

		System.out.println("Enter product Name");
		String name = sc.next();

		System.out.println("Enter product price");
		double price = sc.nextDouble();

		System.out.println("Enter product quantity");
		int quantity = sc.nextInt();

		product.setProductName(name);
		product.setProductPrice(price);
		product.setProductQuantity(quantity);

		String message = pdao.updateProduct(product);
		System.out.println(message);
	}

	public void deleteProduct() {
		System.out.println("Enter ProductId to DELETE");
		int id = sc.nextInt();
		Product product = pdao.getProductById(id);
		String message = pdao.deleteProduct(product);
		System.out.println(message);
	}

}
