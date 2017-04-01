package curs.model;

import java.util.Collection;
import java.util.Date;

import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;

public class ShoppingCart implements ShoppingCartInterface{

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ShoppingCartItemInterface> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setItems(Collection<ShoppingCartItemInterface> pCollections) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCartUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCartUser(String pName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Status getCartStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCartStatus(Status pStatus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getCartClosingTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCartClosingTime(Date pDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPaymentData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPaymentData(String pPayData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPaymentData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCartStartTime(Date pDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getCartStartTime() {
		// TODO Auto-generated method stub
		return null;
	}

}
