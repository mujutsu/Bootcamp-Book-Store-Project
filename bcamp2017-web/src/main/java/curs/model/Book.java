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
public class Book implements BookInterface{
	@Override
	public String toString() {
		return "Book [mTitle=" + mTitle + ", mAuthor=" + mAuthor + "]";
	}

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

	public void setAvailableCount(int pAvailableCount) {
		mAvailableCount = pAvailableCount;
	}

	public Integer getSellCount() {
		return mSellCount;
	}

	public void setSellCount(int pSellCount) {
		mSellCount = pSellCount;
	}

	@Override
	public void setAvailableCount(Integer pAvailable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSellCount(Integer pBooked) {
		// TODO Auto-generated method stub
		
	}

}
