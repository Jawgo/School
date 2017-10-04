import java.util.EmptyStackException;
/**
 * This class uses a linked list to simulate a Stack
 * @author Josh
 *
 */
public class ListBasedStack {

	private ReversibleLinkedList<Character> list;
	private int size;

	public ListBasedStack(){
		size = 0;
		list = new ReversibleLinkedList<Character>();
	}
	

	/**
	 * Adds the char 'x' to the top of the stack
	 * @param x the character to be added to the stack
	 */
	public void push(char x){
		size++;
		list.addFirst(x);
	}
	

	/**
	 * @throws EmptyStackException if the stack is empty
	 * @return the top value of the stack if it exists
	 */
	public char peek(){
		if(isEmpty()) throw new EmptyStackException();
		return list.showHead();
	}
	
	/**
	 * Removes the top value of the Stack
	 * @throws EmptyStackException if the Stack is empty
	 * @return the character that was removed if it exists
	 */
	public char pop(){
		if(isEmpty()) throw new EmptyStackException();
		char x = list.showHead();
		list.removeFirst();
		size--;
		return x;
	}
	
	/**
	 * Determines if the Stack is empty or not
	 * @return true if the stack has a size 0
	 */
	public boolean isEmpty(){
		return (size == 0);
	}
	
}
