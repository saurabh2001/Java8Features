package java8.lambda;

public class TypeInferenceExample {

	public static void main(String[] args) {
		ILength ilength = str -> str.length();

		// instead of this
		System.out.println(ilength.len("SaurabhShah"));

		// you can do this, we can pass the method to be referred by Interface
		// which is parameterized in method
		printData(str -> str.length());

	}

	public static void printData(ILength l) {
		System.out.println(l.len("Hello Saurabh"));

	}

	// @FunctionalInterface annotation restrict the addition of abstract method
	// in the interface
	@FunctionalInterface
	interface ILength {
		int len(String s);
	}

}