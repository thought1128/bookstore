package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;


@Component("myBoardDao")
public class BoardDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<Board> getList() {
		List<Board> boardList = sqlSessionTemplate.selectList("board.model.Board.getList");
		return boardList;
	}

	public int insert(Board board) {
		int cnt = sqlSessionTemplate.insert("board.model.Board.insert", board);
		return cnt;
	}

	public Board getOne(int boardNum) {
		Board board = sqlSessionTemplate.selectOne("board.model.Board.getOne", boardNum);
		return board;
	}

	public int update(Board board) {
		int cnt = sqlSessionTemplate.update("board.model.Board.update", board);
		return cnt;
	}

	public int remove(int boardNum) {
		int cnt = sqlSessionTemplate.delete("board.model.Board.delete", boardNum);
		return cnt;
	}

	public void changeSteps(Board board) {
		sqlSessionTemplate.update("board.model.Board.changeSteps", board);
		
	}

	public int insertReply(Board board) {
		int cnt = sqlSessionTemplate.insert("board.model.Board.insertReply", board);
		return cnt;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne("board.model.Board.getTotalCount", map);
		return cnt;
	}

	public List<Board> getDataList(Paging pageInfo, Map<String, String> map) {
		List<Board> lists = new ArrayList<Board>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList("board.model.Board.getDataList",map,rowBounds);
		return lists;
	}

	public void hitBoard(int boardNum) {
		sqlSessionTemplate.update("board.model.Board.hitBoard", boardNum);
		
	}

}
