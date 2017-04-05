package curs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;
import curs.interfaces.UserInterface;

public class Order extends ShoppingCart implements Serializable {

	private Long id;
	private Collection<ShoppingCartItem> mItems;//////////////////////////
	
	User mUser;
	private User mCartUser;
	private Status mStatus;

	@Override
	public Long getId() {
		return id;
	}


}
