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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import board.model.Board;
import board.model.BoardDao;
import member.model.Member;

@Controller
public class BoardReplyController {
	private final String command = "/reply.br";
	private final String getPage = "reply";
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(Model model, int boardNum, HttpSession session, RedirectAttributes attributes) {
		
		Board board = boardDao.getOne(boardNum);

		
		if(board==null) {
			attributes.addFlashAttribute("msg", "존재하지 않는 게시글입니다.");
			return "redirect:list.br";
		}
		
		if(session.getAttribute("loginInfo")==null) {
			attributes.addFlashAttribute("msg", "로그인을 해주세요.");
			return "redirect:list.br";
		}
		
		model.addAttribute("target", board);
		
		return getPage;		
	}
	
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(Model model, int targetBoardNum, @Valid @ModelAttribute("board") Board board, BindingResult bindingResult, HttpServletRequest request) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("에러발생");
			model.addAttribute("board", board);
			Board target = boardDao.getOne(targetBoardNum);
			model.addAttribute("target", target);
			
			return getPage;
		}
		
		board.setIp(request.getRemoteAddr());
		System.out.println("-- reply target board bean --");
		System.out.println(board.toString());
		
		boardDao.changeSteps(board);
		int cnt = boardDao.insertReply(board);
		return "redirect:/list.br";		
	}
	
}



