package product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import product.model.ProductBean;
import product.model.ProductViewDao;
import review.model.Review;
import review.model.ReviewDao;
import utility.Paging;

@Controller
public class ProductDetailController {
	private final String COMMAND ="/detail.pv";
	private final String GETPAGE ="product_detail";
	
	@Autowired
	private ProductViewDao productDao;
	
	@Autowired
	private ReviewDao reviewDao;
	
	@RequestMapping(value =  COMMAND)
	public String doAction(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			@RequestParam(value="isbn", required = true)String isbn,
			HttpServletRequest request,
			Model model, 
			HttpSession session		
			) {
		ProductBean bean= productDao.getProductIsbn(isbn);
		model.addAttribute("product", bean);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		map.put("isbn", bean.getIsbn());
	
		int totalCount = reviewDao.getTotalCount(map);
		
		String url = request.getContextPath() + COMMAND; 
		Paging pageInfo = new Paging(isbn, pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		
		List<Review> reviewList = reviewDao.getDataList(pageInfo, map);		
		
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("pageInfo", pageInfo);
	
		return GETPAGE;
	}
}
