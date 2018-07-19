package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.contentobjects.MyTasksObject;
import servlet.contentobjects.NavigationBarObject;
import servlet.contentobjects.ServletHelper;
import servlet.contentobjects.TaskObject;
import servlet.interfaces.IMyTasks;
import servlet.interfaces.INavigationBar;

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
		configureJSP(request, response);
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/Task.jsp");
		view.forward(request, response);
	}
	
	private void configureJSP(HttpServletRequest request, HttpServletResponse response) {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
        mto = sh.getMyTasks();
//      t = sh.getWorkpackage((request.getAttribute("taskname")).toString());
        
        // TO DO: NAME VOM WORKPACKAGE UEBER REQUEST ATTRIBUT
        
        t = sh.getTask("Task TEST");
        
		setMyTasks();
		setNavigationBar();
		setTask();
	}
	
	@Override
	public void setMyTasks() {
		String myTasks = mto.getMyTasks();
		
		req.setAttribute("mytasks", myTasks);
	}

	@Override
	public void setNavigationBar() {
		String projectContent = nbo.getProjectContent();
		String logo = nbo.getLogoPath();
		
		req.setAttribute("projectcontent", projectContent);
		req.setAttribute("logo", logo);
	}
	
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
