package curs.interfaces;

import java.util.Collection;
import java.util.Date;



public interface ShoppingCartInterface {
	static enum Status {
		OPENED,FINALIZED,CANCELLED;
	}
	
	Long getId();
	Status getCartStatus();
	void setCartStatus(Status pStatus);
	Date getCartStartTime();
	void setCartStartTime(Date pDate);
	Date getCartClosingTime();
	void setCartClosingTime(Date pDate);
	String getPaymentData();
	void setPaymentData();
	
//	UserInterface getCartUser();
//	void setCartUser(UserInterface pName);

//	void setItems(Collection<ShoppingCartItemInterface> pItems);
//	Collection<ShoppingCartItemInterface> getItems();

	
}
