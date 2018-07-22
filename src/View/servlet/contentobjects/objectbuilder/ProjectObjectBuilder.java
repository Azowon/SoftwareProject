package View.servlet.contentobjects.objectbuilder;

import java.util.List;

import Model.Workpackage;
import View.servlet.contentobjects.ProjectObject;

public class ProjectObjectBuilder {
	private long projectId;
	private String name;
	private String description;
	private String deadline;
	private String time;
	private List<Workpackage> workpackages;

	public ProjectObjectBuilder() {
	}
	
	public ProjectObject build() {
		ProjectObject po = new ProjectObject();
		
		po.setProjectId(projectId);
		po.setName(name);
		po.setDescription(description);
		po.setDeadline(deadline);
		po.setTime(time);
		po.setNameLink();
		po.addWorkpackageRange(workpackages);
		
		return po;
	}
	
	public ProjectObjectBuilder setProjectId(long projectId) {
		this.projectId = projectId;
		return this;
	}
	
	public ProjectObjectBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public ProjectObjectBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public ProjectObjectBuilder setDeadlin(String deadline) {
		this.deadline = deadline;
		return this;
	}
	
	public ProjectObjectBuilder setTime(String time) {
		this.time = time;
		return this;
	}
	
	public ProjectObjectBuilder setWorkpackages(List<Workpackage> workpackages) {
		this.workpackages = workpackages;
		return this;
	}
}
