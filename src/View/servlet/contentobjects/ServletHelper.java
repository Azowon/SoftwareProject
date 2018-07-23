package View.servlet.contentobjects;

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
			.setDeadlin(p.getDeadline().toString())
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
}
