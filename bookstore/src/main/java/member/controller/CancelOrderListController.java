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
public class CancelOrderListController {

	private final String command = "/cancelOrderList.me";
	private String getPage = "cancelOrderList";
	private String gotoPage = "redirect:/login.me";
	
	@Autowired
	OrderDao odao;
	
	@RequestMapping(value = command)
	public String doAction(HttpSession session,Model model) {
		Member member = (Member) session.getAttribute("loginInfo");
		if(member == null) {
			session.setAttribute("destination","redirect:"+command );
			return gotoPage;
		}else {
			
			List<Orders> list =  odao.getCancelListByMemberNum(member.getMemberNum());
			model.addAttribute("list", list);
			
			return getPage;
		}
		
		
	}
}
