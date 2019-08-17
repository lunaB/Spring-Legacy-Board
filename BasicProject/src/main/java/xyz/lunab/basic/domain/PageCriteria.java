package xyz.lunab.basic.domain;

public class PageCriteria {
	
	/*
	 *	페이지 수
	 *  페이지당 게시글 수
	 */
	private int page;
	private int perPageNum;
	
	public PageCriteria() {
		this.page = 1;
		this.perPageNum = 20;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		
		if(page <= 0) page = 1;
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) this.perPageNum = 10;
		this.perPageNum = perPageNum;
	}

	// Only Mapper
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
	
	
	@Override
	public String toString() {
		return "PageCriteria [page=" + page + ", perPageNum=" + perPageNum + ", pageStart=" + getPageStart() + "]";
	}
	
}
