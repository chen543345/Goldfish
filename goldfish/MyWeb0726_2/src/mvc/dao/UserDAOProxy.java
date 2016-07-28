package mvc.dao;
//代理实现类，主要完成数据库的打开和关闭，并且调用真实实现类对象的操作
import mvc.dao.*; 
import mvc.dbc.*; 
import mvc.vo.*;
import java.sql.* ;
public class UserDAOProxy implements IUserDAO {
	private DatabaseConnection dbc = null ;//定义数据库连接类  
	private IUserDAO dao = null ;
	public UserDAOProxy(){//在构造方法中实例化连接，同时实例化dao对象  
		try{
			this.dbc = new DatabaseConnection() ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		this.dao = new UserDAOImPl(dbc.getConnection()) ;
	}
	public boolean findLogin(User user) throws Exception{
		boolean flag = false ;//定义标志位  
		try{
			flag = this.dao.findLogin(user) ;	// 调用真实主题，完成操作
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return flag ;
	}
} 