package in.bg.studentapp.model;

import java.util.Scanner;

import in.bg.studentapp.dao.studentDAO;
import in.bg.studentapp.dao.studentDAOimpl;
import in.bg.studentapp.dto.Student;

public class Delete {
	public static void delete(Student s) {
		studentDAO sdao=new studentDAOimpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student ID to delete :");
		int id=sc.nextInt();
		boolean res=sdao.deleteStudent(id);
		if(res) {
			System.out.println("Deletion Successfull");
		}
		else {
			System.out.println("Failed to Delete");
		}
	}
}
