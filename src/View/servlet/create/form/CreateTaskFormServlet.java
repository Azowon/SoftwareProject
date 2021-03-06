package View.servlet.create.form;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import View.servlet.contentobjects.NavigationBarObject;
import View.servlet.interfaces.INavigationBar;
import View.servlet.util.ServletHelper;

/**
 * Servlet implementation class CreateTaskFormServlet
 */
@WebServlet("/CreateTaskFormServlet")
public class CreateTaskFormServlet extends HttpServlet implements INavigationBar {
	private static final long serialVersionUID = 1L;
    private final String title = "Create Task";
    private ServletHelper sh;
    private NavigationBarObject nbo;
	HttpServletRequest req;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTaskFormServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req = request;
		
		if(request.getSession().getAttribute("username")==null)
		{
			RequestDispatcher view = req.getRequestDispatcher("/indexServlet");
			view.forward(req, response);
		}
		
		configureJSP();
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/createTask.jsp");
		view.forward(req, response);
	}
	
	//Extra Method to configure jsp which will be forwarded to
	private void configureJSP() {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
		
        setTitle();
        setNavigationBar();
        setBackRedirect();
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
		String heatmapContent = nbo.getHeatmapContent();
		String logo = nbo.getLogoPath();
		
		req.setAttribute("projectcontent", projectContent);
		req.setAttribute("heatmapcontent", heatmapContent);
		req.setAttribute("logo", logo);
	}
	
	/**
	 * Set up redirect to workpackage
	 */
	private void setBackRedirect() {
		req.setAttribute("workpackageid", req.getParameter("workpackageid"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
