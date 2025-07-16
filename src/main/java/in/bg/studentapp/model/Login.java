package in.bg.studentapp.model;

import java.util.ArrayList;
import java.util.Scanner;

import in.bg.studentapp.dao.studentDAO;
import in.bg.studentapp.dao.studentDAOimpl;
import in.bg.studentapp.dto.Student;

public class Login {
	public static void login() {
		studentDAO sdao=new studentDAOimpl();
		Scanner sc=new Scanner(System.in);
		int choice=0;
		System.out.println("Enter mail id :");
		String mail=sc.next();
		System.out.println("Enter your password :");
		String password=sc.next();
		Student s=sdao.getStudent(mail, password);
		if(s!=null) {
			System.out.println("Login successful, Welcome "+s.getName());
			do {
				System.out.println("1.View Account");
				System.out.println("2.Update Account");
				System.out.println("3.Search User");
				System.out.println("5.Main Menu");
				if(s.getId()==1) { //for admin purpose
					System.out.println("6.Delete User");
					System.out.println("7.View All Users");
				}
				choice=sc.nextInt();
				switch(choice) {
				case 1: System.out.println(s);
				break;
				case 2: Update.update(s);
				break;
				case 3 : System.out.println("Enter the name of student :");
				ArrayList<Student> list=sdao.getStudent(sc.next());
				for(Student s2:list) {
					System.out.println("ID :"+s2.getId());
					System.out.println("NAME :"+s2.getName());
					System.out.println("BRANCH :"+s2.getBranch());
					System.out.println("********************************");
				}
				break;
				case 4: Password.forgot();
				break;
				case 5: System.out.println("Going back to main menu");
				break;
				case 6: Delete.delete(s);
					break;
				case 7:ArrayList<Student> students=sdao.getStudent();
				for(Student s1:students) {
					System.out.println("ID :"+s1.getId());
					System.out.println("NAME :"+s1.getName());
					System.out.println("PHONE "+s1.getPhone());
					System.out.println("MAIL :"+s1.getMail());
					System.out.println("BRANCH :"+s1.getBranch());
					System.out.println("LOCATION :"+s1.getLocation());
					System.out.println("********************************");
				}
					break;
				default:
					break;
				}
			} while (choice!=5);
		}
		else {
			System.out.println("Failed to login");
		}
	}
}
