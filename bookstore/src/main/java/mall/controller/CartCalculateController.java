package mall.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import admin.model.OProduct;
import admin.model.OProductDao;
import admin.model.ProductDao;
import mall.cart.MyCartList;
import member.model.Member;
import member.model.MemberDao;
import orders.model.OrderDao;
import orders.model.Orders;

@Controller
public class CartCalculateController {
	private final String command = "calculate.mall";
	private final String gotoPage = "redirect:/view.pv";
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OProductDao oproductDao;
		
	@RequestMapping(command)
	public String doAction(String address, int phoneNum, HttpSession session, RedirectAttributes attributes) {
		
		System.out.println("hello");
		
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		if(mycart==null) {
			attributes.addFlashAttribute("msg", "장바구니에 아무것도 없습니다.");
			return "redirect:/list.mall";

		}
		
		Member member = (Member)session.getAttribute("loginInfo");

		
		Map<String, Integer> maplists = mycart.getAllOrderLists();

		Set<String> keylist = maplists.keySet();
		System.out.println("keylist:"+keylist); // [2,5]
		
		int memberNum = member.getMemberNum();
		String name= member.getName();
		int totalPrice = (Integer) session.getAttribute("totalAmount");
		int totalPoint = totalPrice/10; // 아직 가정.

		
		Orders orders = new Orders(0, memberNum, name, address, phoneNum, "trackNum null", "배송전", totalPrice, totalPoint);
		
		int cnt = orderDao.insert(orders); 

		if(cnt >= 1) {
			ArrayList<OProduct> shoplists = (ArrayList<OProduct>) session.getAttribute("shoplists");
			for(int i=0; i<shoplists.size(); i++) {
				shoplists.get(i).setOrderNum(orders.getOrderNum());// 마이바티스에서 selectKey를 하면 해당 객체의 orderNum에 pk가 들어옴. 
				oproductDao.insert(shoplists.get(i));
				productDao.popStock(shoplists.get(i));
				
			}
			
		}
		
		session.removeAttribute("mycart");
		return "redirect:/myPage.me";
	}
}






















