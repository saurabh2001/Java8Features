package java8.defaultandstaticmethod;

interface CubeInterface
{
    // abstract method
    public void cube(int a);
 
    // static method
    static void show()
    {
      System.out.println("Static Method Executed");
    }
}
 
class CubeImpl implements CubeInterface
{
    // implementation of square abstract method
    public void cube(int a)
    {
        System.out.println(a*a*a);
    }
 
}
public class StaticMethodInInterfaceExample {

	public static void main(String[] args) {
		CubeImpl d = new CubeImpl();
        d.cube(4);
 
        // default method executed
        CubeInterface.show();

	}

}
