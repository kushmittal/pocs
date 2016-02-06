import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Prototype{

	public static void main(String ...args)
	{
		Circles circles = new Circles();
//		ArrayList<Integer> listInt = new ArrayList<Integer>();
//		listInt.add(11);
//		listInt.add(12);
		//circles.setCoordinates(listInt);
		circles.setId(1111);
		circles.setType("circle");
		Circles circles2 = (Circles) circles.clone();
		System.out.println(circles2.getClass());
		PrototypeDemo.loadCache();
		Circles circle1=(Circles)PrototypeDemo.getShape(1);
		Circles circle2=(Circles)PrototypeDemo.getShape(1);
		circle1.setId(1);
		circle2.setId(2);
		User user=new User();
		
		circle1.addCoordinates(user);
		
		 User user1=new User();
        
        circle2.addCoordinates(user1);
		System.out.println(circle1.getCoordinates().size());
		System.out.println(circle2.getCoordinates().size());
		
		
	}
}

class PrototypeDemo
{
  private static Map<Integer,Shapes> maps = new HashMap<Integer, Shapes>();
  
  public static Shapes getShape(int id)
  {
    return maps.get(id).clone();
  }
  
  public static void loadCache()
  {
    User user = new User();
    user.setId(11);
    ArrayList<User> listInt = new ArrayList<User>();
    listInt.add(user);
    listInt.add(user);
    Circles circles = new Circles();
    circles.setId(1);
    //circles.setCoordinates(listInt);
    circles.setArray(new User[]{user});
    maps.put(1, circles);
    Rectangles rectangles = new Rectangles();
    rectangles.setId(2);
   // rectangles.setCoordinates(listInt);
    rectangles.setArray(new User[]{user});
    maps.put(2, rectangles);
  }
}


abstract class Shapes implements Cloneable
{
	public int id;
	public String type;
	public ArrayList<User> coordinates=new ArrayList<>();;
	public User[] array;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void addCoordinates(User user)
	{
	  coordinates.add(user);
	}
	public ArrayList<User> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(ArrayList<User> coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public Shapes clone(){
		Shapes clone = null;
		try {
			clone = (Shapes) super.clone();
			clone.coordinates = (ArrayList<User>) coordinates.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clone;
		
	}
	
	public abstract void draw();
  /**
   * @return the array
   */
  public User[] getArray()
  {
    return array;
  }
  /**
   * @param array the array to set
   */
  public void setArray(User[] array)
  {
    this.array = array;
  }
}

class Circles extends Shapes
{

	@Override
	public void draw() {
		System.out.println("circle");
		
	}
	
}

class Rectangles extends Shapes
{

	@Override
	public void draw() {
		System.out.println("rectangle");
		
	}
	
}

class User
{
  private int id;

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }
}


interface ICarElementVisitor {
  void visit(String wheel);
  void visit(int engine);
  void visit(long body);
  void visit(double car);
}

