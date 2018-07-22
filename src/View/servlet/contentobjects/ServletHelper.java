package View.servlet.contentobjects;

import java.util.List;

import Model.Project;
import Model.StatementCreator;
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
		
		wp.setName(w.getName());
		wp.setDeadline(w.getDeadline().toString());
		wp.setDescription(w.getDescription());
		wp.setTime(timeBooked+" ("+timePlanned+")");
		wp.setTasks("<tr><th>Name</th><th>Deadline</th><th>SP left</th><th>Description</th></tr><tr><td><a href='Task.html'>Task 1</a></td><td>12.07.2018</td><td class='spleft'>0</td><td>Design</td></tr><tr><td><a href>Task 2</a></td><td>24.07.2018</td><td class='spleft'>5</td><td>Function</td></tr><tr><td><a href>Task 3</a></td><td>24.07.2018</td><td class='spleft'>10</td><td>Bugs</td></tr>");
		wp.setProjectNameLink(p.getName(),p.getId());
		wp.setNameLink();
		
		return wp;
	}
	
	public TaskObject getTask(String taskName) {
		TaskObject t = new TaskObject();
		
		// TO DO: DATENBANKABFRAGE ALLER TASKDETAILS

		t.setName("Task TEST");
		t.setDeadline("24.07.2018");
		t.setDescription("This is Taks 1: Design from Workpackage 1: Search feature.");
		t.setTime("0 (2)");
		t.setProjectNameLink("Project TEST");
		t.setWorkpackageNameLink("Workpackage TEST");
		t.setStatus("Finished");
		t.setAssignedUser("Nguyen");
		
		return t;
	}
}
