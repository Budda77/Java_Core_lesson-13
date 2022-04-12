package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentSorting {

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(2, "Peter", 23));
		students.add(new Student(1, "Andrew", 33));
		students.add(new Student(2, "Alexandro", 33));
		students.add(new Student(2, "Alexandro", 47));
		students.add(new Student(2, "Alexandro", 47));
		students.add(new Student(3, "Levan", 19));
		students.add(new Student(5, "Pavlo", 42));
		students.add(new Student(4, "Joseph", 55));

		System.out.println("Befor sorting:");
		for (Student student : students) {
			System.out.println(student);
		}
		
		//Sort using Comparable
	/*	Collections.sort(students);
		
		System.out.println("\nAfter sorting:");
		for (Student student : students) {
			System.out.println(student);
		}
		*/
		
		//Sort using Comparator by age
		//Collections.sort(students, new StudentAgeComparator());
		
		//Sort using Comparator by name
		//Collections.sort(students, new StudentNameComparator());
		
		//Sort using AllName Comparator 
		Collections.sort(students, new StudentNameComparator());
		
		System.out.println("\n sorting with Comparator:");
		for (Student student : students) {
			System.out.println(student);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
