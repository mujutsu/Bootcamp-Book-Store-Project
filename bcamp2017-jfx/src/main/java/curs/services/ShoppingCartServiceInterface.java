package curs.services;
import java.util.Collection;

import curs.model.Book;
import curs.model.ActiveShoppingCart;
import curs.model.ShoppingCartItem;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface ShoppingCartServiceInterface {
	@Headers({
		
		"Accept: application/json",
		"Content-Type: application/json"
	})
	@GET("/cart")
	public Call<ActiveShoppingCart> getShoppingCart();
	
	@GET("cart/list")
	public Call<Collection<ActiveShoppingCart>> getShoppingCartList();
	
	@POST("cart/remove/item")
	public Call<Boolean> removeCartItem(@Body ShoppingCartItem pItem);
	
	
	@POST("cart/add/item")
	public Call<Boolean> addCartItem(@Body Book pItem, int pQuantity);
	
	@POST("cart/cancel")
	public Call<Void> cancelCart();
	
	@POST("cart/checkout")
	public Call<ShoppingCartItem> checkoutCart();
	
	@POST("cart/remove/item")
	public Call<Boolean> removeShoppingCartItemByQuantity(@Body ShoppingCartItem pItem, int pQuantity);
	

	
	

}
