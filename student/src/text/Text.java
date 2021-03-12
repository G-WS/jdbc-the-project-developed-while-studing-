package text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import student.Dbutil;
/*这里又是一个测试类，用于测试输出的结果，在使用过程中一定要注意列名的对应
 * 
 */
public class Text {
	public static void main(String[] args) {
		Text text=new Text();
		text.list();
		
	}
public void list() {
	Dbutil util=new Dbutil();
	Connection conn=util.getConnection();
	String sql="select s_name,s_sex,s_age,s_subject from s_manager";
	try {
		Statement stmt=conn.createStatement();//一个连接着sql语句的入口
		ResultSet rs=stmt.executeQuery(sql);//有一个指针指向结果集，也就是已经把数据库的内容拿到了结果集里面
		/*rs.next()是用于判断是否还有下一条记录
		 * 循环用于读取表，
		 * 并且输出表
		 */
		while(rs.next()) {
			String name=rs.getString("s_name");
			String sex=rs.getString("s_sex");
			int age=rs.getInt("s_age");
			String subject=rs.getString("s_subject");
			System.out.println(name+" "+sex+" "+age+" "+subject);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		util.closeConnection(conn);
	}
}
}
