package member.controller;

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
import member.model.MemberDao;
import utility.Paging;

@Controller
public class AdminMemberListController {
	private final String command = "/memberList.me";
	private String getPage = "adminMemberList";
	private String gotoPage = "redirect:/login.me";
	private String gotoPage2 = "redirect:/myPage.me";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam(value="whatColumn",required = false) String whatColumn,
						   @RequestParam(value="keyword",required = false) String keyword,
						   @RequestParam(value="pageNumber",required = false) String pageNumber,
						   @RequestParam(value="pageSize",required = false) String pageSize,
						   HttpServletRequest request,
						   HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member member = (Member)session.getAttribute("loginInfo");
		if(member==null) {
			session.setAttribute("destination", "redirect:/memberList.me");
			mav.setViewName(gotoPage);
			return mav;	
		}else {
			if(member.getId().equals("admin")) {
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("whatColumn", whatColumn); 
				map.put("keyword", "%"+keyword+"%"); 
				int totalCount = mdao.getTotalCount(map);
				String url = request.getContextPath() + command;
				Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
				List<Member> memberLists = mdao.getMemberList(pageInfo,map);
				mav.addObject("memberLists", memberLists);
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
