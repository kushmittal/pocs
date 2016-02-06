import java.util.Iterator;
import java.util.NoSuchElementException;


public class StackImplementation<T> implements Iterable<T> {
	
	private int n;  // Size
	private Node first;
	
	private class Node
	{
		private T item;
		private Node next;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T>
	{

		@Override
		public boolean hasNext() {
			return first != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if (!hasNext()) throw new NoSuchElementException();
			T node = first.item;
			first = first.next;
			return node;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public StackImplementation()
	{
		first = null;
	}
	
	public int getSize()
	{
		return n;
	}
	
	public void push(T item)
	{
		Node oldNode = first;
		first = new Node();
		first.item = item;
		first.next = oldNode;
		n++;
	}
	
	public T pop()
	{
		T item = first.item;
		first = first.next;
		n--;
		return item;
	}
	
	public static void main(String ...args)
	{
		StackImplementation<Item> stackImplementation = new StackImplementation<Item>();
		Item item = new Item();
		item.setValue(9);
		stackImplementation.push(item);
		stackImplementation.push(item);
		stackImplementation.push(item);
		stackImplementation.push(item);
		System.out.println(stackImplementation.n);
		Iterator it = stackImplementation.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		stackImplementation.pop();
		System.out.println(stackImplementation.n);
		Iterator it2 = stackImplementation.iterator();
		while(it2.hasNext())
		{
			System.out.println(it2.next());
		}
	}
	
	private static class Item
	{
		private int value;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}
	
}
