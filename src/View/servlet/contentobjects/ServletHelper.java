package View.servlet.contentobjects;

import java.util.List;

import Model.Project;
import Model.StatementCreator;
import Model.Task;
import Model.User;
import Model.Workpackage;

public class ServletHelper {
	
	private StatementCreator st=new StatementCreator();
	
	public NavigationBarObject getNavigationBar() {
		return generateNavigationBar();
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
		ProjectObject po = new ProjectObject();
		
		Project p=st.selectProjectsWhere("project_id="+projectId).get(0);
		
		double timePlanned=st.selectTimePlannedForProject(projectId);
		double timeBooked=st.selectTimeBookedForProject(projectId);
		
		po.setName(p.getName());
		po.setDeadline(p.getDeadline().toString());
		po.setDescription(p.getDescription());
		po.setTime(timeBooked+" ("+timePlanned+")");
		po.setProjectId(p.getId());
		po.setNameLink();
		
		List<Workpackage> workpackages=st.selectWorkpackageWhere("project_id="+projectId);
		po.addWorkpackageRange(workpackages);
		
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
		WorkpackageObject wp = new WorkpackageObject();
		
		Workpackage w=st.selectWorkpackageWhere("workpackage_id="+workpackageId).get(0);
		
		Project p=st.selectProjectsWhere("project_id="+w.getProjectId()).get(0);
		
		double timeBooked=st.selectTimeBookedForWorkpackage(workpackageId);
		double timePlanned=st.selectTimePlannedForWorkpackage(workpackageId);
		
		List<Task> tasks=st.selectTaskWhere("workpackage_id="+workpackageId);
		
		wp.setProjectNameLink(p.getName(), p.getId());
		wp.setName(w.getName());
		wp.setId(w.getId());
		wp.setDeadline(w.getDeadline().toString());
		wp.setDescription(w.getDescription());
		wp.setTime(timeBooked+" ("+timePlanned+")");
		wp.addTaskRange(tasks);
		wp.setNameLink();
		
		return wp;
	}
	
	public TaskObject getTask(long  taskId) {
		TaskObject t = new TaskObject();
		
		Task k= st.selectTaskWhere("task_id="+taskId).get(0);
		Workpackage w= st.selectWorkpackageWhere("workpackage_id="+k.getWorkpackageId()).get(0);
		Project p=st.selectProjectsWhere("project_id="+w.getProjectId()).get(0);
		
		User u=st.selectUsersWhere("user_id="+k.getUserId()).get(0);

		t.setName(k.getName());
		t.setDeadline(k.getDeadline().toString());
		t.setDescription(k.getDescription());
		t.setTime(k.getTimeBooked()+" ("+k.getTimePlanned()+")");
		t.setProjectNameLink(p.getId(),p.getName());
		t.setWorkpackageNameLink(w.getId(),w.getName());
		t.setStatus(k.getStatus());
		t.setAssignedUser(u.getFirstname()+" "+u.getLastname());
		t.setId(k.getId());
		t.setNameLink();
		
		return t;
	}
}
