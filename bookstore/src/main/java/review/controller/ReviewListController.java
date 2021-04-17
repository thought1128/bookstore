package review.controller;

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

import review.model.Product;
import review.model.Review;
import review.model.ReviewDao;
import utility.Paging;

@Controller
public class ReviewListController {
	private final String command = "/list.rv";
	private final String command2 = "/read.rv";
	private final String getPage = "list";
	private final String getPage2 = "read";

	
	@Autowired
	private ReviewDao reviewDao;
	
	@RequestMapping(value=command)
	public String doAction(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			HttpServletRequest request,
			Model model, 
			HttpSession session,
			Product product) {
		
		System.out.println(product.toString());
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		if(whatColumn.equals("memberNum")) {
			
			map.put("keyword", keyword);
			int totalCount = reviewDao.getMyTotalCount(map);
			
			String url = request.getContextPath() + command; 
			Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
			
			List<Review> reviewList = reviewDao.getMyDataList(pageInfo, map);		
			
			model.addAttribute("reviewList", reviewList);
			model.addAttribute("pageInfo", pageInfo);
			
			return getPage;		
		}
			
		
		map.put("keyword", "%"+keyword+"%");	
		
		
		int totalCount = reviewDao.getTotalCount(map);
		
		String url = request.getContextPath() + command; 
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		
		List<Review> reviewList = reviewDao.getDataList(pageInfo, map);		
		
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("product", product);

		return getPage;		
	}
	

	@RequestMapping(value=command2)
	public String doAction(Model model, int reviewNum) {
		Review review = reviewDao.getOne(reviewNum);
		model.addAttribute("review", review);
		reviewDao.hitReview(reviewNum);

		return getPage2;		
	}
	

}

