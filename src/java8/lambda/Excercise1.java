package java8.lambda;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import java8.model.Person;

public class Excercise1 {

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

		// create method that prints all sorted elements
		printAll(people);

		// create method that prints all person with last name starting with G
		printLastNameStartWith(people);
		

		// create method that prints all person with some condition
		System.out.println("\n------Printing all person last name starting with G------");
		printConditionally(people, p -> p.getLastName().startsWith("G"));

		System.out.println("\n------Printing all person first name  starting with J------");
		printConditionally(people, p -> p.getFirstName().startsWith("J"));
		
		// create method that prints all person with some condition, using consumer
		System.out.println("\n------Printing person starting with R Using Consumer Interface------");
		performConditionally(people, p -> p.getFirstName().startsWith("R"),
				 							p -> System.out.println(p));
		
		
		System.out.println("\n------Printing all person Using Consumer Interface------");
		performAll(people, p -> System.out.println(p.toString()));
		
	}

	public static void printAll(List<Person> people) {
		System.out.println("------In printAll method----------");
		for (Person p : people) {
			System.out.println(p);
		}
	}

	public static void printLastNameStartWith(List<Person> people) {
		System.out.println("\n------In printLastNameStartWith method(without using FI)----------");
		for (Person p : people) {
			if(p.getLastName().startsWith("G"))
			System.out.println(p);
		}
	}

	public static void printConditionally1(List<Person> people, Condition condition) {
		for (Person p : people) 
		{
			if(condition.test(p))
			{
				System.out.println(p);
			}
		}
	}
	
	public static void printConditionally(List<Person> people, Predicate<Person> predicate) {
		for (Person p : people) 
		{
			if(predicate.test(p))
			{
				System.out.println(p);
			}
		}
	}
	
	private static void performAll(List<Person> people, Consumer<Person> consumer) {
		for (Person p : people) {
			consumer.accept(p);
		}
		
	}
	
	private static void performConditionally(List<Person> people,Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person p : people) 
		{
			if(predicate.test(p))
			{
				consumer.accept(p);
			}
		}
		
	}

	
// we are defining a functional interface and using it, but there are such interfaces which 
// are provided by java 8 which we can use directly
// function analogous to Condition is Predicate	
@FunctionalInterface
interface Condition {

	boolean test(Person p);
}
}
