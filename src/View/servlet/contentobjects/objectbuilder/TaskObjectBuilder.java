package View.servlet.contentobjects.objectbuilder;

import View.servlet.contentobjects.TaskObject;

public class TaskObjectBuilder {
//	private long taskId;
	private String name;
	private String nameLink;
//	private long projectId;
	private String projectName;
	private String projectNameLink;
//	private long workpackageId;
	private String workpackageName;
	private String workpackageNameLink;
	private String deadline;
	private String description;
	private String time;
	private String status;
	private String assignedUser;
	
	public TaskObjectBuilder() {
	}
	
	public TaskObject build() {
		TaskObject to = new TaskObject();
		
		to.setName(name);
		to.setProjectName(projectName);
//		to.setWorkpackageName(workpackageName);
		to.setDeadline(deadline);
		to.setDescription(description);
		to.setTime(time);
		to.setStatus(status);
		to.setAssignedUser(assignedUser);
//		to.setTaskId(taskId);
//		to.setWorkpackageId(workpackageId);
//		to.setProjectId(projectId);
		
//		if(nameLink == null) {
//			nameLink = "<form action='/SoftwareProject/TaskServlet' method='post'>"
//					+ "<div id='taskid' style='display:none;'>"
//					+ taskId + "</div><a onclick='form.submit();''>" + name + "</a></form>";
//		}
//		
//		if(workpackageNameLink == null) {
//			nameLink = "<form action='/SoftwareProject/WorkpackageServlet' method='post'>"
//					+ "<div id='workpackageid' style='display:none;'>"
//					+ workpackageId + "</div><a onclick='form.submit();''>" + workpackageName + "</a></form>";
//		}
//		
//		if(projectNameLink == null) {
//			projectNameLink = "<form action='/SoftwareProject/ProjectServlet' method='post'>"
//					+ "<div id='projectid' style='display:none;'>"
//					+ projectId + "</div><a onclick='form.submit();''>" + projectName + "</a></form>";
//		}
		
		return to;
	}
	
//	public TaskObjectBuilder setTaskId(long taskId) {
//		this.taskId = taskId;
//		return this;
//	}
	
	public TaskObjectBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public TaskObjectBuilder setNameLink(String nameLink) {
		this.nameLink = nameLink;
		return this;
	}
	
//	public TaskObjectBuilder setProjectId(long projectId) {
//		this.projectId = projectId;
//		return this;
//	}
	
	public TaskObjectBuilder setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}
	
	public TaskObjectBuilder setProjectNameLink(String projectNameLink) {
		this.projectNameLink = projectNameLink;
		return this;
	}
	
//	public TaskObjectBuilder setWorkpackageId(long workpackageId) {
//		this.workpackageId = workpackageId;
//		return this;
//	}
	
	public TaskObjectBuilder setWorkpackageName(String workpackageName) {
		this.workpackageName = workpackageName;
		return this;
	}
	
	public TaskObjectBuilder setWorkpackageNameLink(String workpackageNameLink) {
		this.workpackageNameLink = workpackageNameLink;
		return this;
	}
	
	public TaskObjectBuilder setDeadline(String deadline) {
		this.deadline = deadline;
		return this;
	}
	
	public TaskObjectBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public TaskObjectBuilder setTime(String time) {
		this.time = time;
		return this;
	}
	
	public TaskObjectBuilder setStatus(String status) {
		this.status = status;
		return this;
	}
	
	public TaskObjectBuilder setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
		return this;
	}
}
