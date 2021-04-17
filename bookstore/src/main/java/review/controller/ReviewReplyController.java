package review.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import board.model.Board;
import board.model.BoardDao;
import member.model.Member;
import review.model.Review;
import review.model.ReviewDao;

@Controller
public class ReviewReplyController {
	private final String command = "/reply.rv";
	private final String getPage = "reply";
	
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(Model model, int reviewNum, HttpSession session, RedirectAttributes attributes) {
		
		Review review = reviewDao.getOne(reviewNum);
		
		if(review==null) {
			attributes.addFlashAttribute("msg", "존재하지 않는 게시글입니다.");
			return "redirect:read.rv?reviewNum="+reviewNum;
		}
		
		if(session.getAttribute("loginInfo")==null) {
			attributes.addFlashAttribute("msg", "로그인을 해주세요.");
			return "redirect:read.rv?reviewNum="+reviewNum;
		}
		
		model.addAttribute("target", review);
		
		return getPage;		
	}
	
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(Model model, int targetReviewNum, @Valid Review review, BindingResult bindingResult, HttpServletRequest request) {

		if(bindingResult.hasErrors()) {
			System.out.println("에러발생");
			model.addAttribute("review", review);
			Review target = reviewDao.getOne(targetReviewNum);
			model.addAttribute("target", target);
			
			return getPage;
		}

		review.setIp(request.getRemoteAddr());
		System.out.println("-- reply target review bean --");
		System.out.println(review.toString());
		
		
		String image = review.getImage();
		System.out.println("image : "+image);
		
		String uploadPath = servletContext.getRealPath("/resources/reviewImage");

		System.out.println("/resources/reviewImage:"+servletContext.getRealPath("/resources/reviewImage"));
		
		MultipartFile multi = review.getUpload();

		System.out.println(review.toString());	
		
		int cnt = reviewDao.insertReply(review);
		
		
		if(cnt>=1) {
			reviewDao.changeSteps(review);
			
			File f = new File(uploadPath+"\\"+image);
			
			try {
				multi.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(review.toString());	
		
			return "redirect:/detail.pv?isbn="+review.getIsbn();		
			
		}else {		
			return getPage;	
		}
	}
	
}


