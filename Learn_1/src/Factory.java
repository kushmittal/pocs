public class Factory {

	
	public static void main(String ...args)
	{
		Shape shape = FactoryImp.getInstance("Circle");
		shape.draw();
	}
}

interface Shape {
	public void draw();
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle");

	}

}

class Triangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Triangle");

	}

}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle");

	}

}

class FactoryImp {

	public static Shape getInstance(String type) {
		if ("Circle".equalsIgnoreCase(type)) {
				return new Circle();
		} else if ("Triangle".equalsIgnoreCase(type)) {
				return new Triangle();
		} else if ("Rectangle".equalsIgnoreCase(type)) {
				return new Rectangle();
		} else {
			return null;
		}
	}

}
