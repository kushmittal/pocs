
public class Facade {
	
	public static void main(String ...args)
	{
		FacadeImp facadeImp = new FacadeImp();
		facadeImp.drawCircle();
		facadeImp.drawRect();
	}
	
	public Facade() {
		
	}
	
	
}

class FacadeImp
{
	private Shape circle;
	private Shape rect;

	public FacadeImp()
	{
		circle = new Circle();
		rect = new Rectangle();
	}
	
	public void drawCircle()
	{
		circle.draw();
	}
	
	public void drawRect()
	{
		rect.draw();
	}
}

//interface Shape {
//	public void draw();
//}
//
//class Circle implements Shape {
//
//	@Override
//	public void draw() {
//		System.out.println("Circle");
//
//	}
//
//}
//
//class Triangle implements Shape {
//
//	@Override
//	public void draw() {
//		System.out.println("Triangle");
//
//	}
//
//}
//
//class Rectangle implements Shape {
//
//	@Override
//	public void draw() {
//		System.out.println("Rectangle");
//
//	}
//
//}
