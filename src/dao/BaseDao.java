package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	public static Connection getConnection() throws Exception{
		// ���MySQL������ʵ��
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      // ������Ӷ���(�ṩ����ַ���û���������)
	  //    Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/lsy","root", "");
	      Connection con =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lsy?"+"useUnicode=true&characterEncoding=UTF-8","root", "");
	      if (!con.isClosed())
	        System.out.println("Successfully connected ");
	      else
	        System.out.println("failed connected");
	      return con;
	}
	public static void close(ResultSet rs,Statement sta,Connection con)throws Exception{
		if(rs!=null){
                 //�رս����
                rs.close();
		}
		if(sta!=null){
                 //�رղ������
                 sta.close();
		}
		if(con!=null){
                //�ر�����
                con.close();
		}
	}
}
