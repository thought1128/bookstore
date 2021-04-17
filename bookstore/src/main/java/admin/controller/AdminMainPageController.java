package admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import orders.model.OrderDao;
import orders.model.Orders;
import utility.Paging;

@Controller
public class AdminMainPageController {
	
	private final String command = "/adminMain.prd";
	private String getPage = "adminMainPage";
	private String gotoPage = "redirect:/login.me";
	private String gotoPage2 = "redirect:/myPage.me";
	
	
	@Autowired
	OrderDao odao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam(value="keyword",required = false) String keyword,
						   @RequestParam(value="pageNumber",required = false) String pageNumber,
						   @RequestParam(value="pageSize",required = false) String pageSize,
						   HttpServletRequest request,
						   HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member member = (Member)session.getAttribute("loginInfo");
		if(member==null) {
			session.setAttribute("destination", "redirect:/adminMain.prd");
			mav.setViewName(gotoPage);
			return mav;	
		}else {
			if(member.getId().equals("admin")) {
				Map<String, String> map = new HashMap<String, String>();
				String whatColumn="status";
				map.put("whatColumn", whatColumn); 
				map.put("keyword", "%"+keyword+"%"); 
				int totalCount = odao.getTotalCount(map);
				String url = request.getContextPath() + command;
				Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
				List<Orders> orderMemberLists = odao.getOrderMemberList(pageInfo,map);
				mav.addObject("orderMemberLists", orderMemberLists);
				mav.addObject("pageInfo", pageInfo);
				mav.setViewName(getPage);
				return mav;
				
			}else {
				mav.setViewName(gotoPage2);
				return mav;
				
			}
		}
	}

}
