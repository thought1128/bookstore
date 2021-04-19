package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;

@Controller
public class MemberLoginController {
	private final String command = "/login.me";
	private String getPage = "login";

	@Autowired
	MemberDao mdao;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		Member member = (Member)session.getAttribute("loginInfo");
		if(member==null) {
			return getPage;
		}else {
			if(member.getId().equals("admin")) {
				return "redirect:/adminMain.prd";
			}else {
				return "redirect:/myPage.me";
			}
		}
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@RequestParam(value = "id") String id,
			@RequestParam(value = "password") String password, HttpServletResponse response, HttpSession session)
			throws IOException {
		ModelAndView mav = new ModelAndView();

		Member member = mdao.login(id);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		if (member == null) {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('해당 아이디가 존재하지 않습니다.')");
			pw.print("</script>");
			pw.flush();
			mav.setViewName(getPage);
		} else {
			if (password.equals(member.getPassword())) {
				session.setAttribute("loginInfo", member);
				String destination = (String) session.getAttribute("destination");
				if(member.getId().equals("admin")) {
					destination = "redirect:/adminMain.prd";
					mav.setViewName(destination);
					return mav;
				}
			} else {
				pw.print("<script type='text/javascript'>");
				pw.print("alert('잘못된 비밀번호입니다.')");
				pw.print("</script>");
				pw.flush();
				mav.setViewName(getPage);
			}

		}
		mav.setViewName("redirect:/main.pv");
		return mav;
	}

}
