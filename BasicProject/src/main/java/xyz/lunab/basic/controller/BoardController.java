package xyz.lunab.basic.controller;

import java.util.Date;

import javax.inject.Inject;

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
import xyz.lunab.basic.exception.ArticleNotFound;
import xyz.lunab.basic.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService boardService;
	
//	@RequestMapping(value="/list", method=RequestMethod.GET)
//	public String listAll(Model model) throws Exception {
//		model.addAttribute("list", boardService.listAll());
//		return "basic/list";
//	}
	
//	@RequestMapping(value={"/list", "/list/{page}", "/list/{page}/{perPageNum}"}, method=RequestMethod.GET)
//	public String listPage(PageCriteria pageCriteria, Model model) throws Exception {
//		
//		model.addAttribute("list", boardService.listPage(pageCriteria));
//		
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setPageCriteria(pageCriteria);
//		pageMaker.setTotalCount(boardService.countTotal());
//		
//		model.addAttribute("pageMaker", pageMaker);
//		logger.info(pageMaker.toString());
//		return "basic/list";
//	}
	
	@RequestMapping(value={"/list", "/list/{page}", "/list/{page}/{perPageNum}"}, method=RequestMethod.GET)
	public String searchListPage(SearchCriteria searchCriteria, Model model) throws Exception {

		logger.info(searchCriteria.toString());
		logger.info(searchCriteria.getPage()+"");
		logger.info(searchCriteria.getPageStart()+"");
		logger.info(searchCriteria.getPerPageNum()+"");
		
		
		model.addAttribute("list", boardService.searchListPage(searchCriteria));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageCriteria(searchCriteria);
		pageMaker.setTotalCount(boardService.searchCount(searchCriteria));
		
		model.addAttribute("pageMaker", pageMaker);
		return "basic/searchList";
	}
	
	@RequestMapping(value="/read/{bno}", method=RequestMethod.GET)
	public String readPage(@PathVariable("bno") int bno, Model model) throws Exception {
		try {
			BoardVO vo = boardService.read(bno);
			vo.setContent(vo.getContent().replace("\r\n", "<br/>"));
			model.addAttribute(vo);
		} catch(Exception e) {
			throw new ArticleNotFound();
		}
		return "basic/post";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerPage() {
		return "basic/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(BoardVO board, RedirectAttributes rttr) throws Exception {
		
		board.setWriter("운영자");
		boardService.regist(board);
		rttr.addFlashAttribute("success", true);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/modify/{bno}", method=RequestMethod.GET)
	public String modifyPage(@PathVariable("bno") int bno, Model model) throws Exception {
		
		model.addAttribute(boardService.read(bno));
		
		return "basic/modify";
	}
	
	@RequestMapping(value="/modify/{bno}", method=RequestMethod.POST)
	public String modify(@PathVariable("bno") int bno, BoardVO vo, RedirectAttributes rttr) throws Exception {
		
		vo.setBno(bno);
		logger.info(vo.toString());
		boardService.modify(vo);
		rttr.addFlashAttribute("success", true);
		rttr.addFlashAttribute("message", "성공적으로 수정 완료되었습니다.");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/remove/{bno}", method=RequestMethod.GET)
	public String remove(@PathVariable("bno") int bno, RedirectAttributes rttr) throws Exception {
		
		boardService.remove(bno);
		
		rttr.addFlashAttribute("success", true);
		rttr.addFlashAttribute("message", "성공적으로 삭제가 완료되었습니다.");
		
		return "redirect:/board/list";
	}
	
}
