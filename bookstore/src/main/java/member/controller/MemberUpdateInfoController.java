package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;

@Controller
public class MemberUpdateInfoController {

	private final String command = "/updateMemberInfo.me";
	private String getPage = "memberUpdateInfoForm";
	private String gotoPage = "redirect:/myPage.me";

	@Autowired
	MemberDao mdao;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		Member member = (Member) session.getAttribute("loginInfo");
		if (member == null) {
			session.setAttribute("destination", "redirect:/updateMemberInfo.me");
			return "redirect:/login.me";
		} else {
				return getPage;
		}
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@Valid Member member, BindingResult result, HttpServletResponse response,
			HttpSession session) throws IOException {
		ModelAndView mav = new ModelAndView();
		Member originalInfo = (Member) session.getAttribute("loginInfo");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		if (session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/updateMemberInfo.me");
			mav.setViewName("redirect:/login.me");
		} else {
			if (result.hasErrors()) {
				mav.addObject("member", member);
				mav.setViewName(getPage);
			} else {
				if (!(member.getPassword().equals(member.getPasswordCheck()))) {
					pw.print("<script type='text/javascript'>");
					pw.print("alert('비밀번호 확인란이 잘못되었습니다.')");
					pw.print("</script>");
					pw.flush();
					
					mav.addObject("member", member);
					mav.setViewName(getPage);
				} else {
					int checkCnt;
					if(originalInfo.getEmail().equals(member.getEmail())) {
						checkCnt =0;
					}else {
						checkCnt = mdao.checkEmail(member.getEmail());
					}
					
					if (checkCnt == 0) {
						if(member.getAddress().split(",").length != 4){
							pw.print("<script type='text/javascript'>");
							pw.print("alert('주소를 입력해 주세요.')");
							pw.print("</script>");
							pw.flush();
							mav.addObject("member", member);
							mav.setViewName(getPage);
						}else {
							int cnt = mdao.updateMember(member);
							if (cnt == 1) {
								
								session.setAttribute("loginInfo", member);
								mav.setViewName(gotoPage);

							} else {
								pw.print("<script type='text/javascript'>");
								pw.print("alert('수정 실패.')");
								pw.print("</script>");
								pw.flush();
								mav.setViewName(getPage);
							}
						}
						
					} else {
						pw.print("<script type='text/javascript'>");
						pw.print("alert('이미 가입된 회원정보입니다.')");
						pw.print("</script>");
						pw.flush();
						mav.addObject("member", member);
						mav.setViewName(getPage);
					}
				}

			}
		}

		return mav;
	}

}
