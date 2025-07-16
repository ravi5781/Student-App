package in.bg.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.bg.studentapp.dao.studentDAO;
import in.bg.studentapp.dao.studentDAOimpl;
import in.bg.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signup")

public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s=new Student();
		studentDAO sdao=new studentDAOimpl();
		PrintWriter out=resp.getWriter();
		
		s.setName(req.getParameter("name"));
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLocation(req.getParameter("location"));
		if(req.getParameter("password").equals(req.getParameter("confirmPassword"))) {
			s.setPassword(req.getParameter("confirmPassword"));
			boolean res=sdao.insertStudent(s);
			if(res) {
//			out.println("<h1>Data added successfully</h1>");
			req.setAttribute("success","Account created successfully");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
			}
			else {
				req.setAttribute("error","Failed to create Account");
				RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
				rd.forward(req, resp);
			}

		}
		else {
			req.setAttribute("error","Password mismatch, Try Again!!");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
		}
		
	}
}
