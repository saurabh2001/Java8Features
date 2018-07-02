package java8.streams;
import java.util.Arrays;
import java.util.List;

import java8.model.Person;

public class StreamExample3 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12,20,35,55,58);
		
		// before map method 1 2 3 4 5 6
		// after filter method 20 35 55
		// after reduce 20+35+55 = 110
		Integer sum = list.stream().
					filter(a->{return (a%5==0);} )
					.reduce(Integer::sum).get();
		
		System.out.println(sum);
		
		// lets do sum after doubling the %5 values
		 sum = list.stream()
				.map(i->i*2)
				.filter(a->{return (a%5==0);} )
				.reduce(Integer::sum).get();
	
		 System.out.println(sum);
		
		// find first element in the list
		Integer first = list.stream()
					.map(i->i*2)
					.filter(a->{return (a%5==0);} )
					.findFirst().get();
		
			 System.out.println(first);
		
			  first = list.stream()
						.map(i->i*2)
						.filter(a->{return (a%59==0);} )
						.findFirst().orElse(-1);
			  System.out.println(first);
	}

}
