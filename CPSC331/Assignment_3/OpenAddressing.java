/**
 * 
 * @author Joshua Schijns
 *
 */

public class OpenAddressing<V, H extends HashFunction> {
	private int tableSize;
	private H hashFxn;
	private HashNode[] table;
	private static final int NIL = -1;
	private static final int DEL = -2;
	
	private class HashNode{
		private V value;
		private int key;
		private HashNode(V value, int key){
			this.value = value;
			this.key = key;
		}
	}
	
	public OpenAddressing(int tableSize, H hashFunction) {
		this.tableSize = tableSize;
		this.hashFxn = hashFunction;
		table = new HashNode[tableSize];
		for(int i = 0; i < tableSize; i++){
			table[i] = new HashNode(NIL);
		}
	}
	
	
	/**
	 * Inserts the key,value pair into the hash map
	 * @param key The key to look for
	 * @param value value of key pair
	 * @throws DuplicateKeyException When key already exists
	 * @throws FullTableException when the hash table is full
	 */
	public void insert(int key, V value) throws DuplicateKeyException, FullTableException{
		int i = 0;
		int j = 0;
		while(i < tableSize && (table[j].key!= key)){
			j = hashFxn.hash(key,i);
			if(table[j].key == NIL){
				table[j] = new HashNode(value, key);
				
			}else if(table[j].key == key) throw new DuplicateKeyException();
			i++;
		}
		if(i > tableSize) throw new FullTableException();
		
	}
	
	
	/**
	 * Deletes a given key,value pair if it exists
	 * @param key the key pointer
	 * @throws KeyNotFoundException if the key does not exist
	 */
	public void delete(int key) throws KeyNotFoundException{
		int i = 0;
		int j = 0;
		do{
			j = hashFxn.hash(key, i);
			if(table[j].key == key){
				table[j].key = DEL;
				
			}
		}while((table[j].key != NIL) && (table[j].key != DEL) && (i < tableSize));
		if(i < tableSize)throw new KeyNotFoundException();
	}
	
	
	/**
	 * Searches for the key within the hashmap and returns the value paired with it
	 * @param key key to search
	 * @return value of pair
	 * @throws KeyNotFoundException when key does not exist
	 */
	public V search(int key) throws KeyNotFoundException{
		int i = 0;
		int j = 0;
		do{
			j = hashFxn.hash(key, i);
			if(table[j].key == key){
				return table[j].value;
			}
			i++;
		}while((table[j].key != NIL) && (i < tableSize));
		
		throw new KeyNotFoundException();
	}
}
