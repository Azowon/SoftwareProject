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
	
	private NavigationBarObject generateNavigationBar() {
		
		// TO DO: DATENBANKABFRAGE ALLER NAMEN VON EXISTIERENDEN PROJEKTEN
		
		List<Project> projects= st.selectProjects();
		
		NavigationBarObject nbo = new NavigationBarObject();
		
		for(Project p: projects)
		{
			nbo.addProjectContent("/SoftwareProject/ProjectServlet?id="+p.getId(), p.getName());
		}
		//nbo.addProjectContent("/SoftwareProject/ProjectServlet", "Project TEST");
		return nbo;
	}
	
	public MyTasksObject getMyTasks() {
		return generateMyTasks();
	}
	
	private MyTasksObject generateMyTasks() {
		
		// TO DO: DATENBANKABFRAGE DER DER TASKS EINES BENUTZERS
		
		MyTasksObject mto = new MyTasksObject();
		mto.addTask("Finished", "ABC");
		return mto;
	}
	
	public ProjectObject getProject(long projectId) {
		ProjectObject po = new ProjectObject();
		
		// TO DO: DATENBANKABFRAGE ALLER PROJEKTDETAILS + GESAMT TIME + WORKPACKAGES IM PROJEKT
		Project p=st.selectProjectsWhere("project_id="+projectId).get(0);
		
		double timePlanned=st.selectTimePlannedForProject(projectId);
		double timeBooked=st.selectTimeBookedForProject(projectId);
		
		po.setName(p.getName());
		po.setDeadline(p.getDeadline().toString());
		po.setDescription(p.getDescription());
		po.setTime(timeBooked+" ("+timePlanned+")");
		
		List<Workpackage> workpackages=st.selectWorkpackageWhere("project_id="+projectId);
		po.addWorkpackageRange(workpackages);
		
		return po;
	}
	
	public WorkpackageObject getWorkpackage(long workpackageId) {
		WorkpackageObject wp = new WorkpackageObject();
		
		// TO DO: DATENBANKABFRAGE ALLER WORKPACKAGEDETAILS + GESAMT TIME + TASKS + PROJECT DES WORKPACKAGES
		Workpackage w=st.selectWorkpackageWhere("workpackage_id="+workpackageId).get(0);
		
		Project p=st.selectProjectsWhere("project_id="+w.getProjectId()).get(0);
		
		double timeBooked=st.selectTimeBookedForWorkpackage(workpackageId);
		double timePlanned=st.selectTimePlannedForWorkpackage(workpackageId);
		
		List<Task> tasks=st.selectTaskWhere("workpackage_id="+workpackageId);
		
		wp.setName(w.getName());
		wp.setDeadline(w.getDeadline().toString());
		wp.setDescription(w.getDescription());
		wp.setTime(timeBooked+" ("+timePlanned+")");
		wp.addTaskRange(tasks);
		wp.setProjectNameLink(p.getName(),p.getId());
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
