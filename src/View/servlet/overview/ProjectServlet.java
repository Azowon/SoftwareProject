package View.servlet.overview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import View.servlet.contentobjects.MyTasksObject;
import View.servlet.contentobjects.NavigationBarObject;
import View.servlet.contentobjects.ProjectObject;
import View.servlet.interfaces.IMyTasks;
import View.servlet.interfaces.INavigationBar;
import View.servlet.util.ServletHelper;



/**
 * Servlet implementation class ProjectServlet
 */
@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet implements INavigationBar, IMyTasks {
	private static final long serialVersionUID = 1L;
    private ServletHelper sh;
    private NavigationBarObject nbo;
    private MyTasksObject mto;
    private ProjectObject po;
	HttpServletRequest req;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req = request;

		if(request.getSession().getAttribute("username")==null)
		{
			RequestDispatcher view = req.getRequestDispatcher("jsp/LoginPage.jsp");
			view.forward(req, response);
		}
		
		configureJSP();
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/Project.jsp");
		view.forward(req, response);
	}
	
	private void configureJSP() {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
        mto = sh.getMyTasks((String)req.getSession().getAttribute("username"));
        
        long projectId=Long.parseLong(req.getQueryString().split("=")[1]);
        po=sh.getProject(projectId);
        
		setMyTasks();
		setNavigationBar();
		setProject();
	}

	@Override
	public void setMyTasks() {
		String myTasks = mto.getMyTasks();
		
		req.setAttribute("mytasks", myTasks);
	}

	@Override
	public void setNavigationBar() {
		String projectContent = nbo.getProjectContent();
		String heatmapContent = nbo.getHeatmapContent();
		String logo = nbo.getLogoPath();
		
		req.setAttribute("projectcontent", projectContent);
		req.setAttribute("heatmapcontent", heatmapContent);
		req.setAttribute("logo", logo);
	}

	private void setProject() {
		String name = po.getName();
		String nameLink = po.getNameLink();
		String deadline = po.getDeadline();
		String desc = po.getDescription();
		String time = po.getTime();
		String wps = po.getWorkpackageString();
		long pId= po.getProjectId();
		
		req.setAttribute("projectid", pId);
		req.setAttribute("name", name);
		req.setAttribute("namelink", nameLink);
		req.setAttribute("deadline", deadline);
		req.setAttribute("description", desc);
		req.setAttribute("time", time);
		req.setAttribute("workpackages", wps);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}