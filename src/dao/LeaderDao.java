package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.*;

public class LeaderDao {
	 //��ѯ���У��飩  
    @SuppressWarnings("finally")
	public ArrayList<Leader> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<Leader> list=new ArrayList<Leader>();  
        String sql="select * from Leader";  
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
            	Leader obj=new Leader();
                obj.setLeaderID(rs.getString(1));
                obj.setLeaderName(rs.getString(2));
                obj.setCollege(rs.getString(3));
                obj.setJobTitle(rs.getString(4));
                obj.setPassword(rs.getString(5));
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
    public boolean save(Leader obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql = "insert into Leader values(?,?,?,?,?)";
    	
    	boolean flag = false;
    	try{
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		psta.setString(1, obj.getLeaderID());
    		psta.setString(2, obj.getLeaderName());
    		psta.setString(3, obj.getCollege());
    		psta.setString(4, obj.getJobTitle());
    		psta.setString(5, "123456");
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
    	String sql = "delete from Leader where lerderID=?";
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
    
    public Leader findById(String id){
    	Connection con = null;
    	PreparedStatement psta = null;
    	ResultSet rs = null;
    	Leader obj = null;
    	String sql = "select * from Leader where lerderID=?";
    	try {
			con = BaseDao.getConnection();
			psta = con.prepareStatement(sql);
			psta.setString(1, id);
			rs = psta.executeQuery();
			if(rs.next()){
				obj = new Leader();
				 obj.setLeaderID(rs.getString(1));
	             obj.setLeaderName(rs.getString(2));
	             obj.setCollege(rs.getString(3));
	             obj.setJobTitle(rs.getString(4));
	             obj.setPassword(rs.getString(5));
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
    
    
    public Leader findByName(String name){
    	Connection con = null;
    	PreparedStatement psta = null;
    	ResultSet rs = null;
    	Leader obj = null;
    	String sql = "select * from Leader where leadername=?";
    	try {
			con = BaseDao.getConnection();
			psta = con.prepareStatement(sql);
			psta.setString(1, name);
			rs = psta.executeQuery();
			if(rs.next()){
				obj = new Leader();
				 obj.setLeaderID(rs.getString(1));
	             obj.setLeaderName(rs.getString(2));
	             obj.setCollege(rs.getString(3));
	             obj.setJobTitle(rs.getString(4));
	             obj.setPassword(rs.getString(5));
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
    public boolean update(Leader obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql="update Leader set leadername=?,college=?,jobTitle=? where lerderID=?";
    	boolean flag = false;
    	try {
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);    		
    		psta.setString(1, obj.getLeaderName());
    		psta.setString(2, obj.getCollege());
    		psta.setString(3, obj.getJobTitle());
    		psta.setString(4, obj.getLeaderID());
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
    
    public boolean updatePassword(Leader obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql="update Leader set password=? where lerderID=?";
    	boolean flag = false;
    	try {
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);    		
    		psta.setString(1, obj.getPassword());
    		psta.setString(2, obj.getLeaderID());
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
