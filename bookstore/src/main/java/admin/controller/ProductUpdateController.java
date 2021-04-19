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
		
		ModelAndView mav = new ModelAndView();

		
		if (result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}

		System.out.println(targetDate);
		product.setPublishedDate(targetDate);
		
		String image = product.getImage();
		String upload2 = product.getUpload2();
		System.out.println("----test----");
		System.out.println("image :"+image);
		System.out.println("upload2 :"+upload2);
		boolean isNewImage = image==null||image.length()==0;
		if(isNewImage) {
			System.out.println("새로운 사진이 없다.");
			product.setImage(upload2);
		}
		String uploadPath = servletContext.getRealPath("/resources/book_images");
		
				
		System.out.println("----tostring-----");
		System.out.println(product.toString());
		int cnt = productDao.updateProduct(product);
		
		if(cnt==1) {
			if(!isNewImage) {
				MultipartFile multi = product.getUpload();
				
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
			
			mav.setViewName("redirect:/detail.pv?isbn="+product.getIsbn());
			return mav;
		}
		else {
			mav.setViewName(getPage);
			return mav;
		}
		
	}
}
