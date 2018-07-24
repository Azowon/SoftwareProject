package View.servlet.create;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import View.servlet.util.ServletHelper;

/**
 * Servlet implementation class CreateTaskServlet
 */
@WebServlet("/CreateTaskServlet")
public class CreateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HttpServletRequest req;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTaskServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req=request;
		
		if(request.getSession().getAttribute("username")==null)
		{
			RequestDispatcher view = req.getRequestDispatcher("/indexServlet");
			view.forward(req, response);
		}
		
		createTask();
		RequestDispatcher view = request.getRequestDispatcher("/indexServlet");
		view.forward(request, response);
	}
	
	private boolean createTask()
	{
		ServletHelper sh=new ServletHelper();
		String name=(String) req.getParameter("task-name");
		String description=(String) req.getParameter("task-description");
		String deadline=(String) req.getParameter("task-deadline");
		String wpName=(String) req.getParameter("workpackage-name");
		String status=(String) req.getParameter("task-status");
		double time=Double.parseDouble((String) req.getParameter("task-time"));
		double timeBooked=Double.parseDouble((String) req.getParameter("task-booked"));
		
		long wpId=sh.getWorkpackageId(wpName);
		long userId=sh.getUserId((String)req.getSession().getAttribute("username"));
		long taskId=sh.getTaskId(name);
		if(wpId<1|userId<1)
			return false;
		
		if(taskId<1)
		{
			return sh.createTask(name, description, deadline,timeBooked, time,status, wpId, userId);
		}
		else
		{
			return sh.editTask(name, description, deadline,timeBooked, time,status, wpId, userId);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
