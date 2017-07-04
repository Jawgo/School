import java.util.EmptyStackException;

/**
 * Determines if a string has balanced parenthesis in the correct order
 * @author Josh
 *
 */
public class Balanced {
	/**
	 * Determines if the parenthesis of the string are balanced
	 * Pushes left brackets and pops right brackets on a Stack.
	 * @param exp the string to be read
	 * @return true if the parenthesis are balanced
	 */
	public boolean balancedParenthesis(String exp){
		ListBasedStack list = new ListBasedStack();
		boolean balanced = true;
		//Will add to list until right bracket encountered, then compare to top
		//of stack. If it is same style but left, pop off and keep going.
		//If not then return false 
		int i = 0;
		while((i < exp.length()) && (balanced)){
			char tmp = exp.charAt(i);
			if(tmp==(')')){
				try{
					if(list.peek() == '(') list.pop();
					else balanced = false;
				}catch (EmptyStackException ese) {
					balanced = false;
				}
			}else if(tmp==(']')){
				try{
					if(list.peek() == '[') list.pop();
					else balanced = false;
				}catch (EmptyStackException ese) {
					balanced = false;
				}
			}else if(tmp==('}')){
				try{
					if(list.peek() =='{') list.pop();
					else balanced = false;
				}catch (EmptyStackException ese) {
					balanced = false;
				}
			}else if((tmp==('{'))||(tmp==('('))||(tmp==('['))){
				list.push(tmp);
			}
			i++;
		}
		if(!list.isEmpty()) balanced = false;
		return balanced;
	}
	
}
