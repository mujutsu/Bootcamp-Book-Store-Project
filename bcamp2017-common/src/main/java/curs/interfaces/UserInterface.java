package curs.interfaces;

import java.util.Collection;
import java.util.List;

public interface UserInterface {


	public Collection<String> getRoles() ;
	

	public void setRoles(Collection<String> pRoles);

	public String getLoginName();

	public void setLoginName(String pLoginName) ;
	public String getPasswd();
	public void setPasswd(String pPasswd) ;
//	public void setOrderHistory(List<ShoppingCartInterface>mOrders);
//	public List<ShoppingCartInterface> getOrderHistory();
}
