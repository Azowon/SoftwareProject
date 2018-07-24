package Controller;
import java.util.List;

import Model.*;

public class Heatmap {

	double grenzwert = 0;
	double aufwand = 0;
	
	int grenzwertGrün, grenzwertGelb;
	
	Green s1 = new Green(this);
	Yellow s2 = new Yellow(this);
	Red s3 = new Red(this);
	State currentState = s1;
	
	
	
	public void setAufwand(double aufwand) {
		this.aufwand = aufwand;
		currentState.checkForNextState();
		currentState.checkForNextState();
		//System.out.println("Der Aufwand wurde auf " + aufwand + " gesetzt!");
	}
	public double getAufwand() {
		return aufwand;
		
	}
	
	public void setGrenzwerte(double grenzwertG, double grenzwertY)
	{
		s1.setGrenzwert(grenzwertG);
		s2.setGrenzwert(grenzwertY);
	}

	
	public Heatmap(double grenzwertGrün, double grenzwertGelb)
	{
		setGrenzwerte(grenzwertGrün, grenzwertGelb);
		
	}
	

	
	

	
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	
	public String drawMap()
	{
		return currentState.drawHeatmap();
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
