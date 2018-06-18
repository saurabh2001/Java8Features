package java8.lambda;

public class Lambda {

	public static void main(String[] args) {
		int result = 0, len = -1 ;
		
		// myLambda not taking any input nor returning
		myLambda myLambdaFunction = () -> System.out.println("Hi");
		myLambdaFunction.printMessage();
		
		Iadd addFunction = (int a , int b) -> { return (a+b); };
		result = addFunction.add(3, 4);
		System.out.println("Result of addition is : "+ result);
		
		ILength ilengtha = (String str) -> { return str.length(); };
		len = ilengtha.len("SaurabhShah");
		System.out.println("Length of SaurabhShah is : "+ len);
		
		
		// Lets see different and compact ways to define the lambda function
		addFunction = (int a , int b) -> { return (a+b); };
		
		//no need return statement and curly braces if only one statement
		ILength ilengthc = (String str) -> str.length();
		Iadd addFunctionc = (int a , int b) -> a+b;
		
		// no need of Data type in parameter, it  identifies from interface
		ILength ilengthd = (str) -> str.length(); 
		Iadd addFunctiond = (a , b) -> a+b;
		
		// Following is the shortest way to define the lambda function
		ILength ilengthShortedWay = str -> str.length(); 
		
		// Following not allowed when we have multiple parameters
		//Iadd addFunctione = a,b -> a+b; // Note: This will not work
		
		System.out.println("Length of SaurabhShah is, using shortest way : "
											+ ilengthShortedWay.len("SaurabhShah"));
	}

}

// @FunctionalInterface annotation restrict the addition of abstract method in the interface
@FunctionalInterface
interface myLambda {
	
	// This is called as functional interface as this will have only one abstract method to be used by lambda function
	// food method not taking any input not returning any
	void printMessage();
}

@FunctionalInterface
interface  Iadd{
	// add method taking 2 int input and returning int as output
	int add(int a , int b);
}

@FunctionalInterface
interface  ILength{
	// len method taking 1 String input and returning int as output
	int len(String s);
}