package View.servlet.contentobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Workpackage;

public class ProjectObject {
	private long projectId;
	private String name;
	private String nameLink;
	private String description;
	private String deadline;
	private String time;
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
		this.name = name;
	}
	
	public String getNameLink() {
		return nameLink;
	}
	
	public void setNameLink() {
		this.nameLink = "<a href='/SoftwareProject/ProjectServlet?id="+this.projectId+"'>" + this.name + "</a>";
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
	
	public String getWorkpackageString() {
		String res="<tr><th>Name</th><th>Deadline</th><th>SP left</th><th>Description</th></tr>";
		
		for(Workpackage w : workpackages)
		{
			String timeContent=this.wpTimes.get(w.getId());
			res+="<tr><td><a href='/SoftwareProject/WorkpackageServlet?id="+w.getId()+"'>"+w.getName()+"</a></td><td>"
					+w.getDeadline().toString()+"</td><td class='spleft'>"+timeContent+"</td>"
							+ "<td>"+w.getDescription()+"</td></tr>";
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
}
