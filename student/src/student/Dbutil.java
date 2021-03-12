package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Dbutil {
	/*
	 * 用于测试数据库是否连接成功
	 */
	public static void main(String[] args) {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		System.out.println(conn);
		//util.add();
	}//此方法用于向数据库中添加信息
	public void add() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		
		String sql="INSERT INTO s_manager(s_name,s_sex,s_age,s_subject) VALUES('mike','男',18,'英语')";
		try {
			conn.setAutoCommit(false);//此语句代表非自动添加数据，如需添加数据，需要采用第二十六行的数据
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			conn.commit();//本行是添加数据的命令，如果去掉本行和23行，则可以直接添加信息
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();/*此语句表示如果存储失败，则返回存储之前的形式，例如银行转账失败，防止一方 的钱被扣除而另一方没有变化
				 				*此时sql语句这样写sql1="insert into account set balance=balance-1000 where name='tom'"
				 				*sql2="insert into account set balance=balance+1000 where name='kite'"
				 				*/
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			util.closeConnection(conn);
		}
	}
	/*该类用于获得数据库连接
	 * 而且此连接方法只能用于连接MySQL数据库
	 */
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//加载驱动，这里加载的是MySQL的驱动程序
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/student_system?serverTimezone=UTC","root","Zhy06150412252814732");
			//由于时区不同，所以这里必须在数据库名称后加上"?serverTimezone=UTC",这里写的是连接数据库的端口号和数据库名称，还有用户名和密码
			
		}catch(Exception e) {
			e.getStackTrace();
	
		}
		//这里是两个异常合在一起后的结果
		return null;
		
	}
	//此方法可以用来连接各种数据库
	/*public Connection getConnection(String url,String driver,String username,String password) {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}*/
	//此方法虽然好，但是需要集合框架来保证（集合框架暂时未学）
	/*public Connection openConnection() {
		properties prop=new properties();
	}*/
	//该类用于关闭数据库连接 
	 
	public void closeConnection(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
