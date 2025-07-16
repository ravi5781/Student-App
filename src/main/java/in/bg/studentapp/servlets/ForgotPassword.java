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
@WebServlet("/ResetPassword")
public class ForgotPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		studentDAO sdao=new studentDAOimpl();
		PrintWriter out=resp.getWriter();
		Student s=sdao.getStudent(Long.parseLong(req.getParameter("phone")), req.getParameter("mail"));
		if(s!=null) {
			if(req.getParameter("password").equals(req.getParameter("confirm"))) {
				s.setPassword(req.getParameter("confirm"));
				boolean res=sdao.updateStudent(s);
				if(res) {
					req.setAttribute("success","Password reset successful, Try Logging in!!");
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				}else {
					req.setAttribute("error","Failed to reset password");
					RequestDispatcher rd=req.getRequestDispatcher("forgotPassword.jsp");
					rd.forward(req, resp);
				}
			}
			else {
				req.setAttribute("error","Password Mismatched");
				RequestDispatcher rd=req.getRequestDispatcher("forgotPassword.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			req.setAttribute("error","Student Not Found.");
			RequestDispatcher rd=req.getRequestDispatcher("forgotPassword.jsp");
			rd.forward(req, resp);
		}
	}
}
