package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mall.cart.MyCartList;
import member.model.Member;

@Controller
public class CartAddController {
	private final String command = "/add.mall";
	private final String gotoPage = "redirect:/list.mall"; 
	
	@RequestMapping(value=command)
	public String doAction(String isbn, int oqty, 
			@RequestParam(value="reCount",required = false) String reCount,
			HttpSession session, RedirectAttributes attributes) {
		System.out.println("-----checkBefore-----");
		System.out.println(reCount);
		
		if(session.getAttribute("loginInfo") == null) {
			System.out.println("로그인 이상");
			attributes.addFlashAttribute("msg", "로그인을하세요.");
			return "redirect:detail.pv?isbn="+isbn;
		}
		else {			
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			System.out.println("mycart:" + mycart);
			
			if(mycart == null) {
				mycart = new MyCartList();
				session.getAttribute("shoplists");
			}
			if(reCount.equals("y")){
				System.out.println("-----check-----");
				System.out.println(isbn+":"+oqty);
				mycart.removeOrder(isbn);
			}
				mycart.addOrder(isbn, oqty);
			
			session.setAttribute("mycart", mycart);
			System.out.println("카트에 넣었음");
			return gotoPage;
		}
	}
}





