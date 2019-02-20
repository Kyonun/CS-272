/********************************************************
* IntNode is a single Linked List program.
* 
* @author Gabriella Garcia
* @note This is Lab 3 - Single Linked List. We will have
* a no argument constructor, default constructor, two 
* accessors, two mutators, a function to add a new node after
* the last node and a function to remove a node after a given
* node. There is also a search function to see if there is 
* a particular value in the node. 
*  - 02/11/2019
 ********************************************************/
public class IntNode {
	
	private int data;
	private IntNode link;
	
	// No Argument Constructor
	public IntNode() {
		data = 0;
		link = null;
	}
	
	// Default Constructor
	public IntNode(int _data, IntNode _node) {
		data = _data;
		link = _node;
	}
	
	// Accessors
	public int getValue() {
		return data;
	}
	
	public IntNode getLink() {
		return link;
	}
	
	// Mutators
	public void setValue(int _data) {
		data = _data;
	}
	
	public void setLink(IntNode _node) {
		link = _node;
	}
	
	/****************************************************
	 * @note This function checks and returns the length 
	 * of the list.
	 * @param head
	 * @return
	 ****************************************************/
	public static int listLength(IntNode head) {
		int length = 0;
			for(IntNode cursor = head; cursor != null; cursor = cursor.link) {
				length++;
			}
		return length;
	}
	
	/****************************************************
	 * @note if the link node equals null, then we just 
	 * return the data. If there is no null, we will return
	 * the data until we hit a null character.
	 ****************************************************/
	public String toString() {		
		if(link == null)
			return data + "";
		else 
			return data + " -> " + link.toString();
	}

	
	// Add After method
	public void addNodeAfterThis(int newData) {
		
		link = new IntNode(newData, link);
			
	}
	/****************************************************
	 * @note This method searches for a particular piece
	 * of data in the node.
	 * @param head
	 * @param data
	 * @return
	 */
	public static boolean search(IntNode head, int data) {	
		
		for(IntNode cursor = head; cursor != null; cursor = cursor.link) {
			if(cursor.data == data) {				
				return true;
			}
		}
	return false;
}
	
	// Remove Node Method
	public void removeNodeAfterThis() {
		
		if(link != null)
			link = link.link;

}
}
