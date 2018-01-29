package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.*;

public class StudentDao {
	 //��ѯ���У��飩  
    @SuppressWarnings("finally")
	public ArrayList<Student> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<Student> list=new ArrayList<Student>();  
        String sql="select * from Student";  
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
            	Student obj=new Student();
                obj.setStudentID(rs.getString(1));
                obj.setName(rs.getString(2));
                obj.setBirthday(rs.getDate(3));
                obj.setSex(rs.getInt(4));
                obj.setProject(rs.getString(5));
                obj.setCollege(rs.getString(6));
                obj.setTeacherID(rs.getString(7));
                obj.setLeaderID(rs.getString(8));
                obj.setPassword(rs.getString(9));
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
    public boolean save(Student obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql = "insert into Student values(?,?,?,?,?,?,?,?,?)";
    	
    	boolean flag = false;
    	try{
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		psta.setString(1, obj.getStudentID());
    		psta.setString(2, obj.getName());
    		psta.setDate(3, (Date)obj.getBirthday());
    		psta.setInt(4, obj.getSex());
    		psta.setString(5, obj.getProject());
    		psta.setString(6, obj.getCollege());
    		psta.setString(7, obj.getTeacherID());
    		psta.setString(8, obj.getLeaderID());
    		psta.setString(9, "123456");
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
    	String sql = "delete from Student where studentID=?";
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
    
    public Student findById(String id){
    	Connection con = null;
    	PreparedStatement psta = null;
    	ResultSet rs = null;
    	Student obj = null;
    	String sql = "select * from Student where studentID=?";
    	try {
			con = BaseDao.getConnection();
			psta = con.prepareStatement(sql);
			psta.setString(1, id);
			rs = psta.executeQuery();
			if(rs.next()){
				obj = new Student();
				obj.setStudentID(rs.getString(1));
                obj.setName(rs.getString(2));
                obj.setBirthday(rs.getDate(3));
                obj.setSex(rs.getInt(4));
                obj.setProject(rs.getString(5));
                obj.setCollege(rs.getString(6));
                obj.setTeacherID(rs.getString(7));
                obj.setLeaderID(rs.getString(8));
                obj.setPassword(rs.getString(9));
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
    public boolean update(Student obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql="update Student set studentName=?,Birthday=?,studentSex=?,studentProject=?,studentCollege=?,teacherID=?,leaderID=? where studentID=?";
    	boolean flag = false;
    	try {
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		psta.setString(1, obj.getName());
    		psta.setDate(2, (Date)obj.getBirthday());
    		psta.setInt(3, obj.getSex());
    		psta.setString(4, obj.getProject());
    		psta.setString(5, obj.getCollege());
    		psta.setString(6, obj.getTeacherID());
    		psta.setString(7, obj.getLeaderID());
    		psta.setString(8, obj.getStudentID());
    		
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
    
    public boolean updatePassword(Student obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql="update Student set password=? where studentID=?";
    	boolean flag = false;
    	try {
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		psta.setString(1, obj.getPassword());
    		psta.setString(2, obj.getStudentID());
    		
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
