package java8.streams;
import java.util.Arrays;
import java.util.List;

import java8.model.Person;

public class StreamExample1 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Chandler", "Bing", 24), 
				new Person("Pheobe", "Buffey", 22),
				new Person("Rachel", "Green", 20), 
				new Person("Monica", "Geller", 21),
				new Person("Ross", "Geller", 28),
				new Person("Joe","Tribiani",26));
		
		// stream is like a conveyer belt, all the objects in the collection are 
		// sitting on the belt and coming in front of us
		people.stream().forEach(p-> System.out.println(p));
		
		//after filtering the rest of the objects move ahead in the conveyer belt
		System.out.println("Stream example of AND operation");
		people.stream()
		.filter(p->p.getFirstName().startsWith("A"))
		.filter(p->p.getLastName().startsWith("S"))
		.forEach(p-> System.out.println(p));
		
		//after filtering the rest of the objects move ahead in the conveyer belt
		System.out.println("Stream example of OR operation");
		people.stream()
		.filter(p->{
			return (p.getFirstName().startsWith("A")||p.getLastName().startsWith("S"));
		})
		.forEach(p-> System.out.println(p));
		
		//after filtering the rest of the objects move ahead in the conveyer belt
		System.out.println("Stream example count operation");
		long cnt = people.stream()
		.filter(p->{
			return (p.getFirstName().startsWith("A")||p.getLastName().startsWith("S"));
		})
		.count();
		System.out.println(cnt);
		
		/*
		 * count, for each are termination operations
		 * */
		
		System.out.println("Stream example count operation, using parallel streams");
		cnt = people.parallelStream()
		.filter(p->{
			return (p.getFirstName().startsWith("A")||p.getLastName().startsWith("S"));
		})
		.count();
		System.out.println(cnt);
		
		
	}

}
