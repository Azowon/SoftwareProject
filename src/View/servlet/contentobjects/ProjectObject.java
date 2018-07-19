package servlet.contentobjects;

public class ProjectObject {
	private String name;
	private String nameLink;
	private String description;
	private String deadline;
	private String time;
	private String workpackages;
	
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
		this.nameLink = "<a href='/sw_proj/ProjectServlet'>" + nameLink + "</a>";
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
	
	public String getWorkpackages() {
		return workpackages;
	}
	
	public void setWorkpackages(String workpackages) {
		this.workpackages = workpackages;
	}
}
