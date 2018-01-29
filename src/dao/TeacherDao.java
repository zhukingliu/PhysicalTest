package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.*;

public class TeacherDao {
	 //��ѯ���У��飩  
    @SuppressWarnings("finally")
	public ArrayList<Teacher> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<Teacher> list=new ArrayList<Teacher>();  
        String sql="select * from Teacher";  
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
            	Teacher obj=new Teacher();
                obj.setID(rs.getString(1));
                obj.setName(rs.getString(2));
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
    public boolean save(Teacher obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql = "insert into Teacher values(?,?,?,?,?)";
    	boolean flag = false;
    	try{
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		psta.setString(1, obj.getID());
    		psta.setString(2, obj.getName());
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
    	String sql = "delete from Teacher where teacherID=?";
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
    
    public Teacher findById(String id){
    	Connection con = null;
    	PreparedStatement psta = null;
    	ResultSet rs = null;
    	Teacher obj = null;
    	String sql = "select * from Teacher where teacherID=?";
    	try {
			con = BaseDao.getConnection();
			psta = con.prepareStatement(sql);
			psta.setString(1, id);
			rs = psta.executeQuery();
			if(rs.next()){
				obj = new Teacher();
				  obj.setID(rs.getString(1));
	              obj.setName(rs.getString(2));
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
    
    
    public Teacher findByName(String name){
    	Connection con = null;
    	PreparedStatement psta = null;
    	ResultSet rs = null;
    	Teacher obj = null;
    	String sql = "select * from Teacher where teacherName=?";
    	try {
			con = BaseDao.getConnection();
			psta = con.prepareStatement(sql);
			psta.setString(1, name);
			rs = psta.executeQuery();
			if(rs.next()){
				obj = new Teacher();
				  obj.setID(rs.getString(1));
	              obj.setName(rs.getString(2));
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
    public boolean update(Teacher obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql="update Teacher set teacherName=?,college=?,jobTitle=? where teacherID=?";
    	boolean flag = false;
    	try {
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		psta.setString(1, obj.getName());
    		psta.setString(2, obj.getCollege());
    		psta.setString(3, obj.getJobTitle());
    		psta.setString(4, obj.getID());
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

    
    public boolean updatePassword(Teacher obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql="update Teacher set password=? where teacherID=?";
    	boolean flag = false;
    	try {
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		psta.setString(1, obj.getPassword());
    		psta.setString(2, obj.getID());
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
