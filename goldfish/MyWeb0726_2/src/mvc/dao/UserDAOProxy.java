package mvc.dao;
//����ʵ���࣬��Ҫ������ݿ�Ĵ򿪺͹رգ����ҵ�����ʵʵ�������Ĳ���
import mvc.dao.*; 
import mvc.dbc.*; 
import mvc.vo.*;
import java.sql.* ;
public class UserDAOProxy implements IUserDAO {
	private DatabaseConnection dbc = null ;//�������ݿ�������  
	private IUserDAO dao = null ;
	public UserDAOProxy(){//�ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����  
		try{
			this.dbc = new DatabaseConnection() ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		this.dao = new UserDAOImPl(dbc.getConnection()) ;
	}
	public boolean findLogin(User user) throws Exception{
		boolean flag = false ;//�����־λ  
		try{
			flag = this.dao.findLogin(user) ;	// ������ʵ���⣬��ɲ���
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return flag ;
	}
} 