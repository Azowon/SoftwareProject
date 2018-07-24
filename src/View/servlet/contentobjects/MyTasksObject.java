package View.servlet.contentobjects;

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
	
	public void addTask(String status, String taskName, long taskId) {
		String taskStart = "<tr>";
		String taskEnd = "</tr>";
		
		String s = "<td>" + status + "</td>";
		String t = "<td>" + "<a href='/SoftwareProject/TaskServlet?id="+taskId+"'>" +taskName + "</a></td>";
		
		myTasks += taskStart + s + t + taskEnd;
	}
}
