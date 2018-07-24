package View.servlet.contentobjects;

import java.util.ArrayList;
import java.util.List;

import Model.Task;

public class WorkpackageObject {
	private String name;
	private long id;
	private String nameLink;
	private long projectId;
	private String projectName;
	private String projectNameLink;
	private String description;
	private String deadline;
	private String time;
	private String color;
	private List<Task> tasks=new ArrayList<Task>();
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
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
	
	public long getProjectId() {
		return projectId;
	}
	
	public void setProjectId() {
		this.projectId = projectId;
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

	public void setProjectNameLink(String projectName,long projectId) {
		this.projectNameLink = "<a href='/SoftwareProject/ProjectServlet?id="+projectId+"'>" + projectName + "</a>";
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
		String s="<tr><th>Name</th><th>Deadline</th><th>SP left</th><th>Description</th></tr>";
		for(Task t : this.tasks)
		{
			s+="<tr><td><a href='/SoftwareProject/TaskServlet?id="+t.getId()+"'>"+t.getName()+"</a></td><td>"
					+t.getDeadline().toString()+"</td><td class='spleft'>"+t.getTimeBooked()+" ("+t.getTimePlanned()
					+")</td><td>"+t.getDescription()+"</td></tr>";
		}
		return s;
	}
	
	public void addTask(Task t)
	{
		this.tasks.add(t);
	}
	
	public void addTaskRange(List<Task> tasks)
	{
		for(Task t : tasks)
		{
			this.addTask(t);
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
