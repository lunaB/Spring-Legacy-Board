package xyz.lunab.basic.service;

import xyz.lunab.basic.domain.UserVO;
import xyz.lunab.basic.dto.LoginDTO;

public interface UserService {
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	
}
