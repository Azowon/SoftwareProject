package View.servlet.contentobjects;

public class TaskObject {
	private String name;
	private String nameLink;
	private String projectNameLink;
	private String workpackageNameLink;
	private String deadline;
	private String description;
	private String time;
	private String status;
	private String assignedUser;
	
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
		this.nameLink = "<a href='/SoftwareProject/TaskServlet'>" + nameLink + "</a>";
	}
	
	public String getProjectNameLink() {
		return projectNameLink;
	}
	
	public void setProjectNameLink(String projectNameLink) {
		this.projectNameLink = "<a href='/SoftwareProject/ProjectServlet'>" + projectNameLink + "</a>";
	}
	
	public String getWorkpackageNameLink() {
		return workpackageNameLink;
	}
	
	public void setWorkpackageNameLink(String workpackageNameLink) {
		this.workpackageNameLink = "<a href='/SoftwareProject/WorkpackageServlet'>" + workpackageNameLink + "</a>";
	}
	
	public String getDeadline() {
		return deadline;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getAssignedUser() {
		return assignedUser;
	}
	
	public void setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
	}
}
