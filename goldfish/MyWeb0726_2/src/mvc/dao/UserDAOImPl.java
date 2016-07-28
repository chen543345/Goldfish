package mvc.dao;
//DAO�ӿڵ���ʵʵ���࣬��ɾ�������ݿ���������ǲ��������ݿ�Ĵ򿪺͹رգ�
//����ʵ����,�ڴ����н�ͨ�������û�ID�����������֤�� 
//�����֤�ɹ�����ͨ��VO���û�����ʵ����ȡ��������
// ������������Ҫ�Ǹ����������ݿ�������ڲ���ʱΪ�����ܼ���ȫ��ʹ��PreparedStatement�ӿ���ɡ�
import java.sql.*; 
import mvc.dao.IUserDAO; 
import mvc.vo.User;
public class UserDAOImPl implements IUserDAO {
	private Connection conn = null ;//���ݿ����Ӷ���  
	private PreparedStatement pstmt = null ;//���ݿ��������  
	public UserDAOImPl(Connection conn){//ͨ�����췽��ȡ�����ݿ�����  
		this.conn = conn ;
	}
	public boolean findLogin(User user) throws Exception{
		boolean flag = false ;//�����־λ  
		String sql = "SELECT name FROM user WHERE userid=? AND password=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;//ʵ����PrepareStatement���� 
		this.pstmt.setString(1,user.getUserid()) ;//����Userid
		this.pstmt.setString(2,user.getPassword()) ;//����password
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()){
			user.setName(rs.getString(1)) ;	// ȡ��һ���û�����ʵ����
			flag = true ;
		}
		this.pstmt.close() ;//�ر�PreparedStatement���� 
		return flag ;
	}
} 