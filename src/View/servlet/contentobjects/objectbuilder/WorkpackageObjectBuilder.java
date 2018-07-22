package View.servlet.contentobjects.objectbuilder;

import java.util.List;

import Model.Task;
import View.servlet.contentobjects.WorkpackageObject;

public class WorkpackageObjectBuilder {
	private long workpackageId;
	private String name;
	private long projectId;
	private String projectName;
	private String description;
	private String deadline;
	private String time;
	private List<Task> tasks;

	public WorkpackageObjectBuilder() {		
	}
	
	public WorkpackageObject build() {
		WorkpackageObject wo = new WorkpackageObject();
		
		wo.setName(name);
		wo.setProjectName(projectName);
		wo.setDescription(description);
		wo.setDeadline(deadline);
		wo.setTime(time);
		wo.setId(workpackageId);
		wo.setProjectNameLink(projectName, projectId);
		wo.addTaskRange(tasks);
		wo.setNameLink();
		
		
		return wo;
	}
	
	public WorkpackageObjectBuilder setWorkpackageId(long workpackageId) {
		this.workpackageId = workpackageId;
		return this;
	}
	
	public WorkpackageObjectBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public WorkpackageObjectBuilder setProjectId(long projectId) {
		this.projectId = projectId;
		return this;
	}
	
	public WorkpackageObjectBuilder setProjectName(String projectNam) {
		this.projectName = projectNam;
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
	
	public WorkpackageObjectBuilder setTasks(List<Task> tasks) {
		this.tasks = tasks;
		return this;
	}
}
