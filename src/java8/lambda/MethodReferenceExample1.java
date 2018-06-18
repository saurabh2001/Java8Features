package java8.lambda;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import java8.model.Person;

public class MethodReferenceExample1 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Chandler", "Bing", 24), 
				new Person("Pheobe", "Buffey", 22),
				new Person("Rachel", "Green", 20), 
				new Person("Monica", "Geller", 21),
				new Person("Ross", "Geller", 28),
				new Person("Joe","Tribiani",26));

		// create method that prints all person with some condition
		System.out.println("\nPrinting all person Using Predicate and Consumer Interface");
		performConditionally(people, p -> true, p -> System.out.println(p.toString()));
		
		System.out.println("----------------------------------");
		//using method reference
		performConditionally(people, p -> true, System.out::println);

	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person p : people) {
			if (predicate.test(p))
				consumer.accept(p);
		}

	}
}
