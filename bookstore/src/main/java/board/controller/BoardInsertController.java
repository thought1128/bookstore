package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import board.model.Board;
import board.model.BoardDao;
import member.model.Member;

@Controller
public class BoardInsertController {
	private final String command = "/insert.br";
	private final String getPage = "insert";
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(Model model, HttpSession session, RedirectAttributes attributes) {
		String name = null;
		int memberNum = 0;

		if(session.getAttribute("loginInfo") == null) {
			attributes.addFlashAttribute("msg", "로그인을하세요.");
			return "redirect:list.br";
		}
				
		return getPage;		
	}
	
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(@Valid Board board, BindingResult bindingResult, HttpServletRequest request) {	
		ModelAndView mav = new ModelAndView();
		System.out.println("hello");
		if(bindingResult.hasErrors()) {
			System.out.println("에러발생");
			mav.addObject("board", board);
			mav.setViewName(getPage);
		}else {
			board.setIp(request.getRemoteAddr());
			System.out.println("-- insert target board bean --");
			System.out.println(board.toString());

			int cnt = boardDao.insert(board);
			
			mav.setViewName("redirect:/list.br");
		}
		return mav;
		
	}
	
}


