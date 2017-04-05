package curs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.inject.Named;

import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;
import curs.interfaces.UserInterface;

@Named("cart")
public class ActiveShoppingCart extends ShoppingCart implements Serializable{
	private Collection<ShoppingCartItem> mItems = new ArrayList<>();
	private User mCartUser;
	private Status mStatus;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActiveShoppingCart other = (ActiveShoppingCart) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mCartUser == null) {
			if (other.mCartUser != null)
				return false;
		} else if (!mCartUser.equals(other.mCartUser))
			return false;
		return true;
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
	public Status getCartStatus() {
		// TODO Auto-generated method stub
		return mStatus;
	}

	@Override
	public void setCartStatus(Status pStatus) {
		// TODO Auto-generated method stub
		mStatus=pStatus;

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
		return mPaymentData;
	}

	@Override
	public void setPaymentData() {
		// TODO Auto-generated method stub

	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}





}
