package member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.Member;
import orders.model.OrderDao;
import orders.model.Orders;

@Controller
public class MemberMyPageController {
	private final String command = "/myPage.me";
	private String getPage = "myPage";
	private String gotoPage = "redirect:/login.me";
	private String gotoPage2 = "redirect:/orderMemberList.me";
	
	@Autowired
	OrderDao odao;
	
	@RequestMapping(command)
	public String doAction(HttpSession session,Model model) {
		Member member =  (Member)session.getAttribute("loginInfo");
		if(member == null) {
			session.setAttribute("destination", "redirect:/myPage.me");
			return gotoPage;

		}else {
			if(!(member.getId().equals("admin"))){
				int beforeDeliveryCount = odao.getBeforeDeliveryCount(member.getMemberNum());
				int onDeliveryCount = odao.getOnDeliveryCount(member.getMemberNum());
				int afterDeliveryCount = odao.getAfterDeliveryCount(member.getMemberNum());
				int cancelDeliveryCount = odao.getCancelDeliveryCount(member.getMemberNum());
				List<Orders> list =  odao.getOrderByMember(member.getMemberNum());
				model.addAttribute("list", list);
				model.addAttribute("onDeliveryCount", onDeliveryCount);
				model.addAttribute("beforeDeliveryCount", beforeDeliveryCount);
				model.addAttribute("afterDeliveryCount", afterDeliveryCount);
				model.addAttribute("cancelDeliveryCount", cancelDeliveryCount);
				return getPage;
			}else {
				return gotoPage2;
				
			}
			
		}
	}

}
