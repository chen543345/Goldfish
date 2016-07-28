package mvc.dao;
//DAO接口的真实实现类，完成具体的数据库操作，但是不负责数据库的打开和关闭；
//定义实现类,在此类中将通过输入用户ID和密码进行验证， 
//如果验证成功，则通过VO将用户的真实姓名取出并返回
// 真题主题类主要是负责具体的数据库操作，在操作时为了性能及安全将使用PreparedStatement接口完成。
import java.sql.*; 
import mvc.dao.IUserDAO; 
import mvc.vo.User;
public class UserDAOImPl implements IUserDAO {
	private Connection conn = null ;//数据库连接对象  
	private PreparedStatement pstmt = null ;//数据库操作对象  
	public UserDAOImPl(Connection conn){//通过构造方法取得数据库连接  
		this.conn = conn ;
	}
	public boolean findLogin(User user) throws Exception{
		boolean flag = false ;//定义标志位  
		String sql = "SELECT name FROM user WHERE userid=? AND password=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;//实例化PrepareStatement对象 
		this.pstmt.setString(1,user.getUserid()) ;//设置Userid
		this.pstmt.setString(2,user.getPassword()) ;//设置password
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()){
			user.setName(rs.getString(1)) ;	// 取出一个用户的真实姓名
			flag = true ;
		}
		this.pstmt.close() ;//关闭PreparedStatement操作 
		return flag ;
	}
} 