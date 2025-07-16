package in.bg.studentapp.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import in.bg.studentapp.dao.studentDAO;
import in.bg.studentapp.dao.studentDAOimpl;
import in.bg.studentapp.dto.Student;


@WebServlet("/searchUser")
public class SearchUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		studentDAO sdao=new studentDAOimpl();
		ArrayList<Student> users=sdao.getStudent(req.getParameter("search"));
		req.setAttribute("users", users);
		RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
		rd.forward(req, resp);
	}
}
