package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import admin.model.OProduct;
import admin.model.OProductDao;
import orders.model.OrderDao;

@Controller
public class MemberRefundOrderController {

	private final String command = "/refundOrder.me";
	private String getPage = "refundOrderForm";
	private String gotoPage = "redirect:/login.me";
	private String gotoPage2 = "redirect:/myPage.me";
	
	@Autowired
	OProductDao opdao;
	
	@Autowired
	OrderDao odao;
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public String doAction(@RequestParam(value = "orderNum") int orderNum, Model model,HttpSession session) {
		if(session.getAttribute("loginInfo")==null) {
			session.setAttribute("destination", gotoPage2);
			return gotoPage;
		}
		List<OProduct> list =  opdao.getOProductByOrderNum(orderNum);
		model.addAttribute("list", list);
		model.addAttribute("orderNum", orderNum);
		return getPage;
	}
	
	@RequestMapping(value = command,method = RequestMethod.POST)
	public String doAction(@RequestParam(value = "orderNum") int orderNum,@RequestParam(value = "reason") String reason, @RequestParam(value = "status") String status,Model model,HttpServletResponse response) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", status);
		map.put("reason", reason);
		map.put("orderNum",String.valueOf(orderNum));
		int cnt = odao.updateStatus(map);
		if(cnt==1) {
			return gotoPage2;
		}else {
			PrintWriter pw = response.getWriter();
			List<OProduct> list =  opdao.getOProductByOrderNum(orderNum);
			model.addAttribute("list", list);
			model.addAttribute("orderNum", orderNum);
			pw.print("<script type='text/javascript'>");
			pw.print("alert('주문 교환/환불 요청 실패.')");
			pw.print("</script>");
			pw.flush();
			return getPage;
		}
		
	}
}
