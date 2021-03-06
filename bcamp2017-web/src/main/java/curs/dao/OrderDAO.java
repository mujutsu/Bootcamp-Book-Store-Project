package curs.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import curs.cdi.Logging;
import curs.model.Order;
import curs.model.User;

@RequestScoped
@Logging
public class OrderDAO {
	@Inject
	private EntityManager mEM;

	public OrderDAO() {

	}

	public Order findOrderById(Long pId) {
		return mEM.find(Order.class, pId);
	}

	
	public List<Order> getAllUserOrders(User pUser) {
		TypedQuery<Order> q = mEM.createQuery("Select o FROM curs.model.Order WHERE o.mCartUser LIKE :userName o ORDER BY o.mDateOrderPosted", Order.class).setParameter("userName", pUser);
		return q.getResultList();
	}
	
	public List<Order> getAllOrders() {
		TypedQuery<Order> q = mEM.createQuery("Select o FROM curs.model.Order o ORDER BY o.mCartUser", Order.class);
		return q.getResultList();
	}

	public Order addOrder(Order pOrder) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		try {
			mEM.persist(pOrder);
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}
		return pOrder;
	}

	public Order deleteOrder(Long pOrderId) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		Order o = null;
		try {
			o = mEM.find(Order.class, pOrderId);
			if (o != null) {
				mEM.remove(o);
			}
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}
		return o;
	}

	public Order updateOrder(Long pOrderId, Order pOrder) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		Order o = null;
		try {
			o = mEM.find(Order.class, pOrderId);
			o.setItems(pOrder.getItems());
			o.setCartUser(pOrder.getCartUser());
			o.setStatus(pOrder.getStatus());
			o.setDateOrderPosted(pOrder.getDateOrderPosted());
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}

		return o;
	}
}
