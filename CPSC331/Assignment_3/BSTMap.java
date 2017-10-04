/**
 * 
 * @author Josh Schijns
 * @param <K>
 *
 */

public class BSTMap<K extends Comparable <K>,V> implements SimpleMap<K, V>{
	
	
	private int size;
	protected bstNode<K,V> root;
	
	protected class bstNode<K,V>{
		K key;
		V value;
		bstNode<K,V> left;
		bstNode<K,V> right;
		private bstNode(K key,V value){
			this.key = key;
			this.value = value;
		}
	}
	
	public BSTMap(){
		size = 0;
		root = null;
	}
	
	 /**
     * Tests whether the map is empty.
     *
     * @return true if the dictionary is empty, false otherwise
     */
	public boolean isEmpty() {
		return (size == 0);
	}

	 /**
     * Returns the number of key-values pairs in the map.
     * @return int The size of the map.
     */
	public int size() {
		return size;
	}

	 /**
     * Inserts a key-value pair into the map.
     * The parent's child is also updated
     * @param key The key to be inserted.
     * @param value Key's corresponding value.
     * @throws KeyFoundException If a matching key is
     * already present in the map
     */
	public void insert(K key, V value) throws KeyFoundException {
		bstNode<K,V> tmp = root;
		bstNode<K,V> parent = null;
		
		if(root == null){
			root = new bstNode<K,V>(key, value);
		}else{
			while(tmp != null){
				parent = tmp;
				if(key.compareTo(tmp.key) < 0) tmp = tmp.left;
				else if(key.compareTo(tmp.key) > 0) tmp = tmp.right;
				else throw new KeyFoundException();
			}
			if(key.compareTo(parent.key) < 0){
				parent.left = new bstNode<K,V>(key, value);
			}else{
				parent.right = new bstNode<K,V>(key, value);
			}
		}
		size++;
		
	}

	 /**
     * Deletes the key-value pair with the specified key
     * from the map
     * There are 4 cases to be looked at.
     * Case 1: KeyNotFound
     * Case 2: Deleted a leaf
     * Case 3: Deleted a node with 1 child
     * Case 4: Deleted a node with 2 children
     * 
     * @param key The key to remove from the map.
     * @throws KeyNotFoundException If key is not found
     * in the map.
     */
	public void delete(K key) throws KeyNotFoundException {
		bstNode<K,V> tmp = root;
		bstNode<K,V> parent = null;
		bstNode<K,V> child = root;
		
		//First we search for the key to be deleted
		while(tmp != null && (key.compareTo(tmp.key) == 0)){
			parent = tmp;
			if(key.compareTo(tmp.key) > 0) tmp = tmp.right;
			else tmp = tmp.left;
		}
		//Case 1
		if(tmp == null) throw new KeyNotFoundException();
		
		//Case 2
		else if(tmp.left == null && tmp.right == null){
			if(key.compareTo(parent.key) > 0) parent.right = null;
			else parent.left = null;
		}
		
		//Case 3
		//Deleted Node has left child
		else if(tmp.right == null){
			child = tmp.left;
			
			K tempK = tmp.key;
			tmp.key = child.key;
			child.key = tempK;
			
			V tempV = tmp.value;
			tmp.value = child.value;
			child.value = tempV;
			
			//Assigning new children to tmp
			tmp.left = child.left;
			tmp.right = child.right;
			
		//Deleted Node has a right child
		}else if(tmp.left == null){
			child = tmp.right;
			
			K tempK = tmp.key;
			tmp.key = child.key;
			child.key = tempK;
			
			V tempV = tmp.value;
			tmp.value = child.value;
			child.value = tempV;
			
			//Assigning new children to tmp
			tmp.left = child.left;
			tmp.right = child.right;
			
		//Case 4
		//Find the max in the left subtree of the node to be deleted
		//and switch them. Then have to switch values and keys
		}else{
			child = tmp.left;
			parent = null;
			
			//Finding max in left subtree
			while(child.right != null){
				parent = child;
				child = parent.right;
			}
			if(parent == null){
				K tempK = tmp.key;
				tmp.key = child.key;
				child.key = tempK;
				
				V tempV = tmp.value;
				tmp.value = child.value;
				child.value = tempV;
				
				tmp.left = child.left;
			}else{
				K tempK = tmp.key;
				tmp.key = child.key;
				child.key = tempK;
				
				V tempV = tmp.value;
				tmp.value = child.value;
				child.value = tempV;
				
				parent.right = child.left;
			}
		}
		size--;
	}

	/**
     * Returns the value corresponding to key.
     * @param key The key to search for in the map.
     * @return V The value corresponding to key.
     * @throws KeyNotFoundException If key is not found
     * in the map.
     */
	public V search(K key) throws KeyNotFoundException {
		bstNode<K,V> tmp = root;
		int i = 0;
		while((i < size) && (tmp != null)){
			if(key.compareTo(tmp.key) > 0) tmp = tmp.right;
			else if(key.compareTo(tmp.key) < 0) tmp = tmp.left;
			else return tmp.value;
			i++;
		}
		throw new KeyNotFoundException();
	}

	 /**
     * Modifies the value corresponding to key in the map.
     * @param key The key whose value to modify.
     * @param value The new value of key.
     * @throws KeyNotFoundException If key was not found in the map
     * and therefore no value was modified.
     */
	public void modify(K key, V value) throws KeyNotFoundException {
		bstNode<K,V> tmp = root;
		int i = 0;
		while((i < size) && (tmp != null)){
			if(key.compareTo(tmp.key) > 0) tmp = tmp.right;
			else if(key.compareTo(tmp.key) < 0) tmp = tmp.left;
			else tmp.value = value;
			i++;
		}
		throw new KeyNotFoundException();
		
	}

}
