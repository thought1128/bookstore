package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberDao;

@Controller
public class MemberFindPasswordController {

	private final String command = "/findPassword.me";
	private String getPage = "findPassword";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	@RequestMapping(value = command,method = RequestMethod.POST)
	public String doAction(@RequestParam(value = "id") String id,@RequestParam(value = "email") String email,HttpServletResponse response) throws IOException {


		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("email", email);
		
		String password = mdao.getPassword(map);
		

		if(password == null) {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('입력하신 아이디와 이메일에 해당하는 계정정보가 없습니다.')");
			pw.print("</script>");
			pw.flush();
			
			
		}else {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('찾으시는 비밀번호는 "+password+"입니다')");
			pw.print("</script>");
			pw.flush();
			
			
		}
		return getPage;
	}
}
