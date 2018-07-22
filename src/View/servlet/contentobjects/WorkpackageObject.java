package View.servlet.contentobjects;

public class WorkpackageObject {
	private String name;
	private String id;
	private String nameLink;
	private String projectNameLink;
	private String description;
	private String deadline;
	private String time;
	private String tasks;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNameLink() {
		return nameLink;
	}
	
	public void setNameLink() {
		this.nameLink = "<a href='/SoftwareProject/WorkpackageServlet?id="+this.id+"'>" + this.name + "</a>";
	}
	
	public String getProjectNameLink() {
		return projectNameLink;
	}
	
	public void setProjectNameLink(String projectName,long projectId) {
		this.projectNameLink = "<a href='/SoftwareProject/ProjectServlet?id='"+projectId+">" + projectName + "</a>";
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDeadline() {
		return deadline;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTasks() {
		return tasks;
	}
	
	public void setTasks(String tasks) {
		this.tasks = tasks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
