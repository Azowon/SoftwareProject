package Controller;

public class Red extends State {

	Red(main main) {
		super(main);
		
	}

	@Override
	public void drawHeatmap() {
		System.out.println("Jetzt wird die Heatmap rot dargestellt");
		
	}

	@Override
	public void checkForNextState() {
		// Methode wird aufgerufen
		
	}

}
