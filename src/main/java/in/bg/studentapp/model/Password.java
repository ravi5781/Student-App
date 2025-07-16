package in.bg.studentapp.model;

import java.util.Scanner;

import in.bg.studentapp.dao.studentDAO;
import in.bg.studentapp.dao.studentDAOimpl;
import in.bg.studentapp.dto.Student;

public class Password {
	public static void forgot() {
		studentDAO sdao=new studentDAOimpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your phone no :");
		Long phone=sc.nextLong();
		System.out.println("Enter your mail id :");
		String mail=sc.next();
		Student s=sdao.getStudent(phone, mail);
		if(s!=null) {
			System.out.println("Enter the new password :");
			String password=sc.next();
			System.out.println("Confirm new password :");
			String confirmPassword=sc.next();
			if(password.equals(confirmPassword)) {
				s.setPassword(confirmPassword);
				boolean res=sdao.updateStudent(s);
				if(res) {
					System.out.println("Password Updated!");
				}
				else {
					System.out.println("Failed to update password!");
				}
			}
			else {
				System.out.println("Password mismatch");
			}
		}
		else {
			System.out.println("No such student found");
		}
	}
}
