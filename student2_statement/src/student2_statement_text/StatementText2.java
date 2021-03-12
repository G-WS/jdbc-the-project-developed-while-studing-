/*Statement简介
 * Statement提供了一个操作数据库的SQL语句的功能，可通过它来创建表，插入记录，修改记录，删除记录等操作
 * Statement是语句的意思，是负责用于执行SQL语句的一个接口
 * 它有两个子接口是CallableStatement和PreparedStatement
 * 更新手段有insert,update,delete
 * 查询手段有select
 * createStatement()方法是Connection类中用于创建一个Statement对象来将SQL语句发送到数据库
 * 常用有四个方法
 * execute(String SQL)执行给定的SQL语句，该语句可能返回多个结果
 * executeQuery(String SQL)执行给定的SQL语句，该语句返回单个的ResultSet对象
 * executeUpdate(String SQL)执行给定的SQL语句，该语句可能是INSERT,DELETE,UPDATE语句，或者不返回任何内容的SQL语句（如SQL,DDL语句）
 *close()立即释放此statement对象的数据库和JDBC资源，而不是等待该对象自动关闭时发生此操作
 */

package student2_statement_text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import student2_statement_DButil.Dbutil;

public class StatementText2 {
	public static void main(String[] args) {
		getStatement();//此语句用来测试Statement
		//createTable();//调用此方法在数据库中创建表格
		//add();//调用此方法在表格中增添数据
		//del();//调用此方法在表格中删除数据
		//update();//调用此方法在表格中修改数据
		//query();//调用此方法查询表格
	}
	//此方法用于像表格中添加数据
	static void add() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="insert into stuTb1(id,name,age) values(1,'tom',18)";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
	//此方法用于在表格中删除数据
	static void del() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="delete from stutb1 where id=1";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
	//此方法用于在表格中修改数据
	static void update() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="update stutb1 set name='bigtom' where id=1";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
	//此方法用于查询表格中的数据
	static void query() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="select id,name,age from stutb1";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("id");//也可以使用列索引如第87行
				String name=rs.getString(2);
				int age=rs.getInt("age");
				System.out.println(id+" "+name+" "+age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
	//此方法用于在数据库中创建表格
	static void createTable() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="create table stuTb1(id int,name varchar(15),age int)";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}

	//该方法是用于创建statement的连接
	static void getStatement() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			System.out.println(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
