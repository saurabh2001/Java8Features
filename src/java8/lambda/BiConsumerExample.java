package java8.lambda;

import java.util.function.BiConsumer;
/*
 * BiConsumer functional interface represents an operation 
 * that accepts two input arguments and returns no result
 * 
 * */
public class BiConsumerExample {
	
	public static void main(String[] args) {
	
		// BiConsumer FI takes Integer,String as input and return void
	BiConsumer<Integer, String> IdAndName = (a,b)-> System.out.println(a.toString() + "--" + b);
			
	IdAndName.accept(1,"Sau");

}
}