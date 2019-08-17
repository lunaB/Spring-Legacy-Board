package xyz.lunab.basic.domain;

public class PageMaker {
	
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	// SET
	private int displayPageNum = 10;
	
	// SET
	private PageCriteria pageCriteria;
	private int totalCount;
	
	private void calculateData() {
		
		endPage = (int) (Math.ceil(pageCriteria.getPage() / (double) displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) pageCriteria.getPerPageNum()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = (startPage == 1 ? false : true);
		next = (endPage * pageCriteria.getPerPageNum() >= totalCount ? false : true);
		
	}

	public String searchQuery() {
		
		String result = "";
		String sType = ((SearchCriteria)pageCriteria).getSearchType();
		String keyword = ((SearchCriteria)pageCriteria).getKeyword();
		
		if(sType != null && keyword != null) {
			result += "searchType=" + sType;
			result += "&";
			result += "keyword=" + keyword;
		} 
		
		return result;
		
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calculateData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public PageCriteria getPageCriteria() {
		return pageCriteria;
	}

	public void setPageCriteria(PageCriteria pageCriteria) {
		this.pageCriteria = pageCriteria;
	}

	@Override
	public String toString() {
		return "PageMaker [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", displayPageNum=" + displayPageNum + ", pageCriteria=" + pageCriteria + ", totalCount=" + totalCount
				+ "]";
	}
	
}
