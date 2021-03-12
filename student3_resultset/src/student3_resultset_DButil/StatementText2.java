package student3_resultset_DButil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import student3_resultset_text.Dbutil;


public class StatementText2 {
	public static void main(String[] args) {
		textResultset();
		List list=liststu();
		System.out.println(list);
		updatableResultset();
	}
	/*此方法用于查询当前结果集所在的行数以及是否在第一行
	 * 结果集是默认不可滚动不可更新的，而且是从第一行到最后一行的顺序
	 */
	static void textResultset() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="select id,name,age from stutb1";
			ResultSet rs=stmt.executeQuery(sql);
			//rs.absolute(3);//此语句的意思是绝对定位到第n行，当前语句就是绝对定位到第三行。
			//rs.next();//此方法可以改变当前结果集的行数，改变方法为往下移动一行 ，例如如果原来row=0，用一次之后，row就会变为1
			
			int row=rs.getRow();
			System.out.println(row);//此语句用来查询当前所在的结果集的行数
			
			boolean b=rs.isBeforeFirst();
			System.out.println(b);//此语句用来判断当前结果集所在的行数是否在第一行
			
			/*while(rs.next()) {
				int id=rs.getInt("id");//也可以使用列索引如第87行
				String name=rs.getString(2);
				int age=rs.getInt("age");
				System.out.println(id+" "+name+" "+age);
				}*///此语句是用来表现结果集
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
	/*当加了ResultSet.TYPE_SCROLL_INSENSITIVE和ResultSet.CONCUR_UPDATABLE这两个参数之后，将造就一个可滚动可更新的结果集
	*如果运行错误，那是因为在建表时没有设置主键。
	*/
	
	static void updatableResultset() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		String sql="select id,name,age from stutb1";
		Statement stmt;
		try {
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery(sql);
			//添加一行
			/*rs.moveToInsertRow();
			rs.updateString("name", "bigton");
			rs.updateInt(3, 21);
			rs.insertRow();
			*/
			//更新一行
			/*rs.absolute(2);
			rs.updateString("name", "tom");
			rs.updateRow();
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//此方法是将内容存放在一个数组对象中来输出，在网站中可以直接遍历。
	static List liststu() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="select id,name,age from stutb1";
			ResultSet rs=stmt.executeQuery(sql);
			List list=new ArrayList();
			while(rs.next()) {
				//getXXX(),XXX数据类型
				int id=rs.getInt("id");//也可以使用列索引如第87行
				String name=rs.getString(2);
				int age=rs.getInt("age");
				
				stu s=new stu();
				s.setAge(age);
				s.setId(id);
				s.setName(name);
				list.add(s);
				System.out.println(id+" "+name+" "+age);
			}//此语句是用来表现结果集
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		return null;
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