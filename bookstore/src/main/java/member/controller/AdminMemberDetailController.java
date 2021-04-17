package member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;
import orders.model.OrderDao;
import orders.model.Orders;

@Controller
public class AdminMemberDetailController {
	private final String command = "/detail.me";
	private String getPage = "adminMemberDetail";
	private String gotoPage = "redirect:/login.me";
	private String gotoPage2 = "redirect:/myPage.me";
	
	@Autowired
	MemberDao mdao;
	
	@Autowired
	OrderDao odao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam(value = "memberNum") int memberNum,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member member = (Member)session.getAttribute("loginInfo");
		if(member==null) {
			session.setAttribute("destination", "redirect:/memberList.me");
			mav.setViewName(gotoPage);
			return mav;
		}else {
			if(member.getId().equals("admin")) {
				Member memberDetail = mdao.getMemberDetail(memberNum);
				List<Orders> orderList  =  odao.getOrderDetail(memberNum);
				mav.addObject("memberDetail",memberDetail);
				mav.addObject("orderList",orderList);
				mav.setViewName(getPage);
				return mav;
			}else {
				mav.setViewName(gotoPage2);
				return mav;
			}
		}
	}

}
