package java8.lambda;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import java8.model.Person;
/*
 * Function functional interface represents an operation 
 * that accepts a single input argument and returns single result
 * 
 * */
public class FunctionExample1 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Chandler", "Bing", 24), 
				new Person("Pheobe", "Buffey", 22),
				new Person("Rachel", "Green", 20), 
				new Person("Monica", "Geller", 21),
				new Person("Ross", "Geller", 28),
				new Person("Joe","Tribiani",26));

		// sort list by name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// printing all sorted elements
		printAll(people, p -> p.getFirstName() + "--" + p.getLastName());
	}

	public static void printAll(List<Person> people, Function<Person, Object> function) {
		for (Person p : people) {
			Object obj = function.apply(p);
			System.out.println(obj.toString());
		}
	}
}

