package curs.rs;

import java.util.Collection;

import javax.inject.Inject;

import curs.dao.ActiveShoppingCartDAO;
import curs.interfaces.ShoppingCartItemInterface;
import curs.model.ActiveShoppingCart;
import curs.model.Book;
import curs.model.ShoppingCartItem;
import curs.rs.interfaces.ShoppingCartServiceInterface;

public class ShoppingCartService implements ShoppingCartServiceInterface {
	@Inject
	private ActiveShoppingCartDAO mCartDAO;

	@Inject
	ActiveShoppingCart mCart;

	@Override
	public boolean removeCartItemByQuantity(ShoppingCartItem pItem, int pQuantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCartItem(Book pItem, int pQuantity) {
		for (ShoppingCartItemInterface sci : mCart.getItems()) {
			if (sci.getBook().getId().equals(pItem.getId())) {
				sci.setQuantity(sci.getQuantity() + pQuantity);
				return true;
			}
		}
		ShoppingCartItemInterface sci = new ShoppingCartItem();
		sci.setBook(pItem);
		sci.setQuantity(pQuantity);
		return true;
	}

	@Override
	public void cancelCart() {
		mCart.getItems().clear();

	}

	@Override
	public ShoppingCartItem checkoutCart() {
		// BAZA DATE !!!
		return null;
	}

	@Override
	public ActiveShoppingCart getShoppingCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ActiveShoppingCart> getShoppingCartList() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
