package xyz.lunab.basic.persistence;

import java.util.List;

import xyz.lunab.basic.domain.BoardVO;
import xyz.lunab.basic.domain.PageCriteria;
import xyz.lunab.basic.domain.SearchCriteria;

public interface BoardDAO {
	
	// INSERT
	public void insert(BoardVO vo) throws Exception;
	// SELECT with bno
	public BoardVO select(int bno) throws Exception;
	// UPDATE title, content
	public void update(BoardVO vo) throws Exception;
	// DELETE
	public void delete(int bno) throws Exception;
	
	/* v0 */
	// SELECT ALL
	public List<BoardVO> listAll() throws Exception;
	
	/* v1 */
	// SELECT PAGE
	public List<BoardVO> listPage(PageCriteria pageCriteria) throws Exception;
	// SELECT COUNT
	public int count() throws Exception;
	
	/* v2 */
	// SELECT searchPAGE
	public List<BoardVO> searchListPage(SearchCriteria searchCriteria) throws Exception;
	// SELECT searchCOUNT
	public int searchCount(SearchCriteria searchCriteria) throws Exception;
	
	
}
