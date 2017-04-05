package curs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;

public class ShoppingCart implements ShoppingCartInterface{

	private Long id;

	private Collection<ShoppingCartItem> mItems;


	private User mCartUser;

	@Override
	public Long getId() {
		return id;
	}



	
//	//@Override
//	public Collection<ShoppingCartItemInterface> getItems() {
//		return new ArrayList<>(mItems);
//	}
// 
//	//@Override
//	public void setItems(Collection<ShoppingCartItemInterface> pItems) {
//		mItems = new ArrayList<>();
//		for(ShoppingCartItemInterface sci : pItems) {
//			mItems.add((ShoppingCartItem)sci);
//		}
//	}

	//@Override
	public Collection<ShoppingCartItem> getItems() {
		return mItems;
	}

	//@Override
	public void setItems(Collection<ShoppingCartItem> pItems) {
		mItems = new ArrayList<>(pItems);
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
	public Date getCartStartTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCartStartTime(Date pDate) {
		// TODO Auto-generated method stub

	}



	@Override
	public String toString() {
		return this.getClass().getSimpleName()+" [id=" + id + ", mItems=" + mItems  + "]";
	}






}
