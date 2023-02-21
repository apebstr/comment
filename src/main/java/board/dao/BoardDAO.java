package board.dao;

import board.dto.BoardDTO;
import board.dto.PageDTO;

import java.util.List;

public interface BoardDAO {

	public int count();
	public List<BoardDTO> list(PageDTO pv);
	public void readCount(int num);
	public BoardDTO content(int num);
	public void reStepCount(BoardDTO dto);
	public void save(BoardDTO dto);
	public void update(BoardDTO dto);
	public void delete(int num);
	public String getFile(int num);
	
}//interface BoardDAO
