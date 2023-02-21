package members.dto;

import common.exception.WrongEmailPasswordException;

public class MembersDTO {

	//이메일, 비밀번호, 이름, 전화번호
	private String memberEmail, memberPass, memberName, memberPhone;
	//회원구분 : 일반회원 1, 관리자 2
	private int memberType;
	
	//자동 로그인 체크
	private boolean rememberEmail;
	
	public MembersDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPass() {
		return memberPass;
	}

	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}

	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public int getMemberType() {
		return memberType;
	}

	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}

	public boolean isRememberEmail() {
		return rememberEmail;
	}

	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}
	
	public boolean matchPassword(String memberPass) {
		return this.memberPass.equals(memberPass);
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if(!this.memberPass.equals(oldPassword))
			throw new WrongEmailPasswordException();
		this.memberPass = newPassword;
	}
	
}//class MembersDTO
