package servlet.contentobjects;

public class WorkpackageObject {
	private String name;
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
		setNameLink(name);
	}
	
	public String getNameLink() {
		return nameLink;
	}
	
	public void setNameLink(String nameLink) {
		this.nameLink = "<a href='/sw_proj/WorkpackageServlet'>" + nameLink + "</a>";
	}
	
	public String getProjectNameLink() {
		return projectNameLink;
	}
	
	public void setProjectNameLink(String projectNameLink) {
		this.projectNameLink = "<a href='/sw_proj/ProjectServlet'>" + projectNameLink + "</a>";
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
}
