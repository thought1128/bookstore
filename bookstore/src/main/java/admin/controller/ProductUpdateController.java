package admin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import admin.model.Product;
import admin.model.ProductDao;

@Controller
public class ProductUpdateController {
	
	final String command= "update.prd";
	final String getPage= "admin_ProductUpdateForm";
	final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction(
			@RequestParam(value="isbn" ,required=true) String isbn,
			@RequestParam(value="pageNumber" ,required=true) String pageNumber,
			@RequestParam(value="pageSize" ,required=true) String pageSize,
			
			Model model,
			HttpSession session) {
		System.out.println(isbn);
		System.out.println(pageNumber);
		System.out.println(pageSize);
		
//
//		if(session.getAttribute("loginInfo") == null) {
//			session.setAttribute("destination", "redirect:/update.prd?isbn="+isbn); 
//			return "redirect:/list.prd";
//		}
//		else {
//			Product product = productDao.getData(isbn);
//			model.addAttribute("product", product);
//			return getPage;
//		}		
		
		Product product = productDao.getData(isbn);
		model.addAttribute("product", product);
		return getPage;
	}
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(@Valid Product product,
			BindingResult result,
			@RequestParam(value="targetDate", required = false) String targetDate) {
		
		if(result.hasErrors()) {
			System.out.println("바인딩 ㅇ[러? ");
			
		}
		System.out.println(targetDate);
		product.setPublishedDate(targetDate);
		
		String image = product.getImage();
		System.out.println("PUC image:" + image);
		
		String upload2 = product.getUpload2();
		
		String uploadPath = servletContext.getRealPath("/resources/book_images");
		
		
		
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		System.out.println("----tostring-----");
		System.out.println(product.toString());
		int cnt = productDao.updateProduct(product);
		if(cnt==1) {
			
			File uploadFile = new File(uploadPath+"\\"+image);
			File deleteFile = new File(uploadPath+"\\"+upload2);
			deleteFile.delete();
			
			MultipartFile multi = product.getUpload();
			
			try {
				multi.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
					
			mav.setViewName(gotoPage);
			return mav;
		}
		else {
			mav.setViewName(getPage);
			return mav;
		}
		
	}
}
