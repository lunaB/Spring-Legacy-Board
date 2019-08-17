package xyz.lunab.basic.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import xyz.lunab.basic.domain.BoardVO;
import xyz.lunab.basic.domain.PageCriteria;
import xyz.lunab.basic.domain.PageMaker;
import xyz.lunab.basic.domain.SearchCriteria;
import xyz.lunab.basic.domain.UserVO;
import xyz.lunab.basic.dto.LoginDTO;
import xyz.lunab.basic.exception.ArticleNotFound;
import xyz.lunab.basic.service.BoardService;
import xyz.lunab.basic.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET(LoginDTO dto) throws Exception {
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void loginGET(LoginDTO dto, HttpSession session, Model model) throws Exception {
		
		UserVO vo = userService.login(dto);
		
		if(vo == null) return;
		
		model.addAttribute("UserVO", vo);
	}
	
}
