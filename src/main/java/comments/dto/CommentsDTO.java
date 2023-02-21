package comments.dto;

import java.sql.Date;

public class CommentsDTO {

	private int num, comRe_level;
	private String comContent, comIp, memberEmail;
	private Date comReg_date;
	
	public CommentsDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getComRe_level() {
		return comRe_level;
	}

	public void setComRe_level(int comRe_level) {
		this.comRe_level = comRe_level;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public String getComIp() {
		return comIp;
	}

	public void setComIp(String comIp) {
		this.comIp = comIp;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public Date getComReg_date() {
		return comReg_date;
	}

	public void setComReg_date(Date comReg_date) {
		this.comReg_date = comReg_date;
	}
	
	
}
