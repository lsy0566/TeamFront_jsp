package webproject.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// Ŀ�ؼ��� ������ Ŭ���� - JNDI
public class DBConnection {
	public static Connection getConnection() throws SQLException, NamingException, 
	ClassNotFoundException{
		Context initCtx = new InitialContext();
		
		//initCtx�� lookup�޼��带 �̿��� "java:comp/env" �� �ش��ϴ� ��ü�� ã�� evnCtx�� ����
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		
		//envCtx�� lookup�޼��带 �̿��� "jdbc/orcl"�� �ش��ϴ� ��ü�� ã�� ds�� ����
		DataSource ds = (DataSource) envCtx.lookup("jdbc/orcl");
		
		//getConnection�޼��带 �̿��� Ŀ�ؼ� Ǯ�� ���� ��ü�� ��� conn�� ����
		Connection conn = ds.getConnection();
		return conn;
	}
}
