package member.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class MemberDao {
	private String nameSpace = "member.model.Member";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;



	public Member login(String id) {
		Member member = sqlSessionTemplate.selectOne(nameSpace+".Login", id);
		return member;
	}



	public int joinMember(Member member) {
		int cnt = sqlSessionTemplate.insert(nameSpace+".MemberJoin", member);
		return cnt;
	}



	public String getId(Map<String, String> map) {
		String id = sqlSessionTemplate.selectOne(nameSpace+".GetId",map);	
		return id;
	}



	public String getPassword(Map<String, String> map) {
		String password = sqlSessionTemplate.selectOne(nameSpace+".GetPassword", map);
		return password;
	}



	public int deleteMember(String id) {
		int cnt = sqlSessionTemplate.delete(nameSpace+".DeleteMember", id);
		return cnt;
	}



	public int updateMember(Member member) {
		int cnt = sqlSessionTemplate.update(nameSpace+".UpdateMember", member);
		return cnt;
	}



	public int chechId(String id) {
		int cnt = sqlSessionTemplate.selectOne(nameSpace+".CheckId", id);
		return cnt;
	}



	public List<Member> getMemberList(Paging pageInfo, Map<String, String> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<Member> lists = new ArrayList<Member>();
		lists = sqlSessionTemplate.selectList(nameSpace+".GetMemberList",map,rowBounds);
		return lists;
	}



	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(nameSpace+".GetTotalCount",map);
		return cnt;
	}



	public Member getMemberDetail(int memberNum) {
		Member member = (Member)sqlSessionTemplate.selectOne(nameSpace+".GetMemberDetail",memberNum);
		return member;
	}



	public int checkEmail(String email) {
		int cnt = sqlSessionTemplate.selectOne(nameSpace+".CheckEmail",email);
		return cnt;
	}
	
	

}
