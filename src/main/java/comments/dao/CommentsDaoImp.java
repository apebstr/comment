package comments.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.dto.PageDTO;
import comments.dto.CommentsDTO;

public class CommentsDaoImp implements CommentsDAO {
	
	private SqlSession sqlSession;
	
	public CommentsDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int count(int num) {
		return sqlSession.selectOne("comment.cCount");
	}

	@Override
	public List<CommentsDTO> list(int num) {
		return sqlSession.selectList("comment.cList");
	}

	@Override
	public void save(CommentsDTO dto) {
		sqlSession.insert("comment.cSave", dto);
		
	}

}
