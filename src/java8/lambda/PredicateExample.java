package java8.lambda;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import java8.model.Person;
/*
 * Predicate functional interface takes one object input and returns the  boolean
 * 
 * */
public class PredicateExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Chandler", "Bing", 24), 
				new Person("Pheobe", "Buffey", 22),
				new Person("Rachel", "Green", 20), 
				new Person("Monica", "Geller", 21),
				new Person("Ross", "Geller", 28),
				new Person("Joe","Tribiani",26));

		// sort list by name
		Collections.sort(people,( p1, p2)-> p1.getLastName().compareTo(p2.getLastName()));
		
		// printing  first name starting with R
		System.out.println("------printing  first name starting with R-------");
		printConditionally(people, p-> p.getFirstName().startsWith("R"));
		
		// printing  last name starting with G
		System.out.println("------printing  last name starting with G-------");
		printConditionally(people, p-> p.getLastName().startsWith("G"));

		// printing  all elements
		System.out.println("------printing  all-------");
		printConditionally(people, p-> true);
	}
	
	public static void printConditionally(List<Person> people, Predicate<Person> predicate) {
		for (Person p : people) {
			if(predicate.test(p))
			{
				System.out.println(p);
			}
		}
	}

}
