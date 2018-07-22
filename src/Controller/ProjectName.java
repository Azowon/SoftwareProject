package Controller;

public class ProjectName {

	private long ID;
	private String name;
	
	public ProjectName(String name, long ID)
	{
		this.name = name;
		this.ID = ID;
	}
	
	public String getName() {
		return name;
	}
	public long getID() {
		return ID;
	}
	
}
