package Controller;

public class Green extends State {

	int grenzwert  = 0;
	
	Green(main main) {
		super(main);
		
	}

	@Override
	public void drawHeatmap() {
		System.out.println("Jetzt wird die Heatmap grün dargestellt");
		
	}

	@Override
	public void checkForNextState() {
		if(main.getAufwand() >= grenzwert)
			main.setCurrentState(main.getYellow());		
	}
	
	public void setGrenzwert(int grenzwert) {
		this.grenzwert = grenzwert;
	}
	
	

}
