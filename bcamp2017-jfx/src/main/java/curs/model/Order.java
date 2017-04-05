package curs.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class Order extends ShoppingCart implements Serializable {

	static enum Status {
		FINALIZED,CANCELLED;
	}
	private Long id;
	private Collection<ShoppingCartItem> mItems;//////////////////////////
	
	private User mCartUser;
	private Status mStatus;
	private Date dateOrderPosted;

	
	public Order(ShoppingCart mShoppingCart, Date mDate){
		this.dateOrderPosted=mDate;
		this.mCartUser=mShoppingCart.getCartUser();
		this.mItems=mShoppingCart.getItems();
		this.mStatus=Status.FINALIZED;
			
	}
	@Override
	public Long getId() {
		return id;
	}


}
