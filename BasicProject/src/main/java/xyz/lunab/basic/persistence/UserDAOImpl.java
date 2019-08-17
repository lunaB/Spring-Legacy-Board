package xyz.lunab.basic.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import xyz.lunab.basic.domain.UserVO;
import xyz.lunab.basic.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "xyz.lunab.basic.mapper.UserMapper";
	
	@Override
	public void insert(UserVO vo) throws Exception {
		sqlSession.insert(namespace + ".insertUser", vo);
	}
	
	@Override
	public UserVO select(String uid) throws Exception {
		return sqlSession.selectOne(namespace + ".selectUser", uid);
	}
	
	@Override
	public UserVO selectWithPW(String uid, String upw) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("uid", uid);
		map.put("upw", upw);
		
		return sqlSession.selectOne(namespace + ".selectWithPW", map);
	}
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return sqlSession.selectOne(namespace + ".login", dto);
	}
	
}
