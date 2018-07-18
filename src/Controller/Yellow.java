package Controller;

public class Yellow extends State {

	int grenzwert = 0;
	
	Yellow(main main) {
		super(main);
		
	}

	@Override
	public void drawHeatmap() {
		System.out.println("Jetzt wird die Heatmap gelb dargestellt");
		
	}

	@Override
	public void checkForNextState() {
		if(main.getAufwand() >= grenzwert)
			main.setCurrentState(main.getRed());
		
	}
	
	public void setGrenzwert(int grenzwert) {
		this.grenzwert = grenzwert;
	}

}
