package comments.dao;

import java.util.List;

import board.dto.PageDTO;
import comments.dto.CommentsDTO;

public interface CommentsDAO {

	public int count(int num);
	public List<CommentsDTO> list(int num);
	public void save(CommentsDTO dto);
}
