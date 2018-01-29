package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.*;

public class ManagerDao {
	 //��ѯ���У��飩  
    @SuppressWarnings("finally")
	public ArrayList<Manager> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<Manager> list=new ArrayList<Manager>();  
        String sql="select * from Manager";  
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
            	Manager obj=new Manager();
                obj.setId(rs.getString(1));
                obj.setPassword(rs.getString(2));
                list.add(obj);  
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                BaseDao.close(rs, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return list;  
        }  
    }  
    
    
    //���뷽��
    public boolean save(Manager obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql = "insert into Manager values(?,?)";
    	
    	boolean flag = false;
    	try{
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		psta.setString(1, obj.getId());
    		psta.setString(2, obj.getPassword());
    		
    		flag = psta.executeUpdate()>0;
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}finally {
			try {
				BaseDao.close(null, psta, con);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return flag;
    }
    //ɾ������
    public boolean remove(String id){
    	Connection con = null;
    	PreparedStatement psta = null;
    	boolean flag = false;
    	String sql = "delete from Manager where id=?";
    	try{
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		psta.setString(1, id);
    		flag = psta.executeUpdate()>0;
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}finally {
			try {
				BaseDao.close(null, psta, con);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
    	return flag;
    }
    
    //ͨ��Id�޸�
    
    public Manager findById(String id){
    	Connection con = null;
    	PreparedStatement psta = null;
    	ResultSet rs = null;
    	Manager obj = null;
    	String sql = "select * from Manager where id=?";
    	try {
			con = BaseDao.getConnection();
			psta = con.prepareStatement(sql);
			psta.setString(1, id);
			rs = psta.executeQuery();
			if(rs.next()){
				obj = new Manager();
				  obj.setId(rs.getString(1));
	              obj.setPassword(rs.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				BaseDao.close(rs, psta, con);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
    	return obj;
    }
    
    //���·���
    public boolean update(Manager obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql="update Manager set password=? where id=?";
    	boolean flag = false;
    	try {
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		psta.setString(1, obj.getPassword());
    		psta.setString(2, obj.getId());
    		flag = psta.executeUpdate()>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				BaseDao.close(null, psta, con);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
    	return flag;
    }

}
