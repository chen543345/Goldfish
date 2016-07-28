package mvc.dbc;
import java.sql.* ;
//专门负责数据库的打开与关闭操作的类
public class DatabaseConnection {
	//private static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	private static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
 	private static final String DBURL = "jdbc:mysql://localhost:3306/test" ;
	private static final String DBUSER = "root" ;
	private static final String DBPASSWORD = "313233" ;
	private Connection conn = null ;
	public DatabaseConnection() throws Exception{//在构造方法中进行数据库连接  
		try{
			Class.forName(DBDRIVER) ;//加载驱动类  
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
		}catch(Exception e){//抛出异常  
			throw e ;
		}
	}
	public Connection getConnection(){//数据库连接  
		return this.conn ;
	}
	public void close() throws Exception{
		if(this.conn != null){
			try{
				this.conn.close() ;////数据库关闭 
			}catch(Exception e){
				throw e ;
			}
		}
	}
}