package View.servlet.overview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import View.servlet.contentobjects.HeatmapProjectObject;
import View.servlet.contentobjects.NavigationBarObject;
import View.servlet.contentobjects.ProjectObject;
import View.servlet.interfaces.INavigationBar;
import View.servlet.util.ServletHelper;

/**
 * Servlet implementation class HeatmapServlet
 */
@WebServlet("/HeatmapProjectServlet")
public class HeatmapProjectServlet extends HttpServlet implements INavigationBar {
	private static final long serialVersionUID = 1L;
    private ServletHelper sh;
    private NavigationBarObject nbo;
	HttpServletRequest req;
	ProjectObject po;
	HeatmapProjectObject hpo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeatmapProjectServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req = request;

		if(request.getSession().getAttribute("username")==null)
		{
			RequestDispatcher view = req.getRequestDispatcher("jsp/HeatmapProject.jsp");
			view.forward(req, response);
		}
		
		configureJSP();
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/HeatmapProject.jsp");
		view.forward(req, response);
	}
	
	private void configureJSP() {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
        
        long projectId=Long.parseLong(req.getQueryString().split("=")[1]);
        po = sh.getProject(projectId);
        hpo = sh.getHeaptmapProject(projectId);

		setNavigationBar();
		setHeatmapContent();
	}

	@Override
	public void setNavigationBar() {
		String projectContent = nbo.getProjectContent();
		String heatmapContent = nbo.getHeatmapContent();
		String logo = nbo.getLogoPath();
		
		req.setAttribute("projectcontent", projectContent);
		req.setAttribute("heatmapcontent", heatmapContent);
		req.setAttribute("logo", logo);
	}
	
	private void setHeatmapContent() {
		String name = hpo.getName();
		String timeres = hpo.getTimeBooked() + " / " + hpo.getTimePlanned();
		String deadline = hpo.getDeadline();
		String workpackages = hpo.getWorkpackageString();
		String color = hpo.getColor();
		
		req.setAttribute("name", name);
		req.setAttribute("timeres", timeres);
		req.setAttribute("deadline", deadline);
		req.setAttribute("workpackages", workpackages);
		req.setAttribute("color", color);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
