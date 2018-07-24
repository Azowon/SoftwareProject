package Controller;

public class Yellow extends State {

	double grenzwert = 0;
	
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
		{
			main.setCurrentState(main.getRed());
		}
			
		
	}
	
	public void setGrenzwert(double grenzwert) {
		this.grenzwert = grenzwert;
	}

}
