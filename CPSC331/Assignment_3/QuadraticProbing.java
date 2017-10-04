/**
 * 
 * @author Joshua Schijns
 *
 */
public class QuadraticProbing implements HashFunction {
	private int tableSize;
	
	public QuadraticProbing(int tableSize) {
		this.tableSize = tableSize;
	}

	
	/**
	 * Hash Function
	 */
	public int hash(int key, int i) {
		int hashIndex;
		if(i == 0){
			hashIndex = (key)%tableSize; 
		}else{
			hashIndex = (key + (i*i))%tableSize;
		}
		return hashIndex;
	}
}
