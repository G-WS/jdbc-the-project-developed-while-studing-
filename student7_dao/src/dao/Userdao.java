package dao;

import student7_daobean.Userbean;

public interface Userdao {
	//login
	public Userbean login(String username,String password);
	//register
	public void register(Userbean u);
	//check
	public boolean check(String username);
	

}
