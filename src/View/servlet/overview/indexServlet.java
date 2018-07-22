package View.servlet.overview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import View.servlet.contentobjects.MyTasksObject;
import View.servlet.contentobjects.NavigationBarObject;
import View.servlet.contentobjects.ServletHelper;
import View.servlet.interfaces.IMyTasks;
import View.servlet.interfaces.INavigationBar;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet implements INavigationBar, IMyTasks {
	private static final long serialVersionUID = 1L;
    private final String title = "Main Page";
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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req = request;
		sh=new ServletHelper();
		
		HttpSession ses= req.getSession();
		if(ses.getAttribute("username")==null)
		{
			String s = (String) request.getParameter("Username");
			if(sh.checkLogin(s,request.getParameter("Password")))
			{			
				ses.setAttribute("username", s);
			}
			else
			{
				RequestDispatcher view = req.getRequestDispatcher("jsp/LoginPage.jsp");
				view.forward(req, response);
				return;
			}
		}
		configureJSP();
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/index.jsp");
		view.forward(req, response);
	}
	
	//Extra Method to configure jsp which will be forwarded to
	private void configureJSP() {
		
        nbo = sh.getNavigationBar();
        mto = sh.getMyTasks((String)req.getSession().getAttribute("username"));
        
		setTitle();
		setFeed();
		setNavigationBar();
		setMyTasks();
	}
	
	/**
	 * Set Title of the Window manually
	 * @param title
	 * 
	 */
	public void setTitle(String title) {
		req.setAttribute("title", title);
	}
	
	/**
	 * Set Title of the Window with preset title
	 */
	private void setTitle() {
		req.setAttribute("title", title);
	}
	
	/**
	 * Set up navigation bar
	 */
	@Override
	public void setNavigationBar() {
		String projectContent = nbo.getProjectContent();
		String logo = nbo.getLogoPath();
		
		req.setAttribute("projectcontent", projectContent);
		req.setAttribute("logo", logo);
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
	 * Fill in news
	 */
	private void setFeed() {
		String feed = "Hello World";
		req.setAttribute("feed", feed);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
