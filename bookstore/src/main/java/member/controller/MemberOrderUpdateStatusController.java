package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import admin.model.OProduct;
import admin.model.OProductDao;
import admin.model.Product;
import admin.model.ProductDao;
import orders.model.OrderDao;

@Controller
public class MemberOrderUpdateStatusController {
	private final String command = "/updateStatus.me";
	private  String getPage = "orderStatusUpdate";
	private  String gotoPage = "redirect:/adminMain.prd";
	
	@Autowired
	OrderDao odao;
	
	@Autowired
	OProductDao opdao;
	
	@Autowired
	ProductDao pdao;
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public String doAction(@RequestParam(value = "orderNum") int orderNum,Model model) {
		model.addAttribute("orderNum", orderNum);
		return getPage;
	}
	@RequestMapping(value = command,method = RequestMethod.POST)
	public String doAction(@RequestParam(value = "orderNum") int orderNum,@RequestParam(value = "status") String status,@RequestParam(value = "reason") String reason,Model model,HttpServletResponse response) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("orderNum",String.valueOf(orderNum));
		map.put("reason",reason);
		map.put("status",status);
		
		int cnt = odao.updateStatus(map);
		if(cnt==1) {
			if(status.equals("고객 주문취소")||status.equals("관리자 주문취소")||status.equals("환불완료")||status.equals("교환완료")) {
				List<OProduct> list =  opdao.getOProductByOrderNum(orderNum);
				for(int i=0;i<list.size();i++) {
					OProduct oproduct = list.get(i);
					System.out.println(oproduct.getOqty());
					pdao.updateQty(oproduct);
				}
			}
			return gotoPage;
		}else {
			PrintWriter pw = response.getWriter();

			model.addAttribute("orderNum", orderNum);
			pw.print("<script type='text/javascript'>");
			pw.print("alert('상태 수정 실패.')");
			pw.print("</script>");
			pw.flush();
			return getPage;
		}
		
		
	}
}
