package in.bg.studentapp.servlets;

import java.io.IOException;

import in.bg.studentapp.dao.studentDAOimpl;
import in.bg.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/updateAccount")
public class Update extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		studentDAOimpl sdao=new studentDAOimpl();
		Student s=(Student) session.getAttribute("student");
		if(s!=null) {
			s.setName(req.getParameter("name"));
			s.setPhone(Long.parseLong(req.getParameter("phone")));
			s.setMail(req.getParameter("mail"));
			s.setBranch(req.getParameter("branch"));
			s.setLocation(req.getParameter("location"));
			boolean res=sdao.updateStudent(s);
			if(res) {
				req.setAttribute("succuss", "Account Updated Succussfully");
				RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
				rd.forward(req, resp);
			}
			else{
				req.setAttribute("error", "Failed to Update");
				RequestDispatcher rd=req.getRequestDispatcher("updateAccount.jsp");
				rd.forward(req, resp);
			}	
		}
		else {
			req.setAttribute("error", "Session Expired!");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
}
