package curs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;
import curs.interfaces.UserInterface;

@Entity
@Table(name="orders")
public class Order  extends ShoppingCart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy="mCart")
	private Collection<ShoppingCartItem> mItems;//////////////////////////
	@Column(name="user")
	@ManyToOne
	User mCartUser;

	@Override
	public Long getId() {
		return id;
	}
	
	


}
