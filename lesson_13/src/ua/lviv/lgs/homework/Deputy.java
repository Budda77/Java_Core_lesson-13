package ua.lviv.lgs.homework;

import java.util.Scanner;

public class Deputy extends Person{
	
	private String name;
	private int age;
	boolean briber;
	private int bribeAmount;
	private String factionName;
	
	public Deputy() {}
	
	public Deputy(int height, int weight, String name, int age, boolean briber, String factionName) {
		super(height, weight);
		this.name = name;
		this.age = age;
		this.briber = briber;
		this.factionName = factionName;
	}
	
	public Deputy(int height, int weight, String name, int age, boolean briber, int bribeAmount, String factionName) {
		super(height, weight);
		this.name = name;
		this.age = age;
		this.briber = briber;
		this.bribeAmount = bribeAmount;
		this.factionName = factionName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBriber() {
		return briber;
	}

	public void setBriber(boolean briber) {
		this.briber = briber;
	}

	public int getBribeAmount() {
		return bribeAmount;
	}

	public void setBribeAmount(int bribeAmount) {
		this.bribeAmount = this.bribeAmount + bribeAmount;
	}

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}
	
	@Override
	public String toString() {
		return "Deputy [Height= " + getHeight() + "cm, Weight= " + getWeight() + "kg, name= " + name + ", age= " + age + ", briber= " + briber
				+ ", bribe Amount= " + bribeAmount + ", faction= " + factionName + "]";
	}

	public void giveBribe() {

		if(isBriber() == false) {
			System.out.println("The deputy " + getName() + " age " + getAge() + " fraction " + getFactionName() + " does not take bribes.");
		} else {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Input amount of bribes for deputy - " + getName() + " age " + getAge() + " fraction " + getFactionName());
			int amount = sc.nextInt();
			if(amount > 5000) {
				
				System.out.println("The police will imprison the deputy " + getName() + " age " + getAge() + " fraction " + getFactionName());
			} else {
				setBribeAmount(amount);
				System.out.println("The total amount of the bribes is: " + getBribeAmount() );
			}
		}
		
		
		
	}
	

}
