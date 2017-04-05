package curs.model;

import curs.interfaces.BookInterface;
import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;

public class ShoppingCartItem implements ShoppingCartItemInterface {
	private BookInterface mBook;
	private int mQuantity;
	private Long id;
	private ActiveShoppingCart mCart;
	

	@Override
	public BookInterface getBook() {
		return mBook;
	}

	@Override
	public void setBook(BookInterface pBook) {
		mBook = pBook;

	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCartItem other = (ShoppingCartItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mBook == null) {
			if (other.mBook != null)
				return false;
		} else if (!mBook.equals(other.mBook))
			return false;
		return true;
	}
	@Override
	public int getQuantity() {

		return mQuantity;
	}

	@Override
	public void setQuantity(int pQuantity) {
		mQuantity = pQuantity;

	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public ShoppingCartInterface getShoppingCart() {
		// TODO Auto-generated method stub
		return mCart;
	}

	@Override
	public void setShoppingCart(ShoppingCartInterface pCart) {
		mCart=(ActiveShoppingCart) pCart;
	}
}
