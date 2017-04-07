package curs.rs.interfaces;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import curs.model.Order;
import curs.model.User;

@Path("/users")
public interface UserServiceInterface {
	@POST 
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	boolean login(User pUser);
	
	@POST 
	@Path("logout")
	void logout();
	
	@POST 
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	boolean register(User pUser);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	boolean isLoggedIn();
	
	@GET
	@Path("role/{role_name}")
	@Produces(MediaType.APPLICATION_JSON)
	boolean hasRole(@PathParam("role_name") String pRole);
	
	
	@GET
	@Path("order_history")
	@Produces(MediaType.APPLICATION_JSON)
	Collection<Order> getUserOrderHistory();
	
//	@GET
//	@Path("cart")
//	@Produces(MediaType.APPLICATION_JSON)
//	public ShoppingCart getShoppingCart();
//	
//	@GET
//	@Path("history")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Order> getOrderHistory();
//	
	
	
	
}
