package curs.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import curs.cdi.Logging;
import curs.model.ShoppingCartItem;

@RequestScoped
@Logging
public class ShoppingCartItemDAO {
	@Inject
	private EntityManager mEM;

	public ShoppingCartItemDAO() {

	}

	public ShoppingCartItem addShoppingCartItem(ShoppingCartItem pShoppingCartItem) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		try {
			mEM.persist(pShoppingCartItem);
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}
		return pShoppingCartItem;
	}

	public ShoppingCartItem deleteShoppingCartItem(Long pShoppingCartItemId) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		ShoppingCartItem sci = null;
		try {
			sci = mEM.find(ShoppingCartItem.class, pShoppingCartItemId);
			if (sci != null) {
				mEM.remove(sci);
			}
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}
		return sci;
	}

	public ShoppingCartItem updateShoppingCartItem(Long pShoppingCartItemId, ShoppingCartItem pShoppingCartItem) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		ShoppingCartItem sci = null;
		try {
			sci = mEM.find(ShoppingCartItem.class, pShoppingCartItemId);
			sci.setShoppingCart(pShoppingCartItem.getShoppingCart());
			sci.setBook(pShoppingCartItem.getBook());
			sci.setQuantity(pShoppingCartItem.getQuantity());
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}

		return sci;
	}

}