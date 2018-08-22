package com.yxw.jd.pojo;

import java.util.List;

public class Page<T> {
    
	private int recordCount;//总记录数
	private int pageCount;//总页数
	private int curPage;//当前页
	private int size;
    private List<T> productList;

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<T> getProductList() {
		return productList;
	}

	public void setProductList(List<T> productList) {
		this.productList = productList;
	}

}
