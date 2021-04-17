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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import admin.model.ProductDao;
import board.model.Board;
import board.model.BoardDao;
import member.model.Member;
import product.model.ProductBean;
import product.model.ProductViewDao;
import review.model.Product;
import review.model.Review;
import review.model.ReviewDao;

@Controller
public class ReviewInsertController {
	private final String command = "/insert.rv";
	private final String getPage = "insert";
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private ProductViewDao productDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(Model model, HttpSession session, RedirectAttributes attributes, String isbn) {
		System.out.println("url : "+command);
		String name = null;
		int memberNum = 0;

		if(session.getAttribute("loginInfo") == null) {
			attributes.addFlashAttribute("msg", "로그인을하세요.");
			return "redirect:detail.pv?isbn="+isbn;
		}
		
		System.out.println("isbnnn : "+isbn);
		ProductBean bean= productDao.getProductIsbn(isbn);
		System.out.println(bean.getIsbn());
		model.addAttribute("product", bean);

		return getPage;		
	}
	
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(Model model, Product product, String isbn, @Valid Review review, BindingResult bindingResult, HttpServletRequest request) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("에러발생");
			model.addAttribute("review", review);
			ProductBean productBean = productDao.getProductIsbn(isbn);
			model.addAttribute("product", productBean);

			return getPage;
		}
		
		review.setIp(request.getRemoteAddr());
		System.out.println("-- insert target review bean --");		
		
		String image = review.getImage();
		System.out.println("image : "+image);
		
		String uploadPath = servletContext.getRealPath("/resources/reviewImage");

		System.out.println("/resources/reviewImage:"+servletContext.getRealPath("/resources/reviewImage"));

		
		MultipartFile multi = review.getUpload();

		System.out.println(review.toString());	

		int cnt = reviewDao.insert(review);
		
		if(cnt == 1) {
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
			
		}
		else {
		
			return getPage;		
		}
		
		
		
		
	}
	
}
