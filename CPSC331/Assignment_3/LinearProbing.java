/**
 * 
 * @author Joshua Schijns
 *
 */
public class LinearProbing implements HashFunction {
	private int tableSize;
	
	public LinearProbing(int tableSize) {
		this.tableSize = tableSize;
	}

	/**
	 * Hash Function
	 */
	public int hash(int key, int i) {
		int hashIndex = (key + i)%tableSize;
		return hashIndex;
	}
}
