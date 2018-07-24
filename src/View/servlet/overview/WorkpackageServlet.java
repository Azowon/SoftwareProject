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
import View.servlet.contentobjects.WorkpackageObject;
import View.servlet.interfaces.IMyTasks;
import View.servlet.interfaces.INavigationBar;
import View.servlet.util.ServletHelper;


/**
 * Servlet implementation class WorkpackageServlet
 */
@WebServlet("/WorkpackageServlet")
public class WorkpackageServlet extends HttpServlet implements INavigationBar, IMyTasks{
	private static final long serialVersionUID = 1L;
    private ServletHelper sh;
    private NavigationBarObject nbo;
    private MyTasksObject mto;
    private WorkpackageObject wp;
	HttpServletRequest req;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkpackageServlet() {
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
			return;
		}
		
		configureJSP();
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/Workpackage.jsp");
		view.forward(request, response);
	}

	private void configureJSP() {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
        mto = sh.getMyTasks((String)req.getSession().getAttribute("username"));

        long workpackageId=Long.parseLong(req.getQueryString().split("=")[1]);
        wp = sh.getWorkpackage(workpackageId);
             
		setMyTasks();
		setNavigationBar();
		setWorkpackage();
	}

	/**
	 * Set up tasks for logged in user
	 */
	@Override
	public void setMyTasks() {
		String myTasks = mto.getMyTasks();
		
		req.setAttribute("mytasks", myTasks);
	}

	/**
	 * Set up navigation bar
	 */
	@Override
	public void setNavigationBar() {
		String projectContent = nbo.getProjectContent();
		String heatmapContent = nbo.getHeatmapContent();
		String logo = nbo.getLogoPath();
		
		req.setAttribute("projectcontent", projectContent);
		req.setAttribute("heatmapcontent", heatmapContent);
		req.setAttribute("logo", logo);
	}
	
	/**
	 * Set details of the workpackage to be presented
	 */
	private void setWorkpackage() {
		String name = wp.getName();
		String nameLink = wp.getNameLink();
		String pNameLink = wp.getProjectNameLink();
		String deadline = wp.getDeadline();
		String desc = wp.getDescription();
		String time = wp.getTime();
		String tasks = wp.getTasks();
		long workpackageid = wp.getId();
		
		req.setAttribute("name", name);
		req.setAttribute("workpackagelink", nameLink);
		req.setAttribute("projectlink", pNameLink);
		req.setAttribute("deadline", deadline);
		req.setAttribute("description", desc);
		req.setAttribute("time", time);
		req.setAttribute("tasks", tasks);
		req.setAttribute("workpackageid", workpackageid);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
