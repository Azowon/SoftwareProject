package View.servlet.delete;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import View.servlet.contentobjects.NavigationBarObject;
import View.servlet.interfaces.INavigationBar;
import View.servlet.util.ServletHelper;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private HttpServletRequest req;
	private ServletHelper sh;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req=request;
		if(request.getSession().getAttribute("username")==null)
		{
			RequestDispatcher view = req.getRequestDispatcher("jsp/LoginPage.jsp");
			view.forward(req, response);
		}
		sh=new ServletHelper();
		if(sh.checkAdminPrivilege((String)req.getSession().getAttribute("username")))
		{
			//TODO add error case
			deleteUser(); 
		}
		RequestDispatcher view = request.getRequestDispatcher("jsp/deleteUser.jsp");
		view.forward(request, response);
	}
	
	private boolean deleteUser()
	{
		return sh.deleteUser(req.getParameter("username"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
