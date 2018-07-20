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
import View.servlet.contentobjects.WorkpackageObject;
import View.servlet.interfaces.IMyTasks;
import View.servlet.interfaces.INavigationBar;


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
		configureJSP(request, response);
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/Workpackage.jsp");
		view.forward(request, response);
	}

	private void configureJSP(HttpServletRequest request, HttpServletResponse response) {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
        mto = sh.getMyTasks();
//      wp = sh.getWorkpackage((request.getAttribute("workpackagename")).toString());
        
        // TO DO: NAME VOM WORKPACKAGE UEBER REQUEST ATTRIBUT
        
        wp = sh.getWorkpackage("Workpackage TEST");
        
		setMyTasks();
		setNavigationBar();
		setWorkpackage();
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
	
	private void setWorkpackage() {
		String name = wp.getName();
		String nameLink = wp.getNameLink();
		String pNameLink = wp.getProjectNameLink();
		String deadline = wp.getDeadline();
		String desc = wp.getDescription();
		String time = wp.getTime();
		String tasks = wp.getTasks();
		
		req.setAttribute("Name", name);
		req.setAttribute("workpackagelink", nameLink);
		req.setAttribute("projectlink", pNameLink);
		req.setAttribute("deadline", deadline);
		req.setAttribute("description", desc);
		req.setAttribute("time", time);
		req.setAttribute("tasks", tasks);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
