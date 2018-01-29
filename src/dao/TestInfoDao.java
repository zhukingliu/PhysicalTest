package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.*;

public class TestInfoDao {
	 //��ѯ���У��飩  
    @SuppressWarnings("finally")
	public ArrayList<TestInfo> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<TestInfo> list=new ArrayList<TestInfo>();  
        String sql="select * from TestInfo";  
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
            	TestInfo obj=new TestInfo();
            	    obj.setID(rs.getString(1));
	                obj.setStudentID(rs.getString(2));
	                obj.setTime(rs.getDate(3));
	                obj.setSuggestID(rs.getString(4));
	                obj.setVitalCapacity(rs.getDouble(5));
	                obj.setHeight(rs.getDouble(6));
	                obj.setWeight(rs.getDouble(7));
	                obj.setJump(rs.getDouble(8));
	                obj.setSitUp(rs.getInt(9));
	                obj.setPullUp(rs.getInt(10));
	                obj.setEightHundred(rs.getDouble(11));
	                obj.setOneThousand(rs.getDouble(12));
	                obj.setFifty(rs.getDouble(13));
	                obj.setSitAndReach(rs.getDouble(14));
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
    public boolean save(TestInfo obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql = "insert into TestInfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	boolean flag = false;
    	try{
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		
    		psta.setString(1, obj.getID());
    		psta.setString(2, obj.getStudentID());
    		psta.setDate(3, (Date)obj.getTime());
    		psta.setString(4, obj.getSuggestID());
    		psta.setDouble(5, obj.getVitalCapacity());
    		psta.setDouble(6, obj.getHeight());
    		psta.setDouble(7, obj.getWeight());
    		psta.setDouble(8, obj.getJump());
    		psta.setInt(9, obj.getSitUp());
    		psta.setInt(10, obj.getPullUp());
    		psta.setDouble(11, obj.getEightHundred());
    		psta.setDouble(12, obj.getOneThousand());
    		psta.setDouble(13, obj.getFifty());
    		psta.setDouble(14, obj.getSitAndReach());
    		
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
    	String sql = "delete from TestInfo where ID=?";
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
    
    public TestInfo findById(String id){
    	Connection con = null;
    	PreparedStatement psta = null;
    	ResultSet rs = null;
    	TestInfo obj = null;
    	String sql = "select * from TestInfo where ID=?";
    	try {
			con = BaseDao.getConnection();
			psta = con.prepareStatement(sql);
			psta.setString(1, id);
			rs = psta.executeQuery();
			if(rs.next()){
				obj = new TestInfo();
				    obj.setID(rs.getString(1));
	                obj.setStudentID(rs.getString(2));
	                obj.setTime(rs.getDate(3));
	                obj.setSuggestID(rs.getString(4));
	                obj.setVitalCapacity(rs.getDouble(5));
	                obj.setHeight(rs.getDouble(6));
	                obj.setWeight(rs.getDouble(7));
	                obj.setJump(rs.getDouble(8));
	                obj.setSitUp(rs.getInt(9));
	                obj.setPullUp(rs.getInt(10));
	                obj.setEightHundred(rs.getDouble(11));
	                obj.setOneThousand(rs.getDouble(12));
	                obj.setFifty(rs.getDouble(13));
	                obj.setSitAndReach(rs.getDouble(14));
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
    public boolean update(TestInfo obj){
    	Connection con = null;
    	PreparedStatement psta = null;
    	String sql="update TestInfo set testTime=?,suggestID=?,vitalCapacity=?,height=?,weight=?,jump=?,sitUp=?,pullUp=?,eightHundred=?,oneThousand=?,fifty=?,sitAndReach=? where ID=?";
    	boolean flag = false;
    	try {
    		con = BaseDao.getConnection();
    		psta = con.prepareStatement(sql);
    		
    		psta.setDate(1, (Date)obj.getTime());
    		psta.setString(2, obj.getSuggestID());
    		psta.setDouble(3, obj.getVitalCapacity());
    		psta.setDouble(4, obj.getHeight());
    		psta.setDouble(5, obj.getWeight());
    		psta.setDouble(6, obj.getJump());
    		psta.setInt(7, obj.getSitUp());
    		psta.setInt(8, obj.getPullUp());
    		psta.setDouble(9, obj.getEightHundred());
    		psta.setDouble(10, obj.getOneThousand());
    		psta.setDouble(11, obj.getFifty());
    		psta.setDouble(12, obj.getSitAndReach());
    		psta.setString(13, obj.getID());
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
    
    public String getSuggest(TestInfo obj){
    	StudentDao studentDao = new StudentDao();
    	Student student = studentDao.findById(obj.getStudentID());
    	int sex = student.getSex();
    	String suggestID = "";
    	if(sex == 1){
    	if(obj.getHeight()>0&&obj.getHeight()<150&&obj.getSitAndReach()>0&&obj.getSitAndReach()<=10){
    		suggestID = "50001";
    	}
    	else if (obj.getHeight()>0&&obj.getHeight()<=140&&obj.getSitAndReach()>10&&obj.getSitAndReach()<=20) {
    		suggestID = "50002";
		}
        else if (obj.getHeight()>0&&obj.getHeight()<=140&&obj.getSitAndReach()>20) {
        	suggestID = "50003";
}
        else if (obj.getHeight()>140&&obj.getHeight()<=150&&obj.getSitAndReach()>0&&obj.getSitAndReach()<=10) {
        	suggestID = "50001";
}
        else if (obj.getHeight()>140&&obj.getHeight()<=150&&obj.getSitAndReach()>10&&obj.getSitAndReach()<=20) {
        	suggestID = "50004";
}
        else if (obj.getHeight()>140&&obj.getHeight()<=150&&obj.getSitAndReach()>=20) {
        	suggestID = "50005";
}
        else if (obj.getHeight()>150&&obj.getHeight()<=160&&obj.getSitAndReach()>0&&obj.getSitAndReach()<=10) {
        	suggestID = "50006";
}
    	
        else if (obj.getHeight()>150&&obj.getHeight()<=160&&obj.getSitAndReach()>10&&obj.getSitAndReach()<=20) {
        	suggestID = "50007";
}
        else if (obj.getHeight()>150&&obj.getHeight()<=160&&obj.getSitAndReach()>20) {
        	suggestID = "50008";
}
       else if (obj.getHeight()>160&&obj.getHeight()<=170&&obj.getSitAndReach()>0&&obj.getSitAndReach()<=10) {
    	   suggestID = "50009";
}
       else if (obj.getHeight()>160&&obj.getHeight()<=170&&obj.getSitAndReach()>10&&obj.getSitAndReach()<=20) {
    	   suggestID = "50010";
}
       else if (obj.getHeight()>160&&obj.getHeight()<=170&&obj.getSitAndReach()>20) {
    	   suggestID = "50011";
}
       else if (obj.getHeight()>170&&obj.getSitAndReach()>11&&obj.getSitAndReach()>0&&obj.getSitAndReach()<=10) {
    	   suggestID = "50012";
}
       else if (obj.getHeight()>170&&obj.getSitAndReach()>11&&obj.getSitAndReach()>10&&obj.getSitAndReach()<=20) {
    	   suggestID = "50012";
}
       else if (obj.getHeight()>170&&obj.getSitAndReach()>11&&obj.getSitAndReach()>20) {
    	   suggestID = "50013";
}
    	}
    	else{
        	if (obj.getHeight()>0&&obj.getHeight()<=150&&obj.getVitalCapacity()>0&&obj.getVitalCapacity()<=3000) {
        		suggestID = "50014";
    		}
            else if (obj.getHeight()>0&&obj.getHeight()<=150&&obj.getVitalCapacity()>3000&&obj.getVitalCapacity()<=4000) {
            	suggestID = "50015";
    }
            else if (obj.getHeight()>0&&obj.getHeight()<=150&&obj.getVitalCapacity()>4000&&obj.getVitalCapacity()<=5000) {
            	suggestID = "50016";
    }
            else if (obj.getHeight()>0&&obj.getHeight()<=150&&obj.getVitalCapacity()>5000) {
            	suggestID = "50017";
            }
            else if (obj.getHeight()>150&&obj.getHeight()<=160&&obj.getVitalCapacity()>0&&obj.getVitalCapacity()<=3000) {
            	suggestID = "50018";
            }
            else if (obj.getHeight()>150&&obj.getHeight()<=160&&obj.getVitalCapacity()>3000&&obj.getVitalCapacity()<=4000) {
            	suggestID = "50019";
                    }
            else if (obj.getHeight()>150&&obj.getHeight()<=160&&obj.getVitalCapacity()>4000&&obj.getVitalCapacity()<=5000) {
            	suggestID = "50020";
                    }
            else if (obj.getHeight()>150&&obj.getHeight()<=160&&obj.getVitalCapacity()>5000) {
            	suggestID = "50021";    	
                            }
            else if (obj.getHeight()>160&&obj.getHeight()<=170&&obj.getVitalCapacity()>0&&obj.getVitalCapacity()<=3000) {
            	suggestID = "50022";    	
                            }
            else if (obj.getHeight()>160&&obj.getHeight()<=170&&obj.getVitalCapacity()>3000&&obj.getVitalCapacity()<=4000) {
            	suggestID = "50023";            	
                                    }
            else if (obj.getHeight()>160&&obj.getHeight()<=170&&obj.getVitalCapacity()>4000&&obj.getVitalCapacity()<=5000) {
            	suggestID = "50024";            	
                                    }
            else if (obj.getHeight()>160&&obj.getHeight()<=170&&obj.getVitalCapacity()>5000) {
            	suggestID = "50025";
            }
                    else if (obj.getHeight()>170&&obj.getHeight()<=180&&obj.getVitalCapacity()>0&&obj.getVitalCapacity()<=3000) {
                    	suggestID = "50026";
                    }
                    else if (obj.getHeight()>170&&obj.getHeight()<=180&&obj.getVitalCapacity()>3000&&obj.getVitalCapacity()<=4000) {
                    	suggestID = "50027";
                    }
                    else if (obj.getHeight()>170&&obj.getHeight()<=180&&obj.getVitalCapacity()>4000&&obj.getVitalCapacity()<=5000) {
                    	suggestID = "50028";   	
                            }
                    else if (obj.getHeight()>170&&obj.getHeight()<=180&&obj.getVitalCapacity()>5000) {
                    	suggestID = "50029";   	
                            }
                    else if (obj.getHeight()>180&&obj.getVitalCapacity()>0&&obj.getVitalCapacity()<=3000) {
                    	suggestID = "50030";           	
                                    }
                    else if (obj.getHeight()>180&&obj.getVitalCapacity()>3000&&obj.getVitalCapacity()<=4000) {
                    	suggestID = "50031";           	
                                    }
                    else if (obj.getHeight()>180&&obj.getVitalCapacity()>4000&&obj.getVitalCapacity()<=5000) {
                    	suggestID = "50032";                   	
                                            }
                    else if (obj.getHeight()>180&&obj.getVitalCapacity()>5000) {
                    	suggestID = "50033";                   	
                                            }

    	}
    	return suggestID;
    }

}
