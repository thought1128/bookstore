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
public class MemberFindIdController {
	
	private final String command = "/findId.me";
	private String getPage = "findId";
	//private String gotoPage = "redirect:/login.me";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	@RequestMapping(value = command,method = RequestMethod.POST)
	public String doAction(@RequestParam(value = "name") String name,@RequestParam(value = "email") String email,HttpServletResponse response) throws IOException {


		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("email", email);
		
		String id = mdao.getId(map);
		

		if(id == null) {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('해당정보로 가입된 아이디가 없습니다.')");
			pw.print("</script>");
			pw.flush();
			
			
		}else {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('찾으시는 아이디는"+id+"입니다.')");
			pw.print("</script>");
			pw.flush();
			
			
		}
		return getPage;
	}

}
