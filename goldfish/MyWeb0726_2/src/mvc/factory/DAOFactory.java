package mvc.factory;
//�����࣬ͨ��������ȡ��һ��DAO��ʵ��������
import mvc.dao.*; 
public class DAOFactory {
	public static IUserDAO getIUserDAOInstance(){
		return new UserDAOProxy() ;
	}
}