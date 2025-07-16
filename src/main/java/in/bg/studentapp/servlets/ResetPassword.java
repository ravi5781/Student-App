package in.bg.studentapp.servlets;

import java.io.IOException;

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
@WebServlet("/resetPassword")
public class ResetPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		studentDAO sdao=new studentDAOimpl();
		Student s=(Student) session.getAttribute("student");
		if(s!=null) {
			if(Long.parseLong(req.getParameter("phone"))==s.getPhone()&& req.getParameter("mail").equals(s.getMail())) {
				if(req.getParameter("password").equals(req.getParameter("cfnpassword"))) {
					s.setPassword(req.getParameter("password"));
					boolean res=sdao.updateStudent(s);
					if(res) {
						req.setAttribute("success", "Password update Successfull");
						RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
						rd.forward(req, resp);
					}else{
						req.setAttribute("error", "Failed to update password");
						RequestDispatcher rd=req.getRequestDispatcher("Resetpassword.jsp");
						rd.forward(req, resp);
					}
				}else{
					req.setAttribute("error", "Password missmatch");
					RequestDispatcher rd=req.getRequestDispatcher("Resetpassword.jsp");
					rd.forward(req, resp);
				}
			}else {
				req.setAttribute("error", "Something went Worng");
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
			}
		}else {
			req.setAttribute("error", "Failed to update password");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req,resp);
		}

	}

}
