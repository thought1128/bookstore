package admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale.Category;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import admin.model.Product;
import admin.model.ProductDao;
import member.model.Member;

@Controller
public class ProductInputController {
	
	final String command ="/input.prd";
	final String getPage ="admin_ProductInputForm";
	final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	ServletContext servletContext; 
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction(Category category,Model model,HttpSession session) {
		Member member = (Member)session.getAttribute("loginInfo");
		if(member==null) {
			session.setAttribute("destination", "redirect:/adminMain.prd");

			return "redirect:/adminMain.prd";	
		}
		if(!(member.getId().equals("admin"))) {
			return "redirect:/adminMain.prd";	
		}
		return getPage;
	}

	 @RequestMapping(value=command,method = RequestMethod.POST) 
	  public ModelAndView doAction(
			  @Valid Product product, 
			  BindingResult result,
			  @RequestParam(value="targetDate", required = false) String targetDate,
			  HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();

			String image = product.getImage();
			
			String uploadPath = servletContext.getRealPath("/resources/book_images");
			
			
			MultipartFile multi = product.getUpload();
			
			product.setPublishedDate(targetDate);

			System.out.println(product.toString());
			if (result.hasErrors()) {
				mav.setViewName(getPage);
			}
			else {
				int cnt = productDao.insertProduct(product);
				if(cnt == 1) {
					File f = new File(uploadPath+"\\"+image);
					
					try {
						multi.transferTo(f);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					mav.setViewName("redirect:/detail.pv?isbn="+product.getIsbn());
					
				}
				else {
					mav.setViewName(getPage);
				}
					
			}
			return mav;
		}
		
}
