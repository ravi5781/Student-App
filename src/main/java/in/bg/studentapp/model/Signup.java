package in.bg.studentapp.model;

import java.util.Scanner;

import in.bg.studentapp.dao.studentDAO;
import in.bg.studentapp.dao.studentDAOimpl;
import in.bg.studentapp.dto.Student;

public class Signup {
	public static void signup() {
		Student s=new Student();
		studentDAO sdao=new studentDAOimpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name :");
		s.setName(sc.next());
		System.out.println("Enter your phone :");
		s.setPhone(sc.nextLong());
		System.out.println("Enter your mail :");
		s.setMail(sc.next());
		System.out.println("Enter your branch :");
		s.setBranch(sc.next());
		System.out.println("Enter your location :");
		s.setLocation(sc.next());
		System.out.println("Enter your password :");
		String password=sc.next();
		System.out.println("Confirm Password :");
		String confirmPassword = sc.next();
		if(password.equals(confirmPassword)) {
			s.setPassword(confirmPassword);
			boolean res=sdao.insertStudent(s);
			if(res) {
				System.out.println("Data added successfully");
			}
			else {
				System.out.println("Failed to add Data");
			}
		}
		else {
			System.out.println("Password mismatched");
		}
		
	}
}
