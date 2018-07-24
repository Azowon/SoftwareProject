package Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import Model.StatementCreator;
import Model.Task;
import Model.Workpackage;

public class WorkpackageData {

	private long id;
	private String name;
	private String description;
	private Date deadline;
	private long projectId;
	private String color;
	double timeBooked;
	double timePlanned;
	ArrayList<TaskData> Tasks = new ArrayList<TaskData>();
	
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
	public long getProjectId() {
		return projectId;
	}
	
	public WorkpackageData(long ID, StatementCreator SC)
	{
		List<Workpackage> list = SC.selectWorkpackageWhere("workpackage_id = " + ID);
		id = list.get(0).getId();
		name = list.get(0).getName();
		description = list.get(0).getDescription();
		deadline = list.get(0).getDeadline();
		projectId = list.get(0).getProjectId();
		timeBooked = SC.selectTimeBookedForWorkpackage(ID);
		timePlanned = SC.selectTimePlannedForWorkpackage(ID);
		
		double grenzwertGrün = 0;
		if(timePlanned != 0)
			grenzwertGrün = timePlanned * 0.7;
		
		Heatmap hm = new Heatmap(grenzwertGrün, timePlanned);
		hm.setAufwand(timeBooked);
		color = hm.drawMap();
		
		List<Task> liste = SC.selectTaskWhere("workpackage_id = " + ID);
		
		for(Task t : liste)
		{
			Tasks.add(new TaskData(t.getId(), SC));
		}
	}
}
