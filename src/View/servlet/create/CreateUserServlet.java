package View.servlet.create;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import View.servlet.contentobjects.NavigationBarObject;
import View.servlet.contentobjects.ServletHelper;
import View.servlet.interfaces.INavigationBar;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet implements INavigationBar{
	private static final long serialVersionUID = 1L;
	private HttpServletRequest req;
	private NavigationBarObject nbo;
    private ServletHelper sh;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
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
		if(sh.checkAdminPrivilege((String)req.getSession().getAttribute("username")))
		{
			insertUser();
		}
		/*if(insertUser())
		{
			//response.sendRedirect("jsp/index.jsp");
			RequestDispatcher view = req.getRequestDispatcher("jsp/index.jsp");
			view.forward(req, response);
		}
		else
		{
			RequestDispatcher view = request.getRequestDispatcher("jsp/CreateUserFormServlet.jsp");
			view.forward(req, response);
		}*/
		setNavigationBar();
		RequestDispatcher view = request.getRequestDispatcher("jsp/CreateUserFormServlet.jsp");
		view.forward(req, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private boolean insertUser() {
       sh = new ServletHelper();
       String role=(String) req.getParameter("user-role");
       String firstname=(String) req.getParameter("user-firstname");
       String lastname=(String) req.getParameter("user-lastname");
       String username=(String) req.getParameter("user-username");
       String password=(String) req.getParameter("user-password");
       String team=(String) req.getParameter("user-team");
       String description=(String) req.getParameter("user-description");
       
       return sh.createUser(role, firstname, lastname, username, password, team, description);
	}
	

	@Override
	public void setNavigationBar() {
		nbo=sh.getNavigationBar();
		String projectContent = nbo.getProjectContent();
		String logo = nbo.getLogoPath();
		
		req.setAttribute("projectcontent", projectContent);
		req.setAttribute("logo", logo);
	}


}