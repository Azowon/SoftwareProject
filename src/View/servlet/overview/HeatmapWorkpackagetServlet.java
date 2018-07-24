package View.servlet.overview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import View.servlet.contentobjects.HeatmapWorkpackageObject;
import View.servlet.contentobjects.NavigationBarObject;
import View.servlet.interfaces.INavigationBar;
import View.servlet.util.ServletHelper;

/**
 * Servlet implementation class HeatmapServlet
 */
@WebServlet("/HeatmapWorkpackageServlet")
public class HeatmapWorkpackagetServlet extends HttpServlet implements INavigationBar {
	private static final long serialVersionUID = 1L;
    private ServletHelper sh;
    private NavigationBarObject nbo;
	HttpServletRequest req;
	HeatmapWorkpackageObject hwo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeatmapWorkpackagetServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req = request;

		if(request.getSession().getAttribute("username")==null)
		{
			RequestDispatcher view = req.getRequestDispatcher("jsp/HeatmapWorkpackage.jsp");
			view.forward(req, response);
		}
		
		configureJSP();
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/HeatmapWorkpackage.jsp");
		view.forward(req, response);
	}
	
	private void configureJSP() {
        sh = new ServletHelper();
        nbo = sh.getNavigationBar();
        
        long workpackageId=Long.parseLong(req.getQueryString().split("=")[1]);
        hwo = sh.getHeatmapWorkpackage(workpackageId);

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
		String name = hwo.getName();
		String timeres = hwo.getTime();
		String deadline = hwo.getDeadline();
		String task = hwo.getTasks();
		String color = hwo.getColor();
		
		req.setAttribute("name", name);
		req.setAttribute("timeres", timeres);
		req.setAttribute("deadline", deadline);
		req.setAttribute("tasks", task);
		req.setAttribute("color", color);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
