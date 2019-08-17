package xyz.lunab.basic.persistence;

import xyz.lunab.basic.domain.UserVO;
import xyz.lunab.basic.dto.LoginDTO;

public interface UserDAO {

	public void insert(UserVO vo) throws Exception;
	public UserVO select(String uid) throws Exception;
	public UserVO selectWithPW(String uid, String upw) throws Exception;
	public UserVO login(LoginDTO dto) throws Exception;
	
}
