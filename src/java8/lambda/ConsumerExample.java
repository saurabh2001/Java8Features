package java8.lambda;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import java8.model.Person;
/*
 * Consumer functional interface represents an operation 
 * that accepts a single input argument and returns no result
 * 
 * */
public class ConsumerExample {

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
		
		// printing  all sorted elements
		printAll(people, p-> System.out.println(p.toString()));
	}
	
	
	
	private static void printAll(List<Person> people, Consumer<Person> consumer) {
		for (Person p : people) {
			consumer.accept(p);
		}
		
	}

}
