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
import jakarta.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		//Student s=new Student();
		studentDAO sdao=new studentDAOimpl();
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(true);
		Student s=sdao.getStudent(req.getParameter("mail"),req.getParameter("password"));
		if(s!=null) {
			
			
			session.setAttribute("student", s);
		
			RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			rd.forward(req, resp);

		}
		else {
			
			req.setAttribute("error", "Password Wrong, Try Resetting your password!!");
			RequestDispatcher rd=req.getRequestDispatcher("forgotPassword.jsp");
			rd.forward(req, resp);
		}
	}
}
