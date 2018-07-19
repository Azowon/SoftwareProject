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
import servlet.interfaces.IMyTasks;
import servlet.interfaces.INavigationBar;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet implements INavigationBar, IMyTasks {
	private static final long serialVersionUID = 1L;
    private ServletHelper sh;
    private NavigationBarObject nbo;
    private MyTasksObject mto;
	HttpServletRequest req;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req = request;
		configureJSP();
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/index.jsp");
		view.forward(req, response);
	}
	
	private void configureJSP() {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
        mto = sh.getMyTasks();
        
		setTitle();
		setFeed();
		setNavigationBar();
		setMyTasks();
	}
	
	public void setTitle() {
		String title = "Test";
		req.setAttribute("title", title);
	}
	
	@Override
	public void setNavigationBar() {
		String projectContent = nbo.getProjectContent();
		String logo = nbo.getLogoPath();
		
		req.setAttribute("projectcontent", projectContent);
		req.setAttribute("logo", logo);
	}

	@Override
	public void setMyTasks() {
		String myTasks = mto.getMyTasks();
		
		req.setAttribute("mytasks", myTasks);
	}
	
	private void setFeed() {
		String feed = "Hello World";
		req.setAttribute("feed", feed);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}