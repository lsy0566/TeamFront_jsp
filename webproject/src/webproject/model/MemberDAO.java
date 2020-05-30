package webproject.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import webproject.util.DBConnection;

/*DAO
 *테이블 당 한개의 DAO 작성
 *
 * JSP_MEMBER 테이블과 연관된 DAO로
 * 회원 데이터를 처리하는 클래스*/
public class MemberDAO {
	private static MemberDAO instance;
	
	//싱글톤 패턴
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if(instance==null)
			instance=new MemberDAO();
		return instance;
	}
	
	//String -> Date로 변경하는 메서드
	//문자열의 생년월일을 Date로 변경하기 위함
	// java.util.Date클래스로는 오라클의 Date형식과 연동할 수 없다.
    // Oracle의 date형식과 연동되는 java의 Date는 java.sql.Date 클래스이다.
	
	//파라미터로 member 객체의 생년월일을 가져오기 위함
	public Date stringToDate(MemberBean member) {
		String year = member.getBirthyy();
		String month = member.getBirthmm();
		String day = member.getBirthdd();
		
		Date birthday = Date.valueOf(year+"-"+month+"-"+day);
		
		return birthday;
	} // end stringToDate();
	
	// 회원정보를 JSP_MEMBER 테이블에 저장하는 메서드
	public void insertMember(MemberBean member) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 커넥션 가져옴
			conn = DBConnection.getConnection();
			
			// 자동 커밋을 false
			conn.setAutoCommit(false);
			
			// 쿼리 생성
			// 가입일의 자동 세팅을 위한 sysdate 사용
			StringBuffer sql = new StringBuffer();
			sql.append("insert into JSP_MEMBER values");
			sql.append("(?, ?, ?, ?, ?, ?, ?, ?, sysdate)"); 
			stringToDate(member);
			/*
			 * StringBuffer에 담긴 값을 얻기 위한 toString()메서드를 이용
			 */
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setDate(5, stringToDate(member));
			pstmt.setString(6, member.getMail1()+"@"+member.getMail2());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getAddress());
			
			//쿼리 실행
			pstmt.executeUpdate();
			
			//완료시 커밋
			conn.commit();
			
		} catch (ClassNotFoundException | NamingException | SQLException sqle) {
			conn.rollback();
			
			throw new RuntimeException(sqle.getMessage());
		} finally {
			// Connection, PreparedStatement를 닫음
			try {
				if (pstmt != null) {
					pstmt.close(); pstmt=null;
				}
				if (conn != null) {
					conn.close(); conn=null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		} // end try~catch
	} // end insertMember()
}
