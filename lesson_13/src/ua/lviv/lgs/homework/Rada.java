package ua.lviv.lgs.homework;


//import java.util.Iterator;
//import java.util.List;

public class Rada {
	
	private static Rada instance;
	
	Faction faction = new Faction();
	public String mainRada;	
	private Rada(String mainRada) {
		this.mainRada = mainRada;
	}
	
	public static Rada getInstance(String mainRada) {
		if(instance == null) {
			instance = new Rada(mainRada);
		}
		return instance;
	}
	
	public void addFractions(String nameOfFaction) {
		faction.addDeputes(nameOfFaction);
	}
	
	public void removeFaction(String fraction) {
		try {
			faction.removeAllDeputes(fraction);
		} catch (WrongInputConsoleException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void showAllFraction() {		
		faction.showAllDeputes();		
	}
		
	public void showTheFraction(String fraction) {
		faction.showFaction(fraction);
	}

	public void addOneDeputy() {
		faction.addDeputyConsole();
	}
	
	public void removeOneDeputy(String name, String nameOfFaction) {
		faction.removeDeputy(name, nameOfFaction);
	}
	
	public void presentBribers() {
		faction.showAllbribers();
	}
	
	public void presentBribersFraction(String fraction) {
		faction.showBribersOfFaction(fraction);
	}
	
	public void showTheBiggestBriber() {
		faction.theBiggestBriber();
	}
	
	public void giveBribe(String name, String fraction) {
		faction.offerBribe(name, fraction);
	}
	
	

}
