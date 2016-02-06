import java.util.ArrayList;
import java.util.List;


public class Observe {
	
	public static void main(String ...args)
	{
		Subject subject = new Subject();
		Obs obs = new Obs(subject);
		Obs1 obs1 = new Obs1(subject);
		subject.registerObserver(obs);
		subject.registerObserver(obs1);
		subject.setState(66);
	}

}

class Subject
{
	private int state;
	
	List<Observer> listObservers = new ArrayList<Observer>();
	
	public void registerObserver(Observer observer){
		listObservers.add(observer);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObserver();
	}
	
	public void notifyAllObserver(){
		for(Observer observer: listObservers){
			observer.notified();
		}
	}
	
}

abstract class Observer
{
	Subject subject; 
	public abstract void notified();
}

class Obs extends Observer
{
    Obs(Subject subject){
    	this.subject = subject;
    }
	@Override
	public void notified() {
		System.out.println("Obs"+subject.getState());
		
	}
	
}

class Obs1 extends Observer
{
	
	Obs1(Subject subject) {
		this.subject = subject;
	}
	@Override
	public void notified() {
		System.out.println("Obs1"+subject.getState());
		
	}
	
}

