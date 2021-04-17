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
public class CartRemoveController {
	private final String command = "/remove.mall";
	private final String gotoPage = "redirect:/list.mall"; 
	
	@RequestMapping(value=command)
	public String doAction(String isbn, HttpSession session, RedirectAttributes attributes) {

		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		System.out.println("mycart:" + mycart);
		mycart.removeOrder(isbn);
		session.setAttribute("mycart", mycart);
		System.out.println("카트에서 제거하였음.");
		return gotoPage;
		
	}
}





