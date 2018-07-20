package View.servlet.contentobjects;

public class NavigationBarObject {
	private String LOGO_PATH = "";
	private String projectContent = "";
	
	public NavigationBarObject() {
		LOGO_PATH = "/img/LOGO.png";
	}
	
	public String getLogoPath() {
		return LOGO_PATH;
	}
	
	public String getProjectContent() {
		return projectContent;
	}
	
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}
	
	public void addProjectContent(String path, String name) {
		String buttonStart = "<form action='" + path + "' method='post'><button class='dropped-button'>";
		String buttonEnd = "</button></form>";
		
		projectContent += buttonStart + name + buttonEnd;
	}
}
