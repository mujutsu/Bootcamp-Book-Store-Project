package curs.utils;

import curs.utils.SearchType;

public class SearchFilter {
	private String mQuery;
	private SearchType mType;
	private int mLimit;
	public String getQuery() {
		return mQuery;
	}
	public void setQuery(String pQuery) {
		this.mQuery = pQuery;
	}
	public SearchType getType() {
		return mType;
	}
	public void setType(SearchType pType) {
		this.mType = pType;
	}
	public int getLimit() {
		return mLimit;
	}
	public void setLimit(int pLimit) {
		this.mLimit = pLimit;
	}

}