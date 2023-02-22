package comments.service;

import java.util.List;

import comments.dto.CommentsDTO;

public interface CommentsService {

	public int countProcess(int num); 
	public List<CommentsDTO> listProcess(int num);
	public void saveProcess(CommentsDTO dto);
}
