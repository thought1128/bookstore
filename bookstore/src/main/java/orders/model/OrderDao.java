package orders.model;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myOrderDao")
public class OrderDao {
	private String nameSpace = "orders.model.Orders";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<Orders> getOrderDetail(int memberNum) {
		List<Orders> list =sqlSessionTemplate.selectList(nameSpace+".OrderDetail", memberNum);
		return list;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(nameSpace+".GetTotalCount", map);
		return cnt;
	}

	public List<Orders> getOrderMemberList(Paging pageInfo, Map<String, String> map) {
		System.out.println("333333333333");
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<Orders> lists = sqlSessionTemplate.selectList(nameSpace+".GetOrderMemberList",map,rowBounds);
		System.out.println("444444444444444");
		return lists;
	}

	public int insert(Orders orders) {
		int orderNum = sqlSessionTemplate.insert(nameSpace+".Insert",orders);
		return orderNum;
	}

	public List<Orders> getOrderByMember(int memberNum) {
		System.out.println("memberNum" + memberNum);
		List<Orders> list = sqlSessionTemplate.selectList(nameSpace+".GetOrderByMember",memberNum);
		return list;
	}

	public int getOnDeliveryCount(int memberNum) {
		int onDeliveryCount = sqlSessionTemplate.selectOne(nameSpace+".GetOnDeliveryCount", memberNum);
		return onDeliveryCount;
	}

	public int getBeforeDeliveryCount(int memberNum) {
		int beforeDeliveryCount = sqlSessionTemplate.selectOne(nameSpace+".GetBeforeDeliveryCount", memberNum);
		return beforeDeliveryCount;
	}

	public int getAfterDeliveryCount(int memberNum) {
		int afterDeliveryCount = sqlSessionTemplate.selectOne(nameSpace+".GetAfterDeliveryCount", memberNum);
		return afterDeliveryCount;
	}

	public int getCancelDeliveryCount(int memberNum) {
		int cancelDeliveryCount = sqlSessionTemplate.selectOne(nameSpace+".GetCancelDeliveryCount", memberNum);
		return cancelDeliveryCount;
	}

	public List<Orders> getCancelListByMemberNum(int memberNum) {
		List<Orders> list = sqlSessionTemplate.selectList(nameSpace+".GetCancelListByMemberNum",memberNum);
		return list;
	}

	public int cancelOrder(Map<String, String> map) {
		int cnt = sqlSessionTemplate.update(nameSpace+".CancelOrder", map);
		return cnt;
	}

	public int updateStatus(Map<String, String> map) {
		int cnt = sqlSessionTemplate.update(nameSpace+".UpdateStatus", map);
		return cnt;
	}

	public int insertTrackNum(Map<String, String> map) {
		int cnt = sqlSessionTemplate.update(nameSpace+".InsertTrackNum", map);
		return cnt;
	}
	
}
