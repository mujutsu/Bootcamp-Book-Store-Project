package curs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import curs.interfaces.ShoppingCartInterface;

public class ShoppingCart implements ShoppingCartInterface{
	private Collection<ShoppingCartItem> mItems = new ArrayList<>();
	private User mCartUser;
	private Date mStartTime;
	private Date mClosingTime;
	private String mPaymentData;
	private Long id;
	
	//@Override
	public Collection<ShoppingCartItem> getItems() {
		return mItems;
	}

	//@Override
	public void setItems(Collection<ShoppingCartItem> pItems) {
		mItems = new ArrayList<>(pItems);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mCartUser == null) ? 0 : mCartUser.hashCode());
		return result;
	}



	//@Override
	public User getCartUser() {
		// TODO Auto-generated method stub
		return mCartUser;
	}

	//@Override
	public void setCartUser(User pCartUser) {
		mCartUser=(User)pCartUser;

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
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}






}
