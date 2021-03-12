/*
 *这是一个单元测试
 *在junit中选择case 放在text包中，然后选择setup和teardown
 *在next后勾选接口中的所有程序点击finish即可
 */

package text;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.Userdao;
import dao.impl.UserdaoImpl;
import student7_daobean.Userbean;

class UserdaoImplTest {

	Userdao dao;
	@BeforeEach//自动调用并运行
	protected void setUp() throws Exception {
		dao=new UserdaoImpl();
	}

	@AfterEach//运行结束执行
	protected void tearDown() throws Exception {
	}
	@Test
	public void testRegister() {
		Userbean u=new Userbean();
		u.setId(1);
		u.setName("tom");
		u.setPassword("213");
		dao.register(u);
	}
	@Test
	public void testCheck() {
		boolean b = dao.check("tom");
		System.out.println(b);
	}

	@Test
	public void testLogin() {
		Userbean u = dao.login("tom", "213");
		System.out.println(u.getName());
	}

	

	
}
