package curs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.UserInterface;

public class User implements UserInterface{
	
	private String mLoginName;
	private String mPasswd;
	private Collection<String> mRoles = new ArrayList<>();
	private ActiveShoppingCart mActiveShoppingCart;
	private List<Order> mOrderHistory;


	public String getLoginName() {
		return mLoginName;
	}

	public void setLoginName(String pLoginName) {
		mLoginName = pLoginName;
	}

	public String getPasswd() {
		return mPasswd;
	}

	public void setPasswd(String pPasswd) {
		mPasswd = pPasswd;
	}

	public Collection<String> getRoles() {
		return mRoles;
	}

	public void setRoles(Collection<String> pRoles) {
		mRoles = pRoles;
	}

	//@Override
	public void setOrderHistory(List<Order> pOrderHistory) {
		mOrderHistory=pOrderHistory;
		
	}

	//@Override
	public List<Order> getOrderHistory() {
		// TODO Auto-generated method stub
		return mOrderHistory;
	}
	
	public ActiveShoppingCart getActiveShoppingCart(){
		return mActiveShoppingCart;
	}
	
	public void setActiveShoppingCart(ActiveShoppingCart cart){
		mActiveShoppingCart=cart;
	}
}
