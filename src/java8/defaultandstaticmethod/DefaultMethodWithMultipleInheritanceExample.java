package java8.defaultandstaticmethod;

import java.util.function.Consumer;
import java.util.function.Function;

interface SquareRootInterface
{
    // abstract method
    public void squareRoot(int a);
 
    // default method
    default void show()
    {
      System.out.println("Default Method of SquareRootInterface Executed");
    }
}
interface CubeRootInterface
{
    // abstract method
    public void cubeRoot(int a);
 
    // default method
    default void show()
    {
      System.out.println("Default Method of CubeRootInterface Executed");
    }
}
 
class RootImpl implements SquareRootInterface, CubeRootInterface
{
    // implementation of square abstract method
    public void show()
    {
        System.out.println("Inherited default");
        SquareRootInterface.super.show();
        CubeRootInterface.super.show();
    }

	@Override
	public void squareRoot(int a) {
		//System.out.println("Sqr root is : " + Math.sqrt(a));
		
		//using lambda
		Consumer<Integer> c = val -> System.out.println("Sqr root is : " + Math.sqrt(a));
		c.accept(a);
		
		// using Funtion , and also using method references
		Function<Integer, Double> c1 =  Math::sqrt;
		System.out.println("Sqr root is using fn : " + c1.apply(a));
	}
	
	@Override
	public void cubeRoot(int a) {
		//System.out.println("Cube root is : " + Math.cbrt(a));
		
		//using lambda
		Consumer<Integer> c = val -> System.out.println("Cube root is : " + Math.cbrt(a));
		c.accept(a);
		
		// using Funtion , and also using method references
		Function<Integer, Double> c1 =  Math::cbrt;
		System.out.println("Cube root is using fn : " + c1.apply(a));
		
	}
 
}
public class DefaultMethodWithMultipleInheritanceExample {

	public static void main(String[] args) {
		RootImpl d = new RootImpl();
        d.squareRoot(4);
        d.cubeRoot(27);
        
        System.out.println("-------------------------");
        // default method executed
        d.show();

	}

}

