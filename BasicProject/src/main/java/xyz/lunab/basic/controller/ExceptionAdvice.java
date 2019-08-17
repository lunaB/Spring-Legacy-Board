package xyz.lunab.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import xyz.lunab.basic.exception.ArticleNotFound;

@ControllerAdvice
public class ExceptionAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
	
	@ExceptionHandler(ArticleNotFound.class)
	public ModelAndView common(ArticleNotFound e) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("basic/errorPage");
		
		mav.addObject("title", "에러발생");
		mav.addObject("msg", "메세지 : "+ e.getMessage());
		
		return mav;
		
	}
	
}
