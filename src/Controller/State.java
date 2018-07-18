package Controller;

public abstract class State {

	main main;
	
	State(main main)
	{
		this.main = main;
		
	}
	
	public abstract void drawHeatmap();
	
	public abstract void checkForNextState();
	
}
