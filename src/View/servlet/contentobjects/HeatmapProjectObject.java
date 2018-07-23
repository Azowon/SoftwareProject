package View.servlet.contentobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Workpackage;
import Controller.*;

public class HeatmapProjectObject {
	private long projectId;
	private String name;
	private String deadline;
	private double timePlanned;
	private double timeBooked;
	private String color;
	private List<Workpackage> workpackages=new ArrayList<Workpackage>();
	private Map<Long, String> wpTimes=new HashMap<Long,String>();
	
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = "Heatmap: " + name;
	}
	
	public String getDeadline() {
		return deadline;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public double getTimePlanned() {
		return timePlanned;
	}
	
	public void setTimePlanned(double timePlanned) {
		this.timePlanned = timePlanned;
	}
	
	public double getTimeBooked() {
		return timeBooked;
	}
	
	public void setTimeBooked(double timeBooked) {
		this.timeBooked = timeBooked;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setGeneratedColor(long projectId) {
		Datenlieferant test = new Datenlieferant();
		ProjectData pd = test.getProject(projectId);
		color = pd.getColor();
	}
	
	public String getWorkpackageString() {
		String res="<tr><th>Name</th><th>Deadline</th><th>Time</th><th>Heat Status</th></tr>";
		
		for(Workpackage w : workpackages)
		{
			Datenlieferant test = new Datenlieferant();
			WorkpackageData wd = test.getWorkpackage(w.getId());
			
			String timeContent=this.wpTimes.get(w.getId());
			res+="<tr><td><a href='/SoftwareProject/HeatmapWorkpackageServlet?id="+w.getId()+"'>"+w.getName()+"1</a></td><td>"
					+w.getDeadline().toString()+"</td><td class='spleft'>"+timeContent+"</td>"
							+ "<td style='background-color: " + wd.getColor() + ";'></td></tr>";
		}
		return res;
	}
	
	public void addWorkpackage(Workpackage w) {
		this.workpackages.add(w);
	}
	
	public void addWorkpackageRange(List<Workpackage> workpackage)
	{
		if(workpackage.size()>0)
		{
			for(Workpackage w : workpackage)
			{
				this.addWorkpackage(w);
			}
		}
	}
	
	public void addWorkpackageTime(long wpId, String content)
	{
		this.wpTimes.put(wpId, content);
	}
	
	public void setWorkpackages(List<Workpackage> workpackages) {
		this.workpackages = workpackages;
	}
}
