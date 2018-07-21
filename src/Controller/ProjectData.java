package Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import Model.Project;
import Model.StatementCreator;
import Model.Workpackage;

public class ProjectData {

	private String name;
	private String color;
	private String description;
	private Date deadline;
	private double timePlanned;
	private double timeBooked;
	ArrayList<WorkpackageData> workpackagesData = new ArrayList<WorkpackageData>();
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	public double getTimeBooked() {
		return timeBooked;
	}
	
	public double getTimePlanned() {
		return timePlanned;
	}
	
	public ProjectData(long ID, StatementCreator SC, Heatmap hm)
	{
		List<Project> list = SC.selectProjectsWhere("project_id = "+ID);
		
		this.name = list.get(0).getName();
		this.description = list.get(0).getDescription();
		this.deadline = list.get(0).getDeadline();
		this.timeBooked = SC.selectTimeBookedForProject(ID);
		this.timePlanned = SC.selectTimePlannedForProject(ID);
		hm.setAufwand((int)timeBooked);
		color = hm.drawMap();
		
		List<Workpackage> workpackages = SC.selectWorkpackageWhere("project_id = " + ID);
		
		for(Workpackage w : workpackages)
		{
			workpackagesData.add(new WorkpackageData(w.getId(), SC, hm));
		}
	}
	
	
}
