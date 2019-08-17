package xyz.lunab.basic.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import xyz.lunab.basic.domain.BoardVO;
import xyz.lunab.basic.domain.PageCriteria;
import xyz.lunab.basic.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	
	private static String namespace = "xyz.lunab.basic.mapper.BoardMapper";
	
	@Override
	public void insert(BoardVO vo) throws Exception {
		sqlSession.insert(namespace + ".insert", vo);
	}
	
	@Override
	public BoardVO select(int bno) throws Exception {
		return sqlSession.selectOne(namespace + ".select", bno);
	}
	
	@Override
	public void update(BoardVO vo) throws Exception {
		sqlSession.update(namespace + ".update", vo);
	}
	
	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete(namespace + ".delete", bno);
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return sqlSession.selectList(namespace + ".listAll");
	}
	
	@Override
	public List<BoardVO> listPage(PageCriteria pageCriteria) throws Exception {
		
		return sqlSession.selectList(namespace + ".listPage", pageCriteria);
	}
	
	@Override
	public int count() throws Exception {
		return sqlSession.selectOne(namespace + ".count");
	}
	
	@Override
	public List<BoardVO> searchListPage(SearchCriteria searchCriteria) throws Exception {
		return sqlSession.selectList(namespace + ".searchListPage", searchCriteria);
	}
	
	@Override
	public int searchCount(SearchCriteria searchCriteria) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchCount", searchCriteria);
	}
}
