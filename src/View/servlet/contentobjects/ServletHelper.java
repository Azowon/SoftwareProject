package View.servlet.contentobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Model.Project;
import Model.StatementCreator;
import Model.Task;
import Model.User;
import Model.Workpackage;
import View.servlet.contentobjects.objectbuilder.ProjectObjectBuilder;
import View.servlet.contentobjects.objectbuilder.TaskObjectBuilder;
import View.servlet.contentobjects.objectbuilder.WorkpackageObjectBuilder;

public class ServletHelper {
	
	private StatementCreator st=new StatementCreator();
	
	public NavigationBarObject getNavigationBar() {
		return generateNavigationBar();
	}
	
	public boolean checkAdminPrivilege(String username)
	{
		try
		{
			User u=st.selectUsersWhere("username='"+username+"'").get(0);
			return u.getRole().toLowerCase().equals("admin");
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean createWorkpackage(String name, String description, String deadline, long projectId)
	{
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = formatter.parse(deadline);
			java.sql.Date sqlDate=new java.sql.Date(parsedDate.getTime());
			Workpackage w=new Workpackage(-1, name, description, sqlDate, projectId);
			st.insertWorkpackage(w);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public boolean editWorkpackage(String name, String description, String deadline, long projectId)
	{
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = formatter.parse(deadline);
			java.sql.Date sqlDate=new java.sql.Date(parsedDate.getTime());
			Workpackage w=st.selectWorkpackageWhere("workpackage_id="+this.getWorkpackageId(name)).get(0);
			w.setDeadline(sqlDate);
			w.setDescription(description);
			w.setName(name);
			w.setProjectId(projectId);
			st.updateWorkpackage(w);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public boolean createTask(String name, String description, String deadline,double timeBooked,double timePlanned,String status, long workpackageId,long userId)
	{
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = formatter.parse(deadline);
			java.sql.Date sqlDate=new java.sql.Date(parsedDate.getTime());
			Task t=new Task(-1, name, description, sqlDate,status,timeBooked,timePlanned,workpackageId,userId );
			st.insertTask(t);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public boolean editTask(String name, String description, String deadline,double timeBooked,double timePlanned,String status, long workpackageId,long userId)
	{
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = formatter.parse(deadline);
			java.sql.Date sqlDate=new java.sql.Date(parsedDate.getTime());
			Task t=st.selectTaskWhere("task_id="+this.getTaskId(name)).get(0);
			t.setDeadline(sqlDate);
			t.setDescription(description);
			t.setName(name);
			t.setStatus(status);
			t.setTimeBooked(timeBooked);
			t.setTimePlanned(timePlanned);
			t.setWorkpackageId(workpackageId);
			st.updateTask(t);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public boolean deleteUser(String username)
	{
		try
		{
			User u=st.selectUsersWhere("username='"+username+"'").get(0);
			st.deleteUser(u);
			st.deletePassword(username);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public boolean createUser(String role, String firstname, String lastname, String username, String password, String team, String description)
	{
		if(role==null|firstname==null|lastname==null|username==null|password==null|team==null)
		{
			return false;
		}
		else
		{
			User u=new User(-1,username,firstname,lastname,description,role,team);
			st.insertUser(u);
			st.savePassword(username, password);
			return true;
		}
	}
	
	public boolean checkLogin(String username, String password)
	{
		if(username==null) return false;
		return st.checkPassword(username, password);
	}
	
	private NavigationBarObject generateNavigationBar() {
		
		
		List<Project> projects= st.selectProjects();
		
		NavigationBarObject nbo = new NavigationBarObject();
		
		for(Project p: projects)
		{
			nbo.addProjectContent("/SoftwareProject/ProjectServlet?id="+p.getId(), p.getName());
		}
		
		nbo.addProjectContent("/SoftwareProject/CreateProjectFormServlet", "Create Project");
		
			
		for(Project p: projects)
		{
			nbo.addHeatmapContent("/SoftwareProject/HeatmapProjectServlet?id="+p.getId(), p.getName());
		}
		
		return nbo;
	}
	
	public MyTasksObject getMyTasks(String username) {
		return generateMyTasks(username);
	}
	
	private MyTasksObject generateMyTasks(String username) {
		MyTasksObject mto = new MyTasksObject();
		
		User u=st.selectUsersWhere("username='"+username+"'").get(0);
		
		List<Task> tasks=st.selectTasksForUser(u.getId());
		
		for(Task t : tasks)
		{
			mto.addTask(t.getStatus(), t.getName());
		}			
		return mto;
	}
	
	public ProjectObject getProject(long projectId) {

		Project p=st.selectProjectsWhere("project_id="+projectId).get(0);
		
		List<Workpackage> workpackages=st.selectWorkpackageWhere("project_id="+projectId);
		
		double timePlanned=st.selectTimePlannedForProject(projectId);
		double timeBooked=st.selectTimeBookedForProject(projectId);
		
		ProjectObject po =new ProjectObjectBuilder()
			.setDeadline(p.getDeadline().toString())
			.setDescription(p.getDescription())
			.setName(p.getName())
			.setTime(timeBooked+" ("+timePlanned+")")
			.setProjectId(p.getId())
			.setWorkpackages(workpackages)
			.build();
						
		for(Workpackage w : workpackages)
		{
			timePlanned=st.selectTimePlannedForWorkpackage(w.getId());
			timeBooked=st.selectTimeBookedForWorkpackage(w.getId());
			String s=timeBooked+" ("+timePlanned+")";
			po.addWorkpackageTime(w.getId(), s);
		}
		
		return po;
	}
	
	public HeatmapProjectObject getHeaptmapProject(long projectId) {
		Project p=st.selectProjectsWhere("project_id="+projectId).get(0);
		
		List<Workpackage> workpackages=st.selectWorkpackageWhere("project_id="+projectId);
		
		double timePlanned=st.selectTimePlannedForProject(projectId);
		double timeBooked=st.selectTimeBookedForProject(projectId);
		
		ProjectObject po =new ProjectObjectBuilder()
			.setDeadline(p.getDeadline().toString())
			.setDescription(p.getDescription())
			.setName(p.getName())
			.setTime(timeBooked+" ("+timePlanned+")")
			.setProjectId(p.getId())
			.setWorkpackages(workpackages)
			.build();
		
		HeatmapProjectObject hpo = new HeatmapProjectObject();
		hpo.setProjectId(projectId);
		hpo.setTimeBooked(timeBooked);
		hpo.setTimePlanned(timePlanned);
		hpo.setDeadline(po.getDeadline());
		hpo.setName(po.getName());
		hpo.setGeneratedColor(projectId);
		hpo.setWorkpackages(workpackages);
						
		for(Workpackage w : workpackages)
		{
			timePlanned=st.selectTimePlannedForWorkpackage(w.getId());
			timeBooked=st.selectTimeBookedForWorkpackage(w.getId());
			String s=timeBooked+" ("+timePlanned+")";
			hpo.addWorkpackageTime(w.getId(), s);
		}
		
		return hpo;
	}
	
	public WorkpackageObject getWorkpackage(long workpackageId) {
		
		Workpackage w=st.selectWorkpackageWhere("workpackage_id="+workpackageId).get(0);
		
		Project p=st.selectProjectsWhere("project_id="+w.getProjectId()).get(0);
		
		double timeBooked=st.selectTimeBookedForWorkpackage(workpackageId);
		double timePlanned=st.selectTimePlannedForWorkpackage(workpackageId);
		
		List<Task> tasks=st.selectTaskWhere("workpackage_id="+workpackageId);
		
		WorkpackageObject wp =new WorkpackageObjectBuilder()
				.setDeadline(w.getDeadline().toString())
				.setDescription(w.getDescription())
				.setName(w.getName())
				.setProjectName(p.getName())
				.setProjectId(p.getId())
				.setWorkpackageId(w.getId())
				.setTime(timeBooked+" ("+timePlanned+")")
				.setTasks(tasks)
				.build();
		
		return wp;
	}
	
	public HeatmapWorkpackageObject getHeatmapWorkpackage(long workpackageId) {
		
		Workpackage w=st.selectWorkpackageWhere("workpackage_id="+workpackageId).get(0);
		HeatmapWorkpackageObject hwo = new HeatmapWorkpackageObject();
		
		
		Project p=st.selectProjectsWhere("project_id="+w.getProjectId()).get(0);
		
		double timeBooked=st.selectTimeBookedForWorkpackage(workpackageId);
		double timePlanned=st.selectTimePlannedForWorkpackage(workpackageId);
		
		List<Task> tasks=st.selectTaskWhere("workpackage_id="+workpackageId);

		hwo.setTime(timeBooked + " / " + timePlanned);
		hwo.setDeadline(w.getDeadline().toString());
		hwo.setId(w.getId());
		hwo.setName(w.getName());
		hwo.setGeneratedColor(w.getId());
		hwo.setTasks(tasks);
		
		
		
		
		return hwo;
	}
	
	public TaskObject getTask(long  taskId) {
		
		Task k= st.selectTaskWhere("task_id="+taskId).get(0);
		Workpackage w= st.selectWorkpackageWhere("workpackage_id="+k.getWorkpackageId()).get(0);
		Project p=st.selectProjectsWhere("project_id="+w.getProjectId()).get(0);
		
		User u=st.selectUsersWhere("user_id="+k.getUserId()).get(0);

		TaskObject t = new TaskObjectBuilder()
				.setDeadline(k.getDeadline().toString())
				.setDescription(k.getDescription())
				.setAssignedUser(u.getFirstname()+" "+u.getLastname())
				.setName(k.getName())
				.setStatus(k.getStatus())
				.setTime(k.getTimeBooked()+" ("+k.getTimePlanned()+")")
				.setProjectName(p.getName())
				.setProjectId(p.getId())
				.setTaskId(k.getId())
				.setWorkpackageName(w.getName())
				.setWorkpackageId(w.getId())
				.build();
		
		return t;
	}

	public long getProjectId(String projectName) {
		long k=0;
		k=st.selectProjectsWhere("name='"+projectName+"'").get(0).getId();
		return k;
	}

	public long getWorkpackageId(String wpName) {
		long k=0;
		try
		{
			k=st.selectWorkpackageWhere("name='"+wpName+"'").get(0).getId();
		}
		catch(Exception e) {}
		return k;
	}
	
	public long getTaskId(String taskName) {
		long k=0;
		try
		{
			k=st.selectTaskWhere("name='"+taskName+"'").get(0).getId();
		}
		catch(Exception e) {}
		return k;
	}
	
	public long getUserId(String username) {
		long k=0;
		try 
		{
			k=st.selectUsersWhere("username='"+username+"'").get(0).getId();
		}
		catch(Exception e) {}
		return k;
	}
}
