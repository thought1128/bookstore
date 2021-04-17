package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin.model.OProduct;
import admin.model.OProductDao;

@Controller
public class MemberOProductDetailController {
	private final String command = "/memberOProductDetail.me";
	private String gotoPage = "memberOProductDetail";
	
	@Autowired
	OProductDao opdao;
	
	@RequestMapping(value = command)
	public String doAction(@RequestParam(value = "orderNum") int orderNum, Model model) {
		List<OProduct> list =  opdao.getOProductByOrderNum(orderNum);
		model.addAttribute("list", list);
		return gotoPage;
		
	}
}
