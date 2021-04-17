package admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale.Category;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
public class ProductInputController {
	
	final String command ="/input.prd";
	final String getPage ="admin_ProductInputForm";
	final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	ServletContext servletContext; 
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction(Category category,Model model) {
		
		//List<Category> lists = categoryDao.selectAll(); 
		//model.addAttribute("lists", lists);
		return getPage;
	}

	 @RequestMapping(value=command,method = RequestMethod.POST) 
	  public ModelAndView doAction(
			  @Valid Product product, 
			  BindingResult result,
			  @RequestParam(value="targetDate", required = false) String targetDate,
			  HttpServletRequest request) {
			String image = product.getImage();
			System.out.println("image:" + image);
			
			System.out.println("servletContext:" + servletContext);
			System.out.println("/:"+servletContext.getRealPath("/"));
			System.out.println("/resources:"+servletContext.getRealPath("/resources"));
			// resources:  = C:\Spring_hjin\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\bookstore\1.jpg
			
			String uploadPath = servletContext.getRealPath("/resources");
			
			System.out.println("result.hasErrors():"+result.hasErrors());
			
			ModelAndView mav = new ModelAndView();
			
			MultipartFile multi = product.getUpload();
			System.out.println("-----tostring-----");
			System.out.println(targetDate);
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
					
					mav.setViewName(gotoPage);
					
				}
				else {
					mav.setViewName(getPage);
				}
					
			}
			return mav;
		}
		
}
