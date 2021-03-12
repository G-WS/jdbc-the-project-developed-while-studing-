/*
 * Dao介绍
 * -Dao设计模式
 * Dao的全称是：Data Access Object，数据访问对象。
 * 使用Dao设计模式，来封装数据库持久层的所有 操作（crud）
 * ，使低级的数据逻辑和高级的业务逻辑分离，达到耦合的目的
 * -一个典型的Dao实现有如下组件：
 * *一个Dao接口
 * *一个实现了Dao接口的具体类
 * *一个Dao工厂类
 * *数据传输对象（有时称为值对象）
 * -以维护一个客户的信息为例，具体组件如下所示：
 * CostomerDao接口
 * Customer值对象(VO)
 * CustomerDaoImp1(接口的具体实现类)
 * CustomerFactory（工厂类，实例化用）
 */
package dao;

import java.util.List;

import student7_daobean.Meal;

public interface MealDao {
	
	public void add(Meal m);
	
	public List list();
}
