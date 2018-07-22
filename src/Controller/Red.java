package Controller;

public class Red extends State {

	Red(Heatmap main) {
		super(main);
		
	}

	@Override
	public String drawHeatmap() {
		
		return "red";
		
	}

	@Override
	public void checkForNextState() {
		// Methode wird aufgerufen
		
	}

}
