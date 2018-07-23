package View.servlet.contentobjects;

import java.util.ArrayList;
import java.util.List;

import Controller.Datenlieferant;
import Controller.ProjectData;
import Controller.WorkpackageData;
import Model.Task;
import Model.Workpackage;

public class HeatmapWorkpackageObject {
	private String name;
	private long id;
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
	
	public void setGeneratedColor(long workpackageId) {
		Datenlieferant test = new Datenlieferant();
		WorkpackageData wd = test.getWorkpackage(workpackageId);
		color = wd.getColor();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
		String s="<tr><th>Name</th><th>Deadline</th><th>SP left</th></tr>";
		for(Task t : this.tasks)
		{
			s+="<tr><td><a href='/SoftwareProject/TaskServlet?id="+t.getId()+"'>"+t.getName()+"</a></td><td>"
					+t.getDeadline().toString()+"</td><td class='spleft'>"+t.getTimeBooked()+" ("+t.getTimePlanned()
					+")</td></tr>";
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
	
	public void setTasks(List<Task> task) {
		this.tasks = task;
	}
}
