package xyz.lunab.basic.service;

import java.util.List;

import xyz.lunab.basic.domain.BoardVO;
import xyz.lunab.basic.domain.PageCriteria;
import xyz.lunab.basic.domain.SearchCriteria;

public interface BoardService {
	
	// 게시물 등록
	public void regist(BoardVO vo) throws Exception;
	// 게시물 조회
	public BoardVO read(int bno) throws Exception;
	// 게시물 수정
	public void modify(BoardVO vo) throws Exception;
	// 게시물 삭제
	public void remove(int bno) throws Exception;
	// v0 게시물 전체 조회
	public List<BoardVO> listAll() throws Exception;
	// v1 게시물 페이지별 조회
	public List<BoardVO> listPage(PageCriteria pageCriteria) throws Exception;
	// v1 게시물 총 갯수 조회
	public int countTotal() throws Exception;
	// v2 검색 게시물 페이지별 조회
	public List<BoardVO> searchListPage(SearchCriteria searchCriteria) throws Exception;
	// v2 검색 게시물 총 갯수 조회
	public int searchCount(SearchCriteria searchCriteria) throws Exception;
}
