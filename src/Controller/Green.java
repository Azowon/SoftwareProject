package Controller;

public class Green extends State {

	double grenzwert  = 0;
	
	Green(Heatmap main) {
		super(main);
		
	}

	@Override
	public String drawHeatmap() {
		return "green";
		
	}

	@Override
	public void checkForNextState() {
		if(main.getAufwand() >= grenzwert)
		{
			main.setCurrentState(main.getYellow());
		}
					
	}
	
	public void setGrenzwert(double grenzwert) {
		this.grenzwert = grenzwert;
	}
	
	

}
