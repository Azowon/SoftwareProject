package View.servlet.contentobjects;

import java.util.ArrayList;
import java.util.List;

import Model.Workpackage;

public class ProjectObject {
	private String name;
	private String nameLink;
	private String description;
	private String deadline;
	private String time;
	private List<Workpackage> workpackages=new ArrayList<Workpackage>();
	
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
		this.nameLink = "<a href='/SoftwareProject/ProjectServlet'>" + nameLink + "</a>";
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
		//TODO add time thing
		for(Workpackage w : workpackages)
		{
			res+="<tr><td><a href='/SoftwareProject/WorkpackageServlet?id="+w.getId()+"'>"+w.getName()+"1</a></td><td>"
					+w.getDeadline().toString()+"</td><td class='spleft'>15</td>"
							+ "<td>"+w.getDescription()+"/td></tr>";
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
}
