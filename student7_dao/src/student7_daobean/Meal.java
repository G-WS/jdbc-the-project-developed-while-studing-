package student7_daobean;

public class Meal {
	private int id;
	
	private String createTime;
	
	private int UserID;
	
	private int MealTypeID;
	
	private int num;
	
	private String comment;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public int getUserID() {
		return UserID;
	}
	
	public void setUserID(int userID) {
		UserID = userID;
	}
	
	public int getMealTypeID() {
		return MealTypeID;
	}
	
	public void setMealTypeID(int mealTypeID) {
		MealTypeID = mealTypeID;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
