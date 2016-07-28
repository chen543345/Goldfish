package mvc.factory;
//工厂类，通过工厂类取得一个DAO的实例化对象
import mvc.dao.*; 
public class DAOFactory {
	public static IUserDAO getIUserDAOInstance(){
		return new UserDAOProxy() ;
	}
}