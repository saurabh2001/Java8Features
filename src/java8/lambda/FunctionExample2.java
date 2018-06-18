package java8.lambda;
import java.util.function.Function;
/*
 * Function functional interface represents an operation 
 * that accepts a single input argument and returns single result
 * 
 * */
public class FunctionExample2 {
	public static void main(String[] args) {
		
		// Following takes Integer as input and String as output
		Function<Integer, String> intToString = Object::toString;
		
		// Following takes String as input and String as output, (function adds the quote though)
		Function<String, String> appendQuotes = s -> "'" + s + "'";
		
		
		// compose method is used to combine two functions to execute back to back
		// First intToString will be applied and then appendQuotes
		Function<Integer, String> quoteIntToString = appendQuotes.compose(intToString);
		
		System.out.println(quoteIntToString.apply(44));
	}
}

