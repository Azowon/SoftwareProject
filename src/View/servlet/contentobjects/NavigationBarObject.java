package View.servlet.contentobjects;

public class NavigationBarObject {
	private String LOGO_PATH = "";
	private String projectContent = "";
	private String heatmapContent = "";
	
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
	
	public String getHeatmapContent() {
		return heatmapContent;
	}
	
	public void setHeatmapContent(String heatmapContent) {
		this.heatmapContent = heatmapContent;
	}
	
	public void addHeatmapContent(String path, String name) {
		String buttonStart = "<form action='" + path + "' method='post'><button class='dropped-button'>";
		String buttonEnd = "</button></form>";
		
		heatmapContent += buttonStart + name + buttonEnd;
	}
}
