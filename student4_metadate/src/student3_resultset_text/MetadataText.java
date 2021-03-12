/*
 * JDBC--MetaData(元数据)
 * 分为结果集MetaData和数据库MetaData
 */

package student3_resultset_text;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import student3_resultset_DButil.Dbutil;

public class MetadataText {
	public static void main(String[] args) {
		textDatabaseMetaData();
		textResultSetMetaData();
	}
	//此方法通过DatabaseMetaData获取数据库的版本和数据库的名称
	static void textDatabaseMetaData() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		try {
			DatabaseMetaData metadata = conn.getMetaData();
			System.out.println("version"+": "+metadata.getDatabaseMajorVersion());//此方法用来获取数据库的主版本号
			System.out.println("name"+": "+metadata.getDatabaseProductName());//此方法用于获得数据库的名称
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//此方法通过ResultSetMetaData获取数据库中的列的名称
	static void textResultSetMetaData() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql = "select id,name,age from stutb1";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int count = md.getColumnCount();//此方法获取表中的列数
			//此循环可以获得并输出表格中的列名称
			for(int i=1;i<=count;i++) {
				String name = md.getColumnName(i);//此方法用于获得表格中的列名
				System.out.println(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
