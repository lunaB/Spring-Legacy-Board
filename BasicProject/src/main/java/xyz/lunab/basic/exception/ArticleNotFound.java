package xyz.lunab.basic.exception;


public class ArticleNotFound extends Exception {
	
	@Override
	public String getMessage() {
		return "게시물을 불러오는데 실패했습니다. 글번호가 올바르지 않거나 이미 삭제된 게시물 입니다.";
	}
	
}
