package admin.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import orders.model.Orders;

@Component
public class OProductDao {
	private String nameSpace = "admin.model.OProduct";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(OProduct oProduct) {
		int cnt = sqlSessionTemplate.insert(nameSpace+".Insert",oProduct);
		return cnt;
	}
	
	public List<OProduct> getOProductByOrderNum(int orderNum) {
		List<OProduct> list =  sqlSessionTemplate.selectList(nameSpace+".GetOProductByOrderNum",orderNum);
		return list;
	}


}
