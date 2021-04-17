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
import admin.model.Product;
import admin.model.ProductDao;
import mall.cart.MyCartList;
import member.model.Member;

// =>
@Controller
public class CartListController {
	private final String command = "/list.mall";
	private final String getPage = "mallList";

	@Autowired
	private ProductDao productDao;

	@RequestMapping(command)
	public String doAction(HttpSession session, RedirectAttributes attributes) {
		if (session.getAttribute("loginInfo") == null) {
			System.out.println("로그인 이상");
			attributes.addFlashAttribute("msg", "로그인을하세요.");
			return "redirect:login.me";
		}
		MyCartList mycart = (MyCartList) session.getAttribute("mycart");
		if(mycart == null) {
			mycart = new MyCartList();
			session.getAttribute("shoplists");
		}
		
		Map<String, Integer> maplists = mycart.getAllOrderLists();

		Set<String> keylist = maplists.keySet();

		ArrayList<OProduct> shoplists = new ArrayList<OProduct>();

		int totalAmount = 0;
		int totalPoint = 0;

		for (String isbn : keylist) {
			Product product = productDao.getOne(isbn);

			int oqty = maplists.get(isbn);

			if (oqty > product.getQty()) {
				attributes.addFlashAttribute("msg", product.getTitle() + "의 재고는 " + product.getQty() + "입니다. 재고 이하로 구매하시기를 바랍니다.");
				mycart.removeOrder(isbn);
				session.setAttribute("mycart", mycart);
				return "redirect:/detail.pv?isbn=" + product.getIsbn();
			}

			OProduct oproduct = new OProduct(0, 0, product.getIsbn(), product.getTitle(), product.getWriter(),
					product.getPublisher(), product.getPrice(), product.getPoint(), oqty, product.getImage(),
					product.getClassify());

			totalAmount += oproduct.getPrice() * oqty;
			totalPoint += oproduct.getPoint() * oqty;

			shoplists.add(oproduct);
		}

		session.setAttribute("shoplists", shoplists);
		session.setAttribute("totalAmount", totalAmount);
		session.setAttribute("totalPoint", totalPoint);

		return getPage;
	}
}
