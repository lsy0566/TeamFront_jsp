package webproject.model;

import java.sql.Timestamp;

// set하는 이유는 진짜 객체는 여기에 저장하고 저장된 값을 불러서 쓰거나 
// 값을 사용했으면 바로 초기화 시키거나 하는 수단
// 데이터를 옮기려 하는 것은 DAO가 담당하고 여기에 저장 되어 있는 값을 전달 or 사용
// 하기 위해 DAO란 객체가 있음
public class MemberBean {
	private String id;            // 아이디
    private String password;     // 비밀번호
    private String name;        // 이름
    private String gender;        // 성별
    private String birthyy;        // 생일 - 년
    private String birthmm;        // 생일 - 월
    private String birthdd;        // 생일 - 일
    private String mail1;        // 이메일 - @ 앞부분
    private String mail2;        // 이메일 - @ 뒷부분
    private String phone;        // 전화
    private String address;        // 주소
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthyy() {
		return birthyy;
	}
	public void setBirthyy(String birthyy) {
		this.birthyy = birthyy;
	}
	public String getBirthmm() {
		return birthmm;
	}
	public void setBirthmm(String birthmm) {
		this.birthmm = birthmm;
	}
	public String getBirthdd() {
		return birthdd;
	}
	public void setBirthdd(String birthdd) {
		this.birthdd = birthdd;
	}
	public String getMail1() {
		return mail1;
	}
	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}
	public String getMail2() {
		return mail2;
	}
	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	private Timestamp reg;        // 가입일

}
