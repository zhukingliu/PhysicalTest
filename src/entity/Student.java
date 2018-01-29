package entity;

import java.sql.Date;

public class Student {
	private String studentID;
	private String Name;
	private Date Birthday;
	private int Sex;
	private String Project;
	private String College;
	private String teacherID;
	private String leaderID;
	private String password;
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	public int getSex() {
		return Sex;
	}
	public void setSex(int sex) {
		Sex = sex;
	}
	public String getProject() {
		return Project;
	}
	public void setProject(String project) {
		Project = project;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getLeaderID() {
		return leaderID;
	}
	public void setLeaderID(String leaderID) {
		this.leaderID = leaderID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
