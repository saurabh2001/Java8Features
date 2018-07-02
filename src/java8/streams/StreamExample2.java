package java8.streams;
import java.util.Arrays;
import java.util.List;

import java8.model.Person;

public class StreamExample2 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		
		// before map method 1 2 3 4 5 6
		// after map method 2 4 6 8 10
		// after reduce 0+2+4+6+8+10 = 42
		list.stream().map(i->i*2).forEach(System.out::println);
		
		System.out.println(list.stream().map(i->i*2).reduce(0,(c,e)->c+e));
		System.out.println(list.stream().map(i->i*2).reduce(0,(c,e)->Integer.sum(c, e)));
		System.out.println(list.stream().map(i->i*2).reduce(0,Integer::sum));
		
		
		
		
	}

}
