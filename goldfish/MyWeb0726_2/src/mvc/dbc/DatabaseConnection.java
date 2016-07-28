package mvc.dbc;
import java.sql.* ;
//ר�Ÿ������ݿ�Ĵ���رղ�������
public class DatabaseConnection {
	//private static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	private static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
 	private static final String DBURL = "jdbc:mysql://localhost:3306/test" ;
	private static final String DBUSER = "root" ;
	private static final String DBPASSWORD = "313233" ;
	private Connection conn = null ;
	public DatabaseConnection() throws Exception{//�ڹ��췽���н������ݿ�����  
		try{
			Class.forName(DBDRIVER) ;//����������  
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
		}catch(Exception e){//�׳��쳣  
			throw e ;
		}
	}
	public Connection getConnection(){//���ݿ�����  
		return this.conn ;
	}
	public void close() throws Exception{
		if(this.conn != null){
			try{
				this.conn.close() ;////���ݿ�ر� 
			}catch(Exception e){
				throw e ;
			}
		}
	}
}