import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class PersonTest {
	
	public static void main(String ...args){
//		Map<Person, String> map = new HashMap<Person, String>();
//		Person p = new Person(1,"Kushagra");
//		Person p1 = new Person(2,"Kush");
//		map.put(p, "ok");
//		map.put(p1, "okkkk");
//		p = new Person(1,"Kushagra");
//		p1 = new Person(2,"Kush");
//		System.out.println(map.get(p));
//		System.out.println(map.get(p1));
		PersonTest personTest = new PersonTest();
//		personTest.sum(-1, 1);
		System.out.println(personTest.GetCubicRoot(81, 0, 81));
	}
	

	public void sum(int a, int b){
		assert a>0;
		assert b>0;
		System.out.println("hh");
	}
	
	public static double GetCubicRoot(double n, double low, double high) {
	    double cbrt = (low + high) / 2;
	    System.out.println(cbrt);
	    if (cbrt*cbrt*cbrt*cbrt > n)
	        return GetCubicRoot(n, low, cbrt);
	    if (cbrt*cbrt*cbrt*cbrt < n)
	        return GetCubicRoot(n, cbrt, high);
	    return cbrt;
	}

}


final class Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int id;
	private final String name;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		int result = 1;
		Random random = new Random();
		return 7;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	private void readObject(ObjectInputStream i){
		
	}
}