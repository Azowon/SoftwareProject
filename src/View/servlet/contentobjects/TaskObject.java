package View.servlet.contentobjects;

public class TaskObject {
	private String name;
	private long id;
	private String nameLink;
	private String projectName;
	private String projectNameLink;
	private String workpackageName;
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
	}
	
	public String getNameLink() {
		return nameLink;
	}
	
	public void setNameLink() {
		this.nameLink = "<a href='/SoftwareProject/TaskServlet?id="+this.id+"'>" + this.name + "</a>";
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectNameLink() {
		return projectNameLink;
	}
	
	public void setProjectNameLink(long projectId, String projectNameLink) {
		this.projectNameLink = "<a href='/SoftwareProject/ProjectServlet?id="+projectId+"'>" + projectNameLink + "</a>";
	}

	public String getWorkpackageName() {
		return workpackageName;
	}

	public void setWorkpackageName(String workpackageName) {
		this.workpackageName = workpackageName;
	}
	
	public String getWorkpackageNameLink() {
		return workpackageNameLink;
	}
	
	public void setWorkpackageNameLink(long workpackageId, String workpackageNameLink) {
		this.workpackageNameLink = "<a href='/SoftwareProject/WorkpackageServlet?id="+workpackageId+"'>" + workpackageNameLink + "</a>";
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
