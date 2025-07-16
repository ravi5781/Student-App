package in.bg.studentapp.model;

import java.util.Scanner;

import in.bg.studentapp.dao.studentDAO;
import in.bg.studentapp.dao.studentDAOimpl;
import in.bg.studentapp.dto.Student;

public class Update {
	public static void update(Student s) {
		Scanner sc=new Scanner(System.in);
		studentDAO sdao=new studentDAOimpl();
		int choice=0;
		do {
			System.out.println("Select to Update :");
			System.out.println("1.Name");
			System.out.println("2.Phone");
			System.out.println("3.Mail");
			System.out.println("4.Branch");
			System.out.println("5.Location");
			System.out.println("6.Back");
			choice=sc.nextInt();
			switch(choice) {
			case 1: System.out.println("Enter the new name");
					s.setName(sc.next());
					break;
			case 2: System.out.println("Enter the new Phone");
					s.setPhone(sc.nextLong());
					break;
			case 3: System.out.println("Enter the new Mail");
					s.setMail(sc.next());
					break;
			case 4: System.out.println("Enter the new Branch");
					s.setBranch(sc.next());
					break;
			case 5: System.out.println("Enter the new Location");
					s.setLocation(sc.next());
					break;
			case 6: System.out.println("Going Back");
					break;
			default: System.out.println("Invalid Choice");
					break;
			}
			boolean res=sdao.updateStudent(s);
			if(res) {
				System.out.println("Update successfull");
			}
			else {
				System.out.println("Failed to update");
			}
		}
		while(choice!=6);
		
	}
}
