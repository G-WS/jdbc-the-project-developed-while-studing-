package student7_daobean;

public class Mealbean {
	/*use student_system;
	select * mt.id,
	mt.'createTime',
	u.'s_name',
	mtt.'name',
	mtt.price,
	mt.'num',
	mtt.price*mt.num as total,
	mt.'comment'
	from mealtb1 as mt
	left join s_manager as u
	on mt.'UserID'=u.id
	left join Mealtypetb1 as mtt
	on mt.'MealTypeID'=mtt.id
	*/

	private int id;
	
	private String createTime;
	
	private String name;
	
	private String typename;
	
	private int price;
	
	private int num;
	
	private int total;
	
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

 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
