import java.util.NoSuchElementException;

/**
 * Implements the Cpsc331LinkedList interface.
 * Reverses the linked list and well as other Linked List methods
 * @author Josh Schijns
 *
 */
public class ReversibleLinkedList<T> implements Cpsc331LinkedList<T> {
	/**
	 * The nodes for the linked list
	 * Each node has a value and reference to the next node
	 * @author Josh
	 *
	 * @param <T> The object stored in the list
	 */
	private class LinkedNode<T>{
		private T value;
		private LinkedNode<T> next;
		
		private LinkedNode(T x, LinkedNode<T> n){
			value = x;
			next = n;
		}
	}
	
	private LinkedNode<T> head;
	private int size;
	
	
	/**
	 * Default Constructor, Creates an empty List
	 */
	public ReversibleLinkedList(){
		size = 0;
		head = null;
	}
	
	/**
	 * Get's the value of the head of the linked list
	 * @return value of the head of the list
	 */
	public T showHead(){
		T temp = head.value;
		return temp;
	}

	/**
	 * Reverse's the direction of the linked list so the last element is the head
	 */
	
	public void reverse(){
		if(size != 0){
			LinkedNode<T> current = head;
			LinkedNode<T> previous = null;
			LinkedNode<T> temp = null;
			
			//Current will move along the list, starting at the head. Previous will be assigned to the next element, switching the order. 
			while(current !=null){
				temp = current.next;
				current.next = previous;
				previous = current;
				current = temp;
			}
			//When we reach the end, current and temp will be null and previous will be the last element in the
			//list, therefore make the new head.
			head = previous;
		}
	}
	
	/**
	 * Starting from the head, prints the linked list in order.
	 */
	public void print(){
		// must print the elements of the linked list starting from the head, on separate lines
		LinkedNode<T> temp = head;
		while(temp !=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	/**
	 * Adds object x to the linked list.
	 * 
	 * @param x object to be added to the linked list.
	 */
	public void addFirst(T x) {
		head = new LinkedNode<T>(x, head);
		size++;
	}

	/**
	 * Removes and returns the first element of the linked list.
	 * 
	 * @return reference to the first element of the linked list
	 * @throws NoSuchElementException if the list is empty
	 */
	public T removeFirst() {
		if (size == 0) throw new NoSuchElementException();
		T temp = head.value;
		head = head.next;
		size--;
		return temp;
	}

	/**
	 * Removes the element x from the list if it exists
	 * @param x Object to be removed from list
	 * @return true if x is in the list
	 */
	public boolean remove(T x) {
		boolean removed = false;
		
		if(head.value.equals(x)){
			removeFirst();
			removed = true;
		}
		//This establishes the front of the linked list so we can move along it but not change head reference
		LinkedNode<T> current = head;
		LinkedNode<T> previous = null;
		while(current !=null && !current.value.equals(x)){
			previous = current;
			current = current.next;
		}
		if(current.value.equals(x)){
			previous.next = current.next;
			size--;
			removed = true;
		}
		return removed;
	}

	/**
	 * Goes through the list node by node to determine if x exists in the list.
	 * 
	 * @param x Object that is searched for within the list
	 * @return true if x exists in the List
	 */
	public boolean contains(T x) {
		LinkedNode<T> temp = head;
		
		while(temp !=null){
			if(temp.value.equals(x)) return true;
			temp = temp.next;
		}
		return false;
	}
}
