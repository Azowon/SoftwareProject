package View.servlet.create.form;

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
 * Servlet implementation class CreateUserFormServlet
 */
@WebServlet("/CreateUserFormServlet")
public class CreateUserFormServlet extends HttpServlet implements INavigationBar {
	private static final long serialVersionUID = 1L;
    private final String title = "Create User";
    private ServletHelper sh;
    private NavigationBarObject nbo;
	HttpServletRequest req;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserFormServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req = request;
		configureJSP();
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/createUser.jsp");
		view.forward(request, response);
	}
	
	//Extra Method to configure jsp which will be forwarded to
	private void configureJSP() {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
		
        setTitle();
        setNavigationBar();
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
