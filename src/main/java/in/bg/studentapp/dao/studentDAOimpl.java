package in.bg.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.bg.studentapp.Connection.Connector;
import in.bg.studentapp.dto.Student;

public class studentDAOimpl implements studentDAO {
	private Connection con;
	public studentDAOimpl() {
		this.con=Connector.requestConnection();
	}

	@Override
	public boolean insertStudent(Student s) {
		PreparedStatement ps=null;
		String query ="INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2,s.getPhone());
			ps.setString(3,s.getMail());
			ps.setString(4,s.getBranch());
			ps.setString(5,s.getLocation());
			ps.setString(6,s.getPassword());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateStudent(Student s) {
		PreparedStatement ps=null;
		String query="UPDATE STUDENT SET NAME=?,PHONE=?,MAIL=?,BRANCH=?,LOCATION=?,PASSWORD=?,DATE=SYSDATE() WHERE ID=?";
		int res = 0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2,s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5,s.getLocation());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getId());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean deleteStudent(int id) {
		PreparedStatement ps=null;
		String query="DELETE FROM STUDENT WHERE ID=?";
		Student s=null;
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1,id);
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public Student getStudent(String mail, String password) {
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE MAIL=? AND PASSWORD=?";
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public Student getStudent(long phone, String mail) {
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE PHONE=? AND MAIL=?";
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
	}

	@Override
	public ArrayList<Student> getStudent() {
		// TODO Auto-generated method stub
		ArrayList<Student> students=new ArrayList<Student>();
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT";
		Student s=null;
		
		try {
			ps=con.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	@Override
	public ArrayList<Student> getStudent(String name) {
		// TODO Auto-generated method stub
		ArrayList<Student> list=new ArrayList<Student>();
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE NAME=?";
		Student s=null;
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,name);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				list.add(s);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
		
}


