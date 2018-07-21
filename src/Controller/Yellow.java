package Controller;

public class Yellow extends State {

	int grenzwert = 0;
	
	Yellow(Heatmap main) {
		super(main);
		
	}

	@Override
	public String drawHeatmap() {
		return "yellow";
		
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
