package curs.interfaces;

import java.util.Collection;
import java.util.Date;

public interface ShoppingCartInterface {
	static enum Status{
		OPENED,FINALIZED,CANCELLED;
	}
	
	Long getId();
	public Collection<ShoppingCartItemInterface>getItems();
	void setItems(Collection<ShoppingCartItemInterface> pCollections);
	String getCartUser();
	void setCartUser(String pName);
	Status getCartStatus();
	void setCartStatus(Status pStatus);
	Date getCartClosingTime();
	void setCartClosingTime(Date pDate);
	String getPaymentData();
	void setPaymentData(String pPayData);
	void setPaymentData();
	void setCartStartTime(Date pDate);
	Date getCartStartTime();
	

}
