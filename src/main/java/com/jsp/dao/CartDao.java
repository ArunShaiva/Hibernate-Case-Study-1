package com.jsp.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.entity.Cart;
import com.jsp.entity.Product;

public class CartDao {

	Configuration cfg = new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);;

	SessionFactory sf = cfg.buildSessionFactory();

	public String createCart(Cart cart) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(cart);
		trans.commit();
		session.close();
		return "Cart Created Successfully...!";
	}

	public String addProductToCart(Cart cart, int cartId, int productId) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		cart = session.get(Cart.class, cartId);
		cart.getProducts().add(session.get(Product.class, productId));
		session.saveOrUpdate(cart);
		System.out.println("Product added Successfully...!");
		trans.commit();
		session.close();
		return "Product added Successfully...!";

	}
	public String removeProductFromCart(Cart cart, int cartId, int productId) {
	    Session session = sf.openSession();
	    Transaction trans = session.beginTransaction();

	    // Retrieve the cart
	    cart = session.get(Cart.class, cartId);

	    // Retrieve the product to be removed
	    Product productToRemove = session.get(Product.class, productId);

	    // Remove the product from the cart
	    cart.getProducts().remove(productToRemove);

	    // Update the cart in the database
	    session.saveOrUpdate(cart);

	    System.out.println("Product removed Successfully...!");
	    
	    trans.commit();
	    session.close();

	    return "Product removed Successfully...!";
	}


	
}
