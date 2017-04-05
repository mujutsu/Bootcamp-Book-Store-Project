package curs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import curs.interfaces.UserInterface;

@Entity
@Table(name = "users", schema = "security")
public class User implements UserInterface,Serializable {
	@Id
	@Column(name = "user_name")
	private String mLoginName;
	@Column(name = "user_pass")
	private String mPasswd;
	@ElementCollection
	@CollectionTable(name = "user_roles", schema = "security", joinColumns = { @JoinColumn(name = "user_name") })
	@Column(name = "role_name")
	private Collection<String> mRoles = new ArrayList<String>();
	@OneToOne
	@Column(name="cart")
	private ActiveShoppingCart mShoppingCart;
	@OneToMany
	private List<Order> mOrderHistory; 

	public Collection<String> getRoles() {
		return mRoles;
	}

	public void setRoles(Collection<String> pRoles) {
		mRoles = pRoles;
	}

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

	//@Override
	public void setOrderHistory(List<Order> pOrderHistory) {
		mOrderHistory=pOrderHistory;
		
	}

	//@Override
	public List<Order> getOrderHistory() {
		// TODO Auto-generated method stub
		return mOrderHistory;
	}

}
