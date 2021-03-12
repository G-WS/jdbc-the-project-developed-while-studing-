package student2_statement_text;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import student2_statement_DButil.Dbutil;

public class CallableStatementText {
	public static void main(String[] args) {
		//textCallableStatement1();
		//textCallableStatement2();
		textCallableStatement3();
	}
	//此方法通过调用存储过程查询
	static void textCallableStatement1() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql = "{call all_stu()}";//同样是查询，这种方法调用的是存储过程
		try {
			CallableStatement cstmt = conn.prepareCall(sql);
			ResultSet rs = cstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age=rs.getInt(3);
				System.out.println(id+" "+name+" "+age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//此方法用于通过存储过程添加
	static void textCallableStatement2() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql = "{call insert_stu(?,?)}";//同样是查询，这种方法调用的是存储过程
		
			try {
				CallableStatement cstmt = conn.prepareCall(sql);
				cstmt.setString(1, "zs");
				cstmt.setInt(2, 18);
				cstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	static void textCallableStatement3() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql = "{call getAgeByName(?,?)}";//同样是查询，这种方法调用的是存储过程
		
			try {
				CallableStatement cstmt = conn.prepareCall(sql);
				cstmt.setString(1, "zs");
				cstmt.registerOutParameter(2, Types.INTEGER);
				cstmt.executeUpdate();
				int age=cstmt.getInt(2);
				System.out.println(age);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
