package review.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.naming.Binding;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class ReviewUpdateController {
	private final String command = "/update.rv";
	private final String getPage = "update";
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(Model model, int reviewNum, HttpSession session, RedirectAttributes attributes) {
		
		Review review = reviewDao.getOne(reviewNum);
		
		if(review==null) {
			attributes.addFlashAttribute("msg", "존재하지 않는 게시글입니다.");
			return "redirect:list.pv";
		}
		
		if(session.getAttribute("loginInfo")==null) {
			attributes.addFlashAttribute("msg", "로그인을 해주세요.");
			return "redirect:read.rv?reviewNum="+reviewNum;
		}
		
		Member member = (Member)session.getAttribute("loginInfo");

		if(member.getMemberNum() != review.getMemberNum()) {
			attributes.addFlashAttribute("msg", "수정 할 권한이 없습니다.");
			return "redirect:read.rv?reviewNum="+reviewNum;
		}
		
		model.addAttribute("review", review);
		
		return getPage;		
	}
	
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(Model model, @Valid Review review, BindingResult bindingResult, HttpServletRequest request) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("에러발생");
			model.addAttribute("review", review);

			return getPage;
		}

		review.setIp(request.getRemoteAddr());
		System.out.println("-- update target review bean --");
		
		String image = review.getImage();
		String upload2 = review.getUpload2();
		System.out.println("----test----");
		System.out.println("image :"+image);
		System.out.println("upload2 :"+upload2);
		boolean isNewImage = image==null||image.length()==0;
		if(isNewImage) {
			System.out.println("새로운 사진이 없다.");
			review.setImage(upload2);
		}
		String uploadPath = servletContext.getRealPath("/resources/reviewImage");

		
		int cnt = reviewDao.update(review);
		
		if(cnt == 1) {
			if(!isNewImage) {
				MultipartFile multi = review.getUpload();
				
				File before = new File(uploadPath+"\\"+upload2);
				File after = new File(uploadPath+"\\"+image);
				before.delete();	
				
				
				try {
					multi.transferTo(after);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			System.out.println(review.toString());	

			return "redirect:/detail.pv?isbn="+review.getIsbn();		
			
		}
		else {
			return getPage;	
		}		
	}
	
}


