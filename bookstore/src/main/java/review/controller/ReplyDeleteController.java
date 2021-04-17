package review.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
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
import review.model.Review;
import review.model.ReviewDao;

@Controller
public class ReplyDeleteController {
	private final String command = "/delete.rv";
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(int reviewNum, HttpSession session, RedirectAttributes attributes) {
		
		Review review= reviewDao.getOne(reviewNum);
		
		if(review==null) {
			attributes.addFlashAttribute("msg", "존재하지 않는 게시글입니다.");
			return "redirect:read.rv?reviewNum="+reviewNum;
		}
		String targetIsbn = review.getIsbn();

		if(session.getAttribute("loginInfo")==null) {
			attributes.addFlashAttribute("msg", "로그인을 해주세요.");
			return "redirect:read.rv?reviewNum="+reviewNum;
		}
		
		Member member = (Member)session.getAttribute("loginInfo");

		if(member.getId().equals("admin")) {
			System.out.println("admin");
		} else if(member.getMemberNum() != review.getMemberNum()) {
			attributes.addFlashAttribute("msg", "삭제 할 권한이 없습니다.");
			return "redirect:read.rv?reviewNum="+reviewNum;
		}
		
		int cnt = reviewDao.remove(reviewNum);
		
		if(cnt>=1) {
			String uploadPath = servletContext.getRealPath("/resources/reviewImage");
			File delFile = new File(uploadPath+File.separator+review.getImage());
			delFile.delete();
		}
		
		return "redirect:/detail.pv?isbn="+targetIsbn;		
	}
	
}


