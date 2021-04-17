package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.Member;
import member.model.MemberDao;

@Controller
public class MemberDeleteController {

	private final String command = "/deleteMember.me";
	private String getPage = "deleteMemberForm";
	private String gotoPage = "redirect:/login.me";
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		Member member = (Member) session.getAttribute("loginInfo");
		if(member==null) {
			session.setAttribute("destination", "redirect:/deleteMember.me");
			return gotoPage;	
		}else {
			if(member.getId().equals("admin")) {
				return "redirect:/myPage.me";
			}else {
				return getPage;
			}
			
			
		}
	}
	@RequestMapping(value = command,method = RequestMethod.POST)
	public String doAction(@RequestParam(value = "password") String password,HttpSession session,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();
		if(session.getAttribute("loginInfo")==null) {
			session.setAttribute("destination", "redirect:/deleteMember.me");
			return gotoPage;	
		}else {
			Member member = (Member) session.getAttribute("loginInfo");
			if(member.getPassword().equals(password)) {
				int cnt = mdao.deleteMember(member.getId());
				if(cnt ==1) {
					session.invalidate();
					return gotoPage;
				}else {
					pw.print("<script type='text/javascript'>");
					pw.print("alert('삭제 실패.')");
					pw.print("</script>");
					pw.flush();
					return getPage;
				}
				
				
			}else {
				pw.print("<script type='text/javascript'>");
				pw.print("alert('잘못된 비밀번호입니다.')");
				pw.print("</script>");
				pw.flush();
				return getPage;
			}
		}
		
		
	}
}
