package Controller;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class main {

	int grenzwert = 0, aufwand = 0;
	
	int grenzwertGrün, grenzwertGelb;
	
	Green s1 = new Green(this);
	Yellow s2 = new Yellow(this);
	Red s3 = new Red(this);
	State currentState = s1;
	
	
	
	public void setAufwand(int aufwand) {
		this.aufwand = aufwand;
		currentState.checkForNextState();
		System.out.println("Der Aufwand wurde auf " + aufwand + " gesetzt!");
	}
	public int getAufwand() {
		return aufwand;
		
	}
	
	public void setGrenzwerte(int grenzwertG, int grenzwertY)
	{
		s1.setGrenzwert(grenzwertG);
		s2.setGrenzwert(grenzwertY);
	}

	
	public main(int grenzwertGrün, int grenzwertGelb)
	{
		setGrenzwerte(grenzwertGrün, grenzwertGelb);
		
	}
	
	public static void main(String... args)
	{
		main Heatmap = new main(50,80);

		Heatmap.setAufwand(20);
		Heatmap.setAufwand(40);
		Heatmap.drawMap();
		Heatmap.setAufwand(60);
		Heatmap.drawMap();
		Heatmap.setAufwand(90);
		Heatmap.drawMap();
	}
	
	

	
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	
	public void drawMap()
	{
		currentState.drawHeatmap();
	}
	
	public State getGreen()
	{
		return s1;
	}
	public State getYellow()
	{
		return s2;
	}
	public State getRed()
	{
		return s3;
	}
}
