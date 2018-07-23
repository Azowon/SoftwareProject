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
 * Servlet implementation class CreateWorkpackageServlet
 */
@WebServlet("/CreateWorkpackageServlet")
public class CreateWorkpackageServlet extends HttpServlet implements INavigationBar {
	private static final long serialVersionUID = 1L;
	private ServletHelper sh;
    private NavigationBarObject nbo;
    private HttpServletRequest req;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateWorkpackageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req=request;
		
		if(request.getSession().getAttribute("username")==null)
		{
			RequestDispatcher view = req.getRequestDispatcher("/indexServlet");
			view.forward(req, response);
		}
		
		sh=new ServletHelper();
		createWorkpackage();
		
		RequestDispatcher view = request.getRequestDispatcher("/indexServlet");
		view.forward(req, response);
	}
	
	private boolean createWorkpackage()
	{
		String name=(String)req.getParameter("workpackage-name");
		String description=(String)req.getParameter("workpackage-description");
		String deadline=(String)req.getParameter("workpackage-deadline");
		String projectName=(String) req.getParameter("project-name");
		
		long projectId=sh.getProjectId(projectName);
		if(projectId<1)
			return false;
		
		return sh.createWorkpackage(name, description, deadline, projectId);
	}
	
	/**
	 * Set up navigation bar
	 */
	@Override
	public void setNavigationBar() {
		nbo=sh.getNavigationBar();
		String projectContent = nbo.getProjectContent();
		String logo = nbo.getLogoPath();
		
		req.setAttribute("projectcontent", projectContent);
		req.setAttribute("logo", logo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
