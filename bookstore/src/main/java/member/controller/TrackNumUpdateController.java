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
import member.model.Member;
import orders.model.OrderDao;

@Controller
public class TrackNumUpdateController {
	
	private final String command = "/insertTrackNum.me";
	private String getPage = "insertTrackNumForm";
	private String gotoPage = "redirect:/login.me";
	private String gotoPage2 = "redirect:/myPage.me";
	
	@Autowired
	OrderDao odao;

	@RequestMapping(value = command,method = RequestMethod.GET)
	public String doAction(@RequestParam(value = "orderNum") int orderNum, Model model,HttpSession session) {
		Member member = (Member)session.getAttribute("loginInfo");
		if(member == null) {
			session.setAttribute("destination", "redirect:/adminMain.prd"); 
			return gotoPage;
		}else {
			if(member.getId().equals("admin")) {
				model.addAttribute("orderNum", orderNum);
				return getPage;
			}else {
				return gotoPage2;
			}
		}
	}
	@RequestMapping(value = command,method = RequestMethod.POST)
	public String doAction(@RequestParam(value = "orderNum") int orderNum,@RequestParam(value = "trackNum") String trackNum, Model model,HttpSession session,HttpServletResponse response) throws IOException {
		Map<String, String> map =  new HashMap<String, String>();
		map.put("orderNum",String.valueOf(orderNum));
		map.put("trackNum",trackNum);
		int cnt = odao.insertTrackNum(map);
		if(cnt==1) {
			return "redirect:/adminMain.prd";
		}else {
			PrintWriter pw = response.getWriter();
			model.addAttribute("orderNum", orderNum);
			pw.print("<script type='text/javascript'>");
			pw.print("alert('택배번호 입력 실패.')");
			pw.print("</script>");
			pw.flush();
			return getPage;
		}
		
		
	}
}
