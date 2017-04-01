package curs.model;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import curs.interfaces.BookInterface;
import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;

public class ShoppingCartItem implements ShoppingCartItemInterface{

	private BookInterface mBook;
	private int mQuantity;
	private Long id;
	@ManyToOne
	@JoinColumn(name="cart_fks")
	ShoppingCartInterface mCart;
	@Override
	public BookInterface getBook() {
		// TODO Auto-generated method stub
		return mBook;
	}

	@Override
	public void setBook(BookInterface pBook) {
		// TODO Auto-generated method stub
		mBook=pBook;
		
	}

	@Override
	public int getQuantity() {
		return mQuantity;
	}

	@Override
	public void setQuantity(int pQuantity) {
		pQuantity=mQuantity;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public ShoppingCartInterface getShoppingCart() {
		// TODO Auto-generated method stub
		return null;
	}

}
