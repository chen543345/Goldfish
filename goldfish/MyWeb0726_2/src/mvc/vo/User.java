package mvc.vo;
//主要由属性、set、get方法组成，VO类中的属性与表中的字段相对应，每一个VO类的对象都表示表中的每一条记录；

public class User {
	private String userid ;
	private String name ;
	private String password ;

	public void setUserid(String userid){
		this.userid = userid ;
	}
	public void setName(String name){
		this.name = name ;
	}
	public void setPassword(String password){
		this.password = password ;
	}
	public String getUserid(){
		return this.userid ;
	}
	public String getName(){
		return this.name ;
	}
	public String getPassword(){
		return this.password ;
	}
}