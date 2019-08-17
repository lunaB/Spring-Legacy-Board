package xyz.lunab.basic.service;

import org.springframework.stereotype.Service;

import xyz.lunab.basic.domain.UserVO;
import xyz.lunab.basic.dto.LoginDTO;
import xyz.lunab.basic.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO dao;

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

}
