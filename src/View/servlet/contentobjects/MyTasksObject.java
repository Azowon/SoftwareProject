package servlet.contentobjects;

public class MyTasksObject {
	private String myTasks = "";
	
	public MyTasksObject() {
		
	}
	
	public void setMyTasks(String myTasks) {
		this.myTasks = myTasks;
	}
	
	public String getMyTasks() {
		return myTasks;
	}
	
	public void addTask(String status, String taskName) {
		String taskStart = "<tr>";
		String taskEnd = "</tr>";
		
		String s = "<td>" + status + "</td>";
		String t = "<td>" + taskName + "</td>";
		
		myTasks += taskStart + s + t + taskEnd;
	}
}
