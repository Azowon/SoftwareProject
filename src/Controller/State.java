package Controller;

public abstract class State {

	Heatmap main;
	
	State(Heatmap main)
	{
		this.main = main;
		
	}
	
	public abstract String drawHeatmap();
	
	public abstract void checkForNextState();
	
}
