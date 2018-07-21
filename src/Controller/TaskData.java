package Controller;

import java.sql.Date;
import java.util.List;

import Model.StatementCreator;
import Model.Task;

public class TaskData {
	private long id;
	private String name;
	private String description;
	private Date deadline;
	private String status;
	private double timeBooked;
	private double timePlanned;
	private long workpackageId;
	private long userId;
	private String color;
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public String getStatus() {
		return status;
	}
	public double getTimeBooked() {
		return timeBooked;
	}
	public double getTimePlanned() {
		return timePlanned;
	}
	public long getWorkpackageId() {
		return workpackageId;
	}
	public long getUserId() {
		return userId;
	}
	
	
	
	TaskData(long ID, StatementCreator SC, Heatmap hm)
	{
		List<Task> task = SC.selectTask();
		
		id= task.get(0).getId();
		name= task.get(0).getName();
		description= task.get(0).getDescription();
		deadline= task.get(0).getDeadline();
		status = task.get(0).getStatus();
		timeBooked= task.get(0).getTimeBooked();
		timePlanned= task.get(0).getTimePlanned();
		workpackageId= task.get(0).getWorkpackageId();
		userId= task.get(0).getUserId();
		hm.setAufwand((int)timeBooked);
		color = hm.drawMap();
		
	}
	
}
