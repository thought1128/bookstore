package admin.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin.model.Product;
import admin.model.ProductDao;

@Controller
public class ProductDeleteController {
	
	final String command ="delete.prd";
	final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(command) 
	public String doAction(@RequestParam(value="isbn") String isbn,
			@RequestParam(value="pageNumber",required = true) int pageNumber){
		
		Product product = productDao.getOneProduct(isbn);
		System.out.println(product.getImage());
	    
	    	String uploadPath = servletContext.getRealPath("/resources");
		System.out.println("uploadPath : "+uploadPath);
		
		File deFile = new File(uploadPath+ File.separator +product.getImage());
		deFile.delete();
	    
	    
		productDao.deleteProduct(isbn);
		
		return gotoPage+"?pageNumber="+pageNumber;
	}

}
