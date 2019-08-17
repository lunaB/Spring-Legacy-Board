package xyz.lunab.basic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import xyz.lunab.basic.domain.BoardVO;
import xyz.lunab.basic.domain.PageCriteria;
import xyz.lunab.basic.domain.SearchCriteria;
import xyz.lunab.basic.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Inject
	private BoardDAO dao;
	
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		dao.insert(vo);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return dao.select(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void remove(int bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}
	
	@Override
	public List<BoardVO> listPage(PageCriteria pageCriteria) throws Exception {
		return dao.listPage(pageCriteria);
	}
	
	@Override
	public int countTotal() throws Exception {
		return dao.count();
	}
	
	@Override
	public List<BoardVO> searchListPage(SearchCriteria searchCriteria) throws Exception {
		return dao.searchListPage(searchCriteria);
	}
	
	@Override
	public int searchCount(SearchCriteria searchCriteria) throws Exception {
		return dao.searchCount(searchCriteria);
	}
}
