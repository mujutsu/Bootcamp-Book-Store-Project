package curs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;

public class ShoppingCart implements ShoppingCartInterface{

	private Long id;

	private Collection<ShoppingCartItem> mItems;

	private Status mStatus = Status.OPENED;

	private User mCartUser;

	@Override
	public Long getId() {
		return id;
	}



	
	//@Override
	public Collection<ShoppingCartItemInterface> getItems() {
		return new ArrayList<>(mItems);
	}
 
	//@Override
	public void setItems(Collection<ShoppingCartItemInterface> pItems) {
		mItems = new ArrayList<>();
		for(ShoppingCartItemInterface sci : pItems) {
			mItems.add((ShoppingCartItem)sci);
		}
	}

	//@Override
	public User getCartUser() {
		// TODO Auto-generated method stub
		return mCartUser;
	}

	//@Override
	public void setCartUser(User pCartUser) {
		mCartUser=pCartUser;

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
	public Date getCartStartTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCartStartTime(Date pDate) {
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
	public void setPaymentData() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+" [id=" + id + ", mItems=" + mItems + ", mStatus=" + mStatus + "]";
	}






}
