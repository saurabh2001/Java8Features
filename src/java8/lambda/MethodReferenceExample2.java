package java8.lambda;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import java8.model.Person;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Chandler", "Bing", 24), 
				new Person("Pheobe", "Buffey", 22),
				new Person("Rachel", "Green", 20), 
				new Person("Monica", "Geller", 21),
				new Person("Ross", "Geller", 28),
				new Person("Joe","Tribiani",26));

		// way 1 , using for loop
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		
		System.out.println("----------------------------------");
		// way 2, using foreach loop
		for(Person person : people)
		{
			System.out.println(person);
		}
		
		System.out.println("----------------------------------");
		//using lambda foreach method
		people.forEach(p-> System.out.println(p));
		
		System.out.println("----------------------------------");
		// OR //using lambda foreach method, and method reference
		people.forEach(System.out::println);
		
	}

	
}
