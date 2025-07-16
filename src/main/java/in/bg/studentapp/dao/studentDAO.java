package in.bg.studentapp.dao;

import java.util.ArrayList;

import in.bg.studentapp.dto.Student;

public interface studentDAO {
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(int id);
	public Student getStudent(String mail,String password);
	public Student getStudent(long phone,String mail);
	public ArrayList<Student> getStudent();
	public ArrayList<Student> getStudent(String name);
}
