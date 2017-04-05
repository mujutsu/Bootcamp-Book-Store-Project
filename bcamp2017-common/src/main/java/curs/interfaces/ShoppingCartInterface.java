package curs.interfaces;

import java.util.Collection;
import java.util.Date;



public interface ShoppingCartInterface {
	
	
	Long getId();

	Date getCartStartTime();
	void setCartStartTime(Date pDate);

	
//	UserInterface getCartUser();
//	void setCartUser(UserInterface pName);

//	void setItems(Collection<ShoppingCartItemInterface> pItems);
//	Collection<ShoppingCartItemInterface> getItems();

	
}
