package product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductClassifyBean;
import product.model.ProductViewDao;
import utility.Paging;

@Controller
public class ProductViewController {
	private final String COMMAND = "/view.pv";
	private final String GETPAGE = "product_view";

	@Autowired
	private ProductViewDao productDao;

	@RequestMapping(value =  COMMAND)
	public ModelAndView doActionGet(
			@RequestParam(value = "whatColumn", required = false) String whatColumn,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "currenturi", required = false) String currenturi,
			HttpServletRequest request) {
		if(currenturi == null) {
			currenturi = "view.pv";
		}
		ModelAndView mav = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", keyword);
		

		int totalCount = productDao.getProductCount(map);
		String url = request.getContextPath() + COMMAND;
		Paging pageInfo = new Paging(pageNumber, "12", totalCount, url, whatColumn, keyword);
		int pageNumberNow = pageInfo.getPageNumber();
		int numbering = totalCount - pageInfo.getOffset();
		
		List<ProductBean> lists = productDao.getPagingProductList(pageInfo, map);
		List<ProductClassifyBean> classify = productDao.getProductGroupByClassify();
		mav.addObject("list", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("totalCount", totalCount);
		mav.addObject("pageNumber", pageNumberNow);
		mav.addObject("numbering", numbering);
		mav.addObject("classifyList", classify);
		mav.addObject("currenturi", currenturi);
		mav.setViewName(GETPAGE);
		return mav;
	}
}