package Controller;
import java.util.ArrayList;
import java.util.List;

import Model.Project;
import Model.StatementCreator;


public class Datenlieferant {

	StatementCreator SC = new StatementCreator();
	
	public ProjectData getProject(long ID)
	{

		String s = SC.selectTPoint(ID);
		s = "0,0";
		String[] temp = s.split(",");
		
		Heatmap hm = new Heatmap(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		
		
		ProjectData pd = new ProjectData(ID, SC,hm);
	
		return pd;
	}
	
	public WorkpackageData getWorkpackage(long ID)
	{
		
		String s = SC.selectTPoint(SC.selectWorkpackageWhere("workpackage_id = " + ID).get(0).getProjectId());
		s = "0,2";
		String[] temp = s.split(",");
		
		Heatmap hm = new Heatmap(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		
		
		WorkpackageData pd = new WorkpackageData(ID, SC,hm);
	
		return pd;
	}
	
	public ArrayList<ProjectName> getProjectNames()
	{
		List<Project> list = SC.selectProjects();
		
		ArrayList<ProjectName> back = new ArrayList<>();
		
		for(Project temp : list)
		{
			back.add(new ProjectName(temp.getName(), temp.getId()));
		}
		
		return back;
	}
	
	
	
	public static void main(String... args)
	{
		Datenlieferant main = new Datenlieferant();
		StatementCreator sc = new StatementCreator();
		
		
		ProjectData test = main.getProject(sc.selectProjects().get(0).getId());
		
		test.getColor();
		
		
	}
}
