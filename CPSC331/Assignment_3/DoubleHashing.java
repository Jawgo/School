/**
 * 
 * @author Joshua Schijns
 *
 */
public class DoubleHashing implements HashFunction {
	private int tableSize;
	
	public DoubleHashing(int tableSize) {
		this.tableSize = tableSize;
	}
	
	
	/**
	 * Hash Function
	 */
	public int hash(int key, int i) {
		int hashIndex;
		if(i == 0){
			hashIndex = key%tableSize;
		}else{
			hashIndex = ((key%tableSize) + (i*(1+(key%(tableSize-1)))));
		}
		return hashIndex;
	}
}
