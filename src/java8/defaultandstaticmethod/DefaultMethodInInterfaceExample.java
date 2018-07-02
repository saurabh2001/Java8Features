package java8.defaultandstaticmethod;

interface TestInterface
{
    // abstract method
    public void square(int a);
 
    // default method
    default void show()
    {
      System.out.println("Default Method Executed");
    }
}
 
class TestImpl implements TestInterface
{
    // implementation of square abstract method
    public void square(int a)
    {
        System.out.println(a*a);
    }
 
}
public class DefaultMethodInInterfaceExample {

	public static void main(String[] args) {
		TestImpl d = new TestImpl();
        d.square(4);
 
        // default method executed
        d.show();

	}

}
