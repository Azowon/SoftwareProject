package View.servlet.create;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import View.servlet.util.ServletHelper;

/**
 * Servlet implementation class CreateProjectServlet
 */
@WebServlet("/CreateProjectServlet")
public class CreateProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest req;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProjectServlet() {
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
		
		createProject();
		
		RequestDispatcher view = request.getRequestDispatcher("/indexServlet");
		view.forward(request, response);
	}
	
	private boolean createProject()
	{
		ServletHelper sh=new ServletHelper();
		String name=(String) req.getParameter("project-name");
		String deadline=(String) req.getParameter("project-deadline");
		String description=(String) req.getParameter("project-description");
		
		long projectId=sh.getProjectId(name);
		
		if(projectId<1)
		{
			return sh.createProject(name, description, deadline);
		}
		else
		{
			return sh.editProject(name, description, deadline);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
