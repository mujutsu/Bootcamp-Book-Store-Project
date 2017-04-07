package curs.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import curs.cdi.Logging;
import curs.model.ActiveShoppingCart;

@RequestScoped
@Logging
public class ActiveShoppingCartDAO {
	@Inject
	private EntityManager mEM;

	public ActiveShoppingCartDAO() {

	}

	public ActiveShoppingCart findActiveShoppingCartById(Long pId) {
		return mEM.find(ActiveShoppingCart.class, pId);
	}

	public List<ActiveShoppingCart> getAllActiveShoppingCarts() {
		TypedQuery<ActiveShoppingCart> q = mEM.createQuery(
				"Select s FROM curs.model.ActiveShoppingCart s ActiveShoppingCart ORDER BY s.mCartUser",
				ActiveShoppingCart.class);
		return q.getResultList();
	}

	public ActiveShoppingCart addActiveShoppingCart(ActiveShoppingCart pActiveShoppingCart) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		try {
			mEM.persist(pActiveShoppingCart);
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}
		return pActiveShoppingCart;
	}

	public ActiveShoppingCart deleteActiveShoppingCart(Long pActiveShoppingCartId) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		ActiveShoppingCart acs = null;
		try {
			acs = mEM.find(ActiveShoppingCart.class, pActiveShoppingCartId);
			if (acs != null) {
				mEM.remove(acs);
			}
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}
		return acs;
	}

	public ActiveShoppingCart updateActiveShoppingCart(Long pActiveShoppingCartId,
			ActiveShoppingCart pActiveShoppingCart) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		ActiveShoppingCart acs = null;
		try {
			acs = mEM.find(ActiveShoppingCart.class, pActiveShoppingCartId);
			acs.setItems(pActiveShoppingCart.getItems());
			acs.setCartUser(pActiveShoppingCart.getCartUser());

			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}
		return acs;
	}
}
