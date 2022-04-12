package ua.lviv.lgs.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import ua.lviv.lgs.Student;

public class Faction {
	
	private List <Deputy> faction;  
	
	private static final int CAPACITY = 16;
	private String message = "The input data is wrong. Please, enter correct data.";
	
	public Faction() {
		super();
		faction = new ArrayList<>(CAPACITY);		
	}

	public void addDeputes(String nameOfFaction) {
	
		int height = getRandom(171,199);
		int weight = getRandom(60,110);
		String name = getRandomDeputy(getRandom(0,24));
		int age = getRandom(35,65);;
		boolean briber = setBribers();
		int bribeAmount = 0;
		if(briber == true) {
			bribeAmount = getRandom(0,100000);
		}
		String factionName = nameOfFaction;		
		faction.add(new Deputy(height, weight, name, age, briber, bribeAmount, factionName));
	}
	
	public void addDeputyConsole() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input height:");
		int height = sc.nextInt();
		System.out.println("Input weight:");
		int weight = sc.nextInt();
		System.out.println("Input name:");
		String name = sc.next();
		System.out.println("Input age:");
		int age = sc.nextInt();
		boolean briber = false;
		System.out.println("Input bribe amount :");
		int bribeAmount = sc.nextInt();
		if(bribeAmount > 0) {
			briber = true;
		}
		System.out.println("Input fraction:");
		String factionName = sc.next().toLowerCase();
		faction.add(new Deputy(height, weight, name, age, briber, bribeAmount, factionName));
	
	}

	public void removeDeputy(String name, String nameOfFaction){

		int tmp = 0;		
		Iterator <Deputy> iterator = faction.iterator();
		
		while(iterator.hasNext()) {
			Deputy next = iterator.next();
			if(next.getName().contains(name) && next.getFactionName().contains(nameOfFaction) && tmp == 0) {
				tmp++;
				System.out.println("The deputy " + next.getName() + " age " + next.getAge() + " from faction " + next.getFactionName() + " was removed.");
				iterator.remove();
			}
		}	
	}
	
	public void showAllbribers() {
		
		Iterator <Deputy> iterator = faction.iterator();		
		while(iterator.hasNext()) {			
			Deputy next = iterator.next();
			
			if(next.isBriber() == true) {
				System.out.println(next);
			}	
		}
	}
	
	public void showBribersOfFaction(String fraction) {
		Iterator<Deputy> iterator = faction.iterator();
		while(iterator.hasNext()) {
			Deputy next = iterator.next();
			if(next.isBriber() == true && next.getFactionName().contains(fraction)) {
				System.out.println(next);
			}
		}
	}
	
	public void showFaction(String fraction) {
		
		for (Deputy deputy : faction) {
			if(deputy.getFactionName().contains(fraction)) {
				System.out.println(deputy);
			}
		}
	}
		
	public void showAllDeputes() {
//		for (Deputy deputy : faction) {
//			System.out.println(deputy);
//		}
		
		// II option to show Deputy
		Iterator <Deputy> iterator = faction.iterator();
		while(iterator.hasNext()) {
			Deputy next = iterator.next();
			System.out.println(next);
		}		
	}
	
	public void removeAllDeputes(String fraction) throws WrongInputConsoleException {
		boolean flag = false;
		Iterator <Deputy> iterator = faction.iterator();
		while(iterator.hasNext()) {
			Deputy next = iterator.next();
			if(next.getFactionName().contains(fraction)) {
				iterator.remove();		
				flag = true;
			} 					
		}
		if(flag) {
			System.out.println("Fraction " + fraction + " was removed.");			
		} else {
			throw new WrongInputConsoleException(message);
		}
	}

	public void theBiggestBriber(){
		
		int maxAmount =0;
		String biggestBriber = "";
			// option One
//		for (Deputy deputy : faction) {		
//			if(deputy.getBribeAmount() > maxAmount) {
//				maxAmount = deputy.getBribeAmount();
//				biggestBriber = deputy.getName();			
//			}
//		}		
			// option Two
		Iterator <Deputy> iterator = faction.iterator();
		while(iterator.hasNext()) {
			Deputy next = iterator.next();
			if(next.getBribeAmount() > maxAmount) {
				maxAmount = next.getBribeAmount();
				biggestBriber = next.getName();	
			}
		}
		System.out.println("The deputy - " + biggestBriber + " with amount of the bribe - " + maxAmount);
	}
	
	
	public static int getRandom(int min, int max) {
		
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
	
	public static String getRandomDeputy(int id) {
		
		String [] deputes = {"Piter", "Sophi", "Ivan", "Mykola", "Pavlo", "Marichka", "Andrew", "Polina", "Joseph", "Vasylyna", "Anna", "Adam",
							"Avrram", "Alisa", "Borys", "Bogdan", "Ulyana", "Viktor", "Kyra", "David", "Evgen", "Mariya", "Luka", "Alex", "Eva"};		
		String deputyName = deputes[id];		
		return deputyName;
	}
	
	public boolean setBribers() {
		boolean [] isBriber = {true, false};	
		return isBriber[getRandom(0, 1)];
	}
	
	public void offerBribe(String name, String fraction) {
		
		int count = 0;
			for (Deputy deputy : faction) {
				if(deputy.getName().contains(name) && deputy.getFactionName().contains(fraction) && count == 0) {
					count++;
					deputy.giveBribe();
				} 
			}
		}
		
		
		
}
