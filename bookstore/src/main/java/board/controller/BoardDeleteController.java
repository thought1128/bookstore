package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import board.model.Board;
import board.model.BoardDao;
import member.model.Member;

@Controller
public class BoardDeleteController {
	private final String command = "/delete.br";
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(int boardNum, HttpSession session, RedirectAttributes attributes) {
		
		Board board = boardDao.getOne(boardNum);
		

		if(board==null) {
			attributes.addFlashAttribute("msg", "존재하지 않는 게시글입니다.");
			return "redirect:list.br";
		}
		
		if(session.getAttribute("loginInfo")==null) {
			attributes.addFlashAttribute("msg", "로그인을 해주세요.");
			return "redirect:list.br";
		}
		Member member = (Member)session.getAttribute("loginInfo");
		
		if(member.getId().equals("admin")) {
					
		}else if(member.getMemberNum() != board.getMemberNum()) {
			attributes.addFlashAttribute("msg", "삭제 할 권한이 없습니다.");
			return "redirect:list.br";
		}
		
		int cnt = boardDao.remove(boardNum);
		
		return "redirect:/list.br";		
	}
	
}


