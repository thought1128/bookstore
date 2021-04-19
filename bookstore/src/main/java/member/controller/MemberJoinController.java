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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;

@Controller
public class MemberJoinController {

	private final String command = "/join.me";
	private String getPage = "memberJoinForm";
	private String gotoPage = "myPage";
	private String gotoPage2 = "redirect:/orderMemberList.me";

	@Autowired
	MemberDao mdao;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		Member sessionMember = (Member) session.getAttribute("loginInfo");
		if (sessionMember == null) {
			return getPage;
		} else {
			if (sessionMember.getId().equals("admin")) {
				return gotoPage2;
			} else {
				return gotoPage;
			}
		}

	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@Valid Member member, BindingResult result, HttpServletResponse response,
			HttpSession session) throws IOException {
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		Member sessionMember = (Member) session.getAttribute("loginInfo");
		if (sessionMember != null) {
			if (sessionMember.getId().equals("admin")) {
				mav.setViewName(gotoPage2);
			} else {
				mav.setViewName(gotoPage);
			}

		} else {
			if (result.hasErrors()) {
				System.out.println(member.getAddress());
				System.out.println(member.getEmail());
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
					int idCheckCnt = mdao.chechId(member.getId());
					int emailCheckCnt = mdao.checkEmail(member.getEmail());
					if (idCheckCnt != 0) {
						pw.print("<script type='text/javascript'>");
						pw.print("alert('이미 가입된 아이디입니다.')");
						pw.print("</script>");
						pw.flush();
						mav.addObject("member", member);
						mav.setViewName(getPage);
					} else if (emailCheckCnt != 0) {
						pw.print("<script type='text/javascript'>");
						pw.print("alert('이미 가입된 이메일입니다.')");
						pw.print("</script>");
						pw.flush();
						mav.addObject("member", member);
						mav.setViewName(getPage);
					} else if(member.getAddress().split(",").length != 4){
						pw.print("<script type='text/javascript'>");
						pw.print("alert('주소를 입력해 주세요.')");
						pw.print("</script>");
						pw.flush();
						mav.addObject("member", member);
						mav.setViewName(getPage);
					}
					
					
					else {
						System.out.println("------------member-------");
						System.out.println(member.toString());
						int cnt = mdao.joinMember(member);
						if (cnt == 1) {

							session.setAttribute("destination", "redirect:/myPage.me");
							mav.setViewName("redirect:/login.me");

						} else {
							pw.print("<script type='text/javascript'>");
							pw.print("alert('회원가입 실패')");
							pw.print("</script>");
							pw.flush();
							mav.addObject("member", member);
							mav.setViewName(getPage);
						}
					}

				}

			}
		}

		return mav;
	}

}
