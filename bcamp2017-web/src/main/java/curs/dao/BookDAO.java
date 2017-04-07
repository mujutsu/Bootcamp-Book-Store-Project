package curs.dao;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import curs.cdi.Logging;
import curs.model.Book;
import curs.utils.SearchFilter;
import curs.utils.SearchType;

@RequestScoped
@Logging
public class BookDAO {
	@Inject
	private EntityManager mEM;

	public BookDAO() {
	}

	public Book findBookById(Long pId) {
		return mEM.find(Book.class, pId);
	}

	public List<Book> getAllBooks() {
		TypedQuery<Book> q = mEM.createQuery("Select b FROM curs.model.Book b ORDER BY b.mTitle", Book.class);
		return q.getResultList();
	}

	public boolean sellBook(Long pId, int pAmount) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		boolean result = false;
		try {
			Book book = findBookById(pId);
			if (book != null && book.getAvailableCount() >= pAmount) {
				book.setAvailableCount(book.getAvailableCount() - pAmount);
				book.setSoldBooksCount(book.getSoldBooksCount() + pAmount);
				result = true;
			}
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}
		return result;
	}

	public Book addBook(Book pBook) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		try {
			mEM.persist(pBook);
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}
		return pBook;
	}

	public Book deleteBook(Long pBookId) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		Book b = null;
		try {
			b = mEM.find(Book.class, pBookId);
			if (b != null) {
				mEM.remove(b);
			}
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}
		return b;
	}

	public Book updateBook(Long pBookId, Book pBook) {
		if (mEM.getTransaction().isActive() && mEM.getTransaction().getRollbackOnly()) {
			throw new PersistenceException("Transaction marked for rollback");
		}
		boolean newTransaction = false;
		if (!mEM.getTransaction().isActive()) {
			newTransaction = true;
			mEM.getTransaction().begin();
		}
		Book b = null;
		try {
			b = mEM.find(Book.class, pBookId);
			b.setAuthor(pBook.getAuthor());
			b.setTitle(pBook.getTitle());
			b.setAvailableCount(pBook.getAvailableCount());
			b.setSoldBooksCount(pBook.getSoldBooksCount());
			if (newTransaction) {
				mEM.getTransaction().commit();
			}
		} catch (PersistenceException pex) {
			mEM.getTransaction().rollback();
			throw pex;
		}

		return b;
	}
	
	

//	public static void initData(EntityManager pEM) {
//		pEM.getTransaction().begin();
//		Query nq = pEM.createNativeQuery("DELETE FROM book");
//		nq.executeUpdate();
//		Book b = new Book();
//		b.setTitle("Contele de monte cristo");
//		b.setAuthor("Alex. Dumas");
//		b.setAvailableCount(10);
//		pEM.persist(b);
//		b = new Book();
//		b.setTitle("Ulisses");
//		b.setAuthor("James Joyce");
//		b.setAvailableCount(12);
//		pEM.persist(b);
//		b = new Book();
//		b.setTitle("Morometii");
//		b.setAuthor("M. Preda");
//		b.setAvailableCount(6);
//		pEM.persist(b);
//		b = new Book();
//		b.setTitle("In cautarea timpului piedut");
//		b.setAuthor("M Proust");
//		b.setAvailableCount(8);
//		pEM.persist(b);
//		b = new Book();
//		b.setTitle("10 Negri mititei");
//		b.setAuthor("A Christie");
//		b.setAvailableCount(19);
//		pEM.persist(b);
//		pEM.getTransaction().commit();
//	}
	
	
	public Collection<Book> search(SearchFilter pFilter) {
		// TODO Auto-generated method stub
		if(pFilter==null||pFilter.getQuery()==null||pFilter.getQuery().trim().isEmpty()) {
			return getAllBooks();
		}
		String query="%"+pFilter.getQuery().trim().toUpperCase()+"%";
		if (SearchType.TITLE.equals(pFilter.getType())){
			TypedQuery q=mEM.createQuery("Select b FROM curs.model.Book b WHERE UPPER(b.mTitle) LIKE : query ORDER BY b.mTitle",Book.class);
			q.setParameter("query",query);
			return q.getResultList();
		}
		else if(SearchType.AUTHOR.equals(pFilter.getType())){
			TypedQuery q=mEM.createQuery("Select b FROM curs.model.Book b WHERE UPPER(b.mAuthor) LIKE : query ORDER BY b.mTitle",Book.class);
			q.setParameter("query",query);
			return q.getResultList();
		}else{
			TypedQuery q=mEM.createQuery("Select b FROM curs.model.Book b WHERE (UPPER(b.mAuthor) LIKE : query) OR (UPPER(b.mTitle) LIKE query) ORDER BY b.mTitle",Book.class);
			q.setParameter("query",query);
			return q.getResultList();
		}
		
	}
}
