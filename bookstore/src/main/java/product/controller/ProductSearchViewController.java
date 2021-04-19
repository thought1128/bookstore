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
public class ProductSearchViewController {
	private final String COMMAND = "/search.pv";
	private final String GETPAGE = "product_search_list";

	@Autowired
	private ProductViewDao productDao;

	@RequestMapping(value =  COMMAND)
	public ModelAndView doActionGet(
			@RequestParam(value = "whatColumn", required = false) String whatColumn,
			@RequestParam(value = "whatColumn2", required = false) String whatColumn2,
			@RequestParam(value = "whatColumn3", required = false) String whatColumn3,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "pageNumber", required = false) String pageNumber, 
			@RequestParam(value = "search", required = true) String search, 
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if(search.equals("")) {
			mav.setViewName("redirect:/view.pv");
			return mav;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("whatColumn2", whatColumn2);
		map.put("whatColumn3", whatColumn3);
		map.put("keyword", keyword);
		map.put("search", "%"+search+"%");
		int totalCount = productDao.getSearchProductCount(map);
		String url = request.getContextPath() + COMMAND;
		Paging pageInfo = new Paging(pageNumber, "12", totalCount, url, whatColumn, keyword, search);
		int pageNumberNow = pageInfo.getPageNumber();

		List<ProductBean> lists = productDao.getSearchPagingProductList(pageInfo, map);
		List<ProductClassifyBean> classify = productDao.getSearchProductGroupByClassify(map);
		mav.addObject("list", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("totalCount", totalCount);
		mav.addObject("pageNumber", pageNumberNow);
		mav.addObject("classifyList", classify);
		mav.addObject("search", search);
		if(whatColumn != null) {
			mav.addObject("whatColumn3", whatColumn);
		}else{
			mav.addObject("whatColumn3", whatColumn3);
		}
		mav.setViewName(GETPAGE);
		return mav;
	}
}