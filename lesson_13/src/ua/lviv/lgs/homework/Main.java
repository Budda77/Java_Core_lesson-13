/*
 * LOGOS It Academy test file
 * 
 * */

package ua.lviv.lgs.homework;

/**
 * @since java 1.8
 * @author Oleksandr
 * @version 1.1
 * */

//import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws WrongInputConsoleException{
		
		/**
		 * @param input parameters is Object
		 * @exception no one
		 * */
		
		Rada rada = Rada.getInstance("Rada I");
		Rada rada2 = Rada.getInstance("Verhovna Rada II");
		
		//String message = "The input data is wrong. Please, enter correct data.";
		// Check of creation Singletons
		System.out.println(rada.mainRada);
		System.out.println(rada2.mainRada);
		
		Scanner number = new Scanner(System.in);
		 
		while(true) {

			menu();

			switch(number.nextInt()) {

			case 1:{
				System.out.println("Enter fraction to add in Rada:");
				Scanner fraction1 = new Scanner(System.in);
				String fractionName = fraction1.nextLine();

				int numberOfDeputy = 5 +(int)(Math.random()*15);
				int tmp = 0;
				for(int i = 0; i < numberOfDeputy; i++) {
					rada.addFractions(fractionName);
					tmp++;
				}
				System.out.println("The fraction consist of " + tmp + " deputes\n");

				break;
			}

			case 2:{
				System.out.println("Enter the faction name to remove: ");
				Scanner fraction2 = new Scanner(System.in);
				String frac2 = fraction2.nextLine();

				if(!frac2.isEmpty()) {
					rada.removeFaction(frac2);

				} else {
					System.out.println("Please, enter the name of fraction.");
				}

				break;
			}
			
			case 3:{
				System.out.println("The list of deputes in fraction:\n");
				rada.showAllFraction();
				
				break;
			}
			
			case 4:{
				System.out.println("Enter the faction name to show all deputes: ");
				Scanner fraction3 = new Scanner(System.in);
	
				String frac3 = fraction3.nextLine();
				
				if(!frac3.isEmpty()) {
				rada.showTheFraction(frac3);
				} else {
					System.out.println("Please, enter the name of fraction.");
				}
				
				break;
			}
			
			case 5:{
				System.out.println("Registere deputy in the fraction:");
				rada.addOneDeputy();
				break;
			}
			
			case 6:{
				System.out.println("The remove deputy from the fraction.");
				System.out.println("Input name:");
				Scanner deputyName = new Scanner(System.in);
				String name = deputyName.nextLine();
				System.out.println("Input fraction:");
				Scanner fraction4 = new Scanner(System.in);
				String frac4 = fraction4.nextLine();
				
				if(!frac4.isEmpty() && !name.isEmpty()) {
					rada.removeOneDeputy(name, frac4);
				} else {
					System.out.println("Please, enter correct data");
				}		
				
				break;
			}
			
			case 7:{
				System.out.println("The list of briber deputy:\n");
				rada.presentBribers();
				break;
			}
			
			case 8:{
				System.out.println("The biggest bribery is:\n");
				rada.showTheBiggestBriber();
				break;
			}
			
			case 9:{
				System.out.println("Propose a brabe to the deputy name:");

				Scanner deputyName2 = new Scanner(System.in);
				String str = deputyName2.nextLine();
				System.out.println("Please input the deputy fraction:");
				Scanner fraction5 = new Scanner(System.in);
				String str2 = fraction5.nextLine();

				if(!str.isEmpty()) {
					rada.giveBribe(str, str2);				
				} else {
					System.out.println("Please, inpute name.");
				}


				break;
			}
			}		
		}	
	}
	
		
	static void menu() {
		System.out.println("\nEnter 1 to add a faction");
		System.out.println("Enter 2 to remove the faction");
		System.out.println("Enter 3 to show all factions");
		System.out.println("Enter 4 to show a specific faction");
		System.out.println("Enter 5 to add a deputy to the faction");
		System.out.println("Enter 6 to remove the deputy from the faction");
		System.out.println("Enter 7 to display the list of bribers");
		System.out.println("Enter 8 to display the bigest bribers");
		System.out.println("Enter 9 to give a bribe");
	}	

}
