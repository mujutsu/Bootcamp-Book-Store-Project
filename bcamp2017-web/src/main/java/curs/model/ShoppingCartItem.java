package curs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import curs.interfaces.BookInterface;
import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;

@Entity
@Table(name = "cart_item")
public class ShoppingCartItem implements ShoppingCartItemInterface {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="cart_fk")
	private ActiveShoppingCart mCart;
	@ManyToOne
	@JoinColumn(name="book_fk")
	private Book mBook;
	private int mQuantity;

	@Override
	public Long getId() {
		return id;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mBook == null) ? 0 : mBook.hashCode());
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
		ShoppingCartItem other = (ShoppingCartItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mBook == null) {
			if (other.mBook != null)
				return false;
		} else if (!mBook.equals(other.mBook))
			return false;
		return true;
	}



	@Override
	public ShoppingCartInterface getShoppingCart() {
		return mCart;
	}

	@Override
	public BookInterface getBook() {
		return mBook;
		
		
	}

	@Override
	public void setBook(BookInterface pBook) {
		mBook = (Book)pBook;
	}

	@Override
	public int getQuantity() {
		return mQuantity;
	}

	@Override
	public void setQuantity(int pQuantity) {

		mQuantity=pQuantity;

	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+" [id=" + id + ", mCart=" + mCart + ", mBook=" + mBook + "]";
	}

	@Override
	public void setShoppingCart(ShoppingCartInterface pCart) {
		mCart=(ActiveShoppingCart) pCart;

		
		
	}
	
	

}
