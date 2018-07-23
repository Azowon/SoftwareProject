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
import View.servlet.contentobjects.ServletHelper;
import View.servlet.contentobjects.TaskObject;
import View.servlet.interfaces.IMyTasks;
import View.servlet.interfaces.INavigationBar;



/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet implements INavigationBar, IMyTasks {
	private static final long serialVersionUID = 1L;
    private ServletHelper sh;
    private NavigationBarObject nbo;
    private MyTasksObject mto;
    private TaskObject t;
	HttpServletRequest req;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskServlet() {
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
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/Task.jsp");
		view.forward(request, response);
	}
	
	//Extra Method to configure jsp which will be forwarded to
	private void configureJSP() {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
        mto = sh.getMyTasks((String)req.getSession().getAttribute("username"));
        
        long taskId=Long.parseLong(req.getQueryString().split("=")[1]);
        t=sh.getTask(taskId);
        
		setMyTasks();
		setNavigationBar();
		setTask();
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
	 * Set details of the tasks to be presented
	 */
	private void setTask() {
		String name = t.getName();
		String nameLink = t.getNameLink();
		String pNameLink = t.getProjectNameLink();
		String wpNameLink = t.getWorkpackageNameLink();
		String deadline = t.getDeadline();
		String desc = t.getDescription();
		String time = t.getTime();
		String status = t.getStatus();
		String au = t.getAssignedUser();
		
		req.setAttribute("Name", name);
		req.setAttribute("tasklink", nameLink);
		req.setAttribute("projectlink", pNameLink);
		req.setAttribute("workpackagelink", wpNameLink);
		req.setAttribute("deadline", deadline);
		req.setAttribute("description", desc);
		req.setAttribute("time", time);
		req.setAttribute("status", status);
		req.setAttribute("assigneduser", au);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
