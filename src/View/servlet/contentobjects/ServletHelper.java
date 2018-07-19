package servlet.contentobjects;

public class ServletHelper {
	
	public NavigationBarObject getNavigationBar() {
		return generateNavigationBar();
	}
	
	private NavigationBarObject generateNavigationBar() {
		
		// TO DO: DATENBANKABFRAGE ALLER NAMEN VON EXISTIERENDEN PROJEKTEN
		
		NavigationBarObject nbo = new NavigationBarObject();
		nbo.addProjectContent("/sw_proj/ProjectServlet", "Project TEST");
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
	
	public ProjectObject getProject(String projectName) {
		ProjectObject po = new ProjectObject();
		
		// TO DO: DATENBANKABFRAGE ALLER PROJEKTDETAILS + GESAMT TIME + WORKPACKAGES IM PROJEKT
		
		po.setName("Project TEST");
		po.setDeadline("24.07.2018");
		po.setDescription("This is Project A.");
		po.setTime("80");
		po.setWorkpackages("<tr><th>Name</th><th>Deadline</th><th>SP left</th><th>Description</th></tr><tr><td><a href='Workpackage.html'>Workpackage 1</a></td><td>24.07.2018</td><td class='spleft'>15</td><td>Search feature</td></tr><tr><td><a href>Workpackage 2</a></td><td>24.07.2018</td><td class='spleft'>19</td><td>Bugs</td></tr><tr><td><a href>Workpackage 3</a></td><td>24.07.2018</td><td class='spleft'>5</td><td>Translation</td></tr>");
	
		return po;
	}
	
	public WorkpackageObject getWorkpackage(String workpackageName) {
		WorkpackageObject wp = new WorkpackageObject();
		
		// TO DO: DATENBANKABFRAGE ALLER WORKPACKAGEDETAILS + GESAMT TIME + TASKS + PROJECT DES WORKPACKAGES
		
		wp.setName("Workpackage TEST");
		wp.setDeadline("24.07.2018");
		wp.setDescription("This is Workpackage TEST from Project TEST.");
		wp.setTime("15 (25)");
		wp.setTasks("<tr><th>Name</th><th>Deadline</th><th>SP left</th><th>Description</th></tr><tr><td><a href='Task.html'>Task 1</a></td><td>12.07.2018</td><td class='spleft'>0</td><td>Design</td></tr><tr><td><a href>Task 2</a></td><td>24.07.2018</td><td class='spleft'>5</td><td>Function</td></tr><tr><td><a href>Task 3</a></td><td>24.07.2018</td><td class='spleft'>10</td><td>Bugs</td></tr>");
		wp.setProjectNameLink("Poject TEST");
		
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
