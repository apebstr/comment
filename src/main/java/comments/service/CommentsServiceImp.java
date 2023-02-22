package comments.service;

import java.util.List;

import comments.dao.CommentsDAO;
import comments.dto.CommentsDTO;

public class CommentsServiceImp implements CommentsService{

	private CommentsDAO commentsDao;
	
	public CommentsServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setCommentsDao(CommentsDAO commentsDao) {
		this.commentsDao = commentsDao;
	}

	@Override
	public int countProcess(int num) {
		return commentsDao.count(num);
	}

	@Override
	public List<CommentsDTO> listProcess(int num) {
		return commentsDao.list(num);
	}

	@Override
	public void saveProcess(CommentsDTO dto) {
		// TODO Auto-generated method stub
		
	}
}
