package View.servlet.overview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import View.servlet.contentobjects.NavigationBarObject;
import View.servlet.contentobjects.UserObject;
import View.servlet.interfaces.INavigationBar;
import View.servlet.util.ServletHelper;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet implements INavigationBar {
	private static final long serialVersionUID = 1L;
    private final String title = "User Profile";
	private ServletHelper sh;
    private NavigationBarObject nbo;
	HttpServletRequest req;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req = request;
		
		if(request.getSession().getAttribute("username")==null)
		{
			RequestDispatcher view = req.getRequestDispatcher("jsp/UserProfile.jsp");
			view.forward(req, response);
		}
		
		configureJSP();
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/UserProfile.jsp");
		view.forward(req, response);
	}
	
	//Extra Method to configure jsp which will be forwarded to
	private void configureJSP() {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
		
        setTitle();
        setNavigationBar();
        setUserContent();
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
	 * Set up user profile content
	 */
	public void setUserContent() {
		UserObject uo = sh.getUser((String) req.getSession().getAttribute("username"));
		
		String role = uo.getRole();
		String firstName = uo.getFirstname();
		String lastName = uo.getLastname();
		String description = uo.getDescription();
		String username = uo.getUsername();
		String team = uo.getTeam();
		
		req.setAttribute("role", role);
		req.setAttribute("userfirstname", firstName);
		req.setAttribute("userlastname", lastName);
		req.setAttribute("userdescription", description);
		req.setAttribute("username", username);
		req.setAttribute("team", team);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
