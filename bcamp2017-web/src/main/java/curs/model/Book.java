package curs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import curs.interfaces.BookInterface;

@XmlRootElement(name = "book")
@Entity
@Table(name = "book")
public class Book implements BookInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "title")
	private String mTitle;
	@Column(name = "author")
	private String mAuthor;
	@Column(name = "available")
	private Integer mAvailableCount;
	@Column(name = "booked")
	private Integer mSellCount;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String pTitle) {
		mTitle = pTitle;
	}

	public String getAuthor() {
		return mAuthor;
	}

	public void setAuthor(String pAuthor) {
		mAuthor = pAuthor;
	}

	public Integer getAvailableCount() {
		return mAvailableCount;
	}

	public void setAvailableCount(Integer pAvailableCount) {
		mAvailableCount = pAvailableCount;
	}

	public Integer getSoldBooksCount() {
		return mSellCount;
	}

	public void setSoldBooksCount(Integer pSellCount) {
		mSellCount = pSellCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [mTitle=" + mTitle + ", mAuthor=" + mAuthor + "]";
	}
}
