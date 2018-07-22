package View.servlet.contentobjects.objectbuilder;

import View.servlet.contentobjects.WorkpackageObject;

public class WorkpackageObjectBuilder {
//	private long workpackageId;
	private String name;
	private String nameLink;
//	private long projectId;
	private String projectName;
	private String projectNameLink;
	private String description;
	private String deadline;
	private String time;
//	private String tasks;

	public WorkpackageObjectBuilder() {		
	}
	
	public WorkpackageObject build() {
		WorkpackageObject wo = new WorkpackageObject();
		
//		wo.setWorkpackageId(workpackageId);
		wo.setName(name);
//		wo.setProjectId(projectId);
		wo.setProjectName(projectName);
		wo.setDescription(description);
		wo.setDeadline(deadline);
		wo.setTime(time);
//		wo.setTasks(tasks);
		
//		if(nameLink == null) {
//			nameLink = "<form action='/SoftwareProject/WorkpackageServlet' method='post'>"
//					+ "<div id='workpackageid' style='display:none;'>"
//					+ workpackageId + "</div><a onclick='form.submit();''>" + name + "</a></form>";
//		}
//		
//		if(nameLink == null) {
//			projectNameLink = "<form action='/SoftwareProject/ProjectServlet' method='post'>"
//					+ "<div id='projectid' style='display:none;'>"
//					+ projectId + "</div><a onclick='form.submit();''>" + projectName + "</a></form>";
//		}
		
		return wo;
	}
	
//	public WorkpackageObjectBuilder setWorkpackageId(long workpackageId) {
//		this.workpackageId = workpackageId;
//		return this;
//	}
	
	public WorkpackageObjectBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public WorkpackageObjectBuilder setNameLink(String nameLink) {
		this.nameLink = nameLink;
		return this;
	}
	
//	public WorkpackageObjectBuilder setProjectId(long projectId) {
//		this.projectId = projectId;
//		return this;
//	}
	
	public WorkpackageObjectBuilder setProjectName(String projectNam) {
		this.projectName = projectNam;
		return this;
	}
	
	public WorkpackageObjectBuilder setProjectNameLink(String projectNameLink) {
		this.projectNameLink = projectNameLink;
		return this;
	}
	
	public WorkpackageObjectBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public WorkpackageObjectBuilder setDeadline(String deadline) {
		this.deadline = deadline;
		return this;
	}
	
	public WorkpackageObjectBuilder setTime(String time) {
		this.time = time;
		return this;
	}
	
//	public WorkpackageObjectBuilder setTasks(String tasks) {
//		this.tasks = tasks;
//		return this;
//	}
}
