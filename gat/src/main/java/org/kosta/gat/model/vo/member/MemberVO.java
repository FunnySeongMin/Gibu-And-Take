package org.kosta.gat.model.vo.member;

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String address;
	private String birthday;
	private String email;
	private int mileage;
	private int totalUseMileage;
	private MemberGroupVO memberGroupVO;
	private MemberGradeVO memberGradeVO;
	
	public MemberVO() {
		super();
	}

	public MemberVO(String id, String name, String password, String address, String birthday, String email, int mileage,
			int totalUseMileage, MemberGroupVO memberGroupVO, MemberGradeVO memberGradeVO) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.birthday = birthday;
		this.email = email;
		this.mileage = mileage;
		this.totalUseMileage = totalUseMileage;
		this.memberGroupVO = memberGroupVO;
		this.memberGradeVO = memberGradeVO;
	}
	public MemberVO(String id, String password, String address,  String email) {
		super();
		this.id = id;
		this.password = password;
		this.address = address;
		this.email = email;

	}
	public MemberVO(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getTotalUseMileage() {
		return totalUseMileage;
	}

	public void setTotalUseMileage(int totalUseMileage) {
		this.totalUseMileage = totalUseMileage;
	}

	public MemberGroupVO getMemberGroupVO() {
		return memberGroupVO;
	}

	public void setMemberGroupVO(MemberGroupVO memberGroupVO) {
		this.memberGroupVO = memberGroupVO;
	}

	public MemberGradeVO getMemberGradeVO() {
		return memberGradeVO;
	}

	public void setMemberGradeVO(MemberGradeVO memberGradeVO) {
		this.memberGradeVO = memberGradeVO;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", birthday=" + birthday + ", email=" + email + ", mileage=" + mileage + ", totalUseMileage="
				+ totalUseMileage + ", memberGroupVO=" + memberGroupVO + ", memberGradeVO=" + memberGradeVO + "]";
	}
}
	
	
	