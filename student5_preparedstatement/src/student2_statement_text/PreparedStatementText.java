/*
 * 一种动态调用语句的方法，如果说Statement时静态的，那么PreparedStatement就是动态的方法
 */
package student2_statement_text;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import student2_statement_DButil.Dbutil;

public class PreparedStatementText {
	public static void main(String[] args) {
		/*
		 * 调用这两种方法可以查询
		 */
		//PreparedStatement();
		//PreparedStatement(2);
		/*
		 * 调用这三种方法可以增加
		 */
		//add();
		//add("kite",30);
		/*
		 * stu s=new stu();
		 * s.setName("kite");
		 * s.setAge(30);
		 * add(stu s);
		 */
		//调用这两种方法用来删除
		//del();
		//del(3);
		//调用这两种方法用来更新
		//update();
		//update("kite",2);
		//调用此方法进行查询
		//query()
		/*
		 * 其实所有方法都可以进行无参 有参 和使用对象中的方法，具体情况具体分析
		 */
	}
	
	 
	//一种无参构造形式，固定的获取
	static void PreparedStatement() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql="select id,name,age from stutb1 where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//传参的构造形式可以动态获取
	static void PreparedStatement(int id) {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql="select id,name,age from stutb1 where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static void query() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql="select id,name,age from stutb1 where age > ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 20);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				System.out.println(id+" "+name+" "+age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * 接下来是PreparedStatement在增删改查中的应用
	 */
	//在表中动态的增加数据
	static void add() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql=" insert into stutb1(name,age) values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "kite");
			pstmt.setInt(2, 30);
			pstmt.executeUpdate();
			//System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		
	}
	static void add(String name,int age) {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql=" insert into stutb1(name,age) values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.executeUpdate();
			//System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		
	}
	static void add(stu s) {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql=" insert into stutb1(name,age) values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getAge());
			pstmt.executeUpdate();
			//System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		
	}
	//接下来是在表动态的中删除数据
	static void del() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql=" delete from stutb1 where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.executeUpdate();
			//System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
		static void del(int s) {
			Dbutil util = new Dbutil();
			Connection conn = util.getConnection();
			String sql=" delete from stutb1 where id=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, s);
				pstmt.executeUpdate();
				//System.out.println(pstmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				util.closeConnection(conn);
			}
		}
		//接下来是在表中更新数据
		static void update() {
			Dbutil util = new Dbutil();
			Connection conn = util.getConnection();
			String sql=" update stutb1 set name=? where id=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "kite");
				pstmt.setInt(2, 2);
				pstmt.executeUpdate();
				//System.out.println(pstmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				util.closeConnection(conn);
			}
		}
		static void update(String name,int s) {
			Dbutil util = new Dbutil();
			Connection conn = util.getConnection();
			String sql=" update stutb1 set name=? where id=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, s);
				pstmt.executeUpdate();
				//System.out.println(pstmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				util.closeConnection(conn);
			}
		}
		
}
class stu{
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
	
