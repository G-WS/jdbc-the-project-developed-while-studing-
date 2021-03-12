package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.MealDao;
import student2_statement_DButil.Dbutil;
import student7_daobean.Meal;
import student7_daobean.Mealbean;

public class MealDaoImpl implements MealDao {

	@Override
	public void add(Meal m) {
		Dbutil util = new Dbutil();
		Connection conn=util.getConnection();
		String sql="insert into Mealtb1(id,createtime,userid,mealtypeid,num,comment)"+"values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, m.getId());
			pstmt.setString(2, m.getCreateTime());
			pstmt.setInt(3, m.getUserID());
			pstmt.setInt(4, m.getMealTypeID());
			pstmt.setInt(5, m.getNum());
			pstmt.setString(6, m.getComment());
			
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		
	}

	@Override
	public List list() {
		String sql = "use student_system;\r\n" + 
						"select * mt.id,\r\n" + 
						"mt.'createTime',\r\n" + 
						"u.'name',\r\n" + 
						"mtt.'name',\r\n" + 
						"mtt.price,\r\n" + 
						"mt.'num',\r\n" + 
						"mtt.price*mt.num as total,\r\n" + 
						"mt.'comment'\r\n" + 
						"from mealtb1 as mt\r\n" + 
						"left join usertb1 as u\r\n" + 
						"on mt.'UserID'=u.id\r\n" + 
						"left join Mealtypetb1 as mtt\r\n" + 
						"on mt.'MealTypeID'=mtt.id";//此语句用来将表之间进行关联
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			List list = new ArrayList();//将bean放在一个list中
			while(rs.next()) {
				int id=rs.getInt(1);
				String username=rs.getString(2);
				String name=rs.getString(3);
				int price=rs.getInt(4);
				int num=rs.getInt(5);
				int total = rs.getInt(6);
				String comment = rs.getString(7);
				
				Mealbean mb=new Mealbean();
				mb.setId(id);
				mb.setName(username);
				mb.setTypename(name);
				mb.setPrice(price);
				mb.setNum(num);
				mb.setComment(comment);
				mb.setTotal(total);
				
				list.add(mb);
				return list();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		return null;
	}

}
