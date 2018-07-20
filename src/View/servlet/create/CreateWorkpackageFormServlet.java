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
 * Servlet implementation class CreateWorkpackageFormServlet
 */
@WebServlet("/CreateWorkpackageFormServlet")
public class CreateWorkpackageFormServlet extends HttpServlet implements INavigationBar {
	private static final long serialVersionUID = 1L;
    private ServletHelper sh;
    private NavigationBarObject nbo;
	HttpServletRequest req;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateWorkpackageFormServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req = request;
		configureJSP();
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/createWorkpackage.jsp");
		view.forward(req, response);
	}
	
	private void configureJSP() {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
		
        setTitle();
        setProject();
        setNavigationBar();
	}
	
	public void setTitle() {
		String title = "Test";
		req.setAttribute("title", title);
	}
	
	public void setProject() {
		String project = "ProjectServlet";
		req.setAttribute("project", project);
	}
	
	@Override
	public void setNavigationBar() {
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