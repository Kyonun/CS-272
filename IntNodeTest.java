/*******************************************************
 * @note This is the test class to test the functions
 * in IntNode.java. Three tests are created to test
 * the functionality of each method  in IntNode.java.
 * @author gagarcia
 *
 *******************************************************/

public class IntNodeTest {


	public static void main(String[] args) {
		
		IntNode test1 = new IntNode();
		IntNode test2 = new IntNode(2, test1);
		IntNode test3 = new IntNode(4, test2);
		
		//Printing No-args Constructor
		System.out.println("No Argument Constructor: " + test1);
		
		// Printing Default Constructor
		System.out.println("Default Constructor: " + test2);
		
		// Adding nodes to test3
		test3.addNodeAfterThis(6);
		test3.addNodeAfterThis(8);
		test3.addNodeAfterThis(10);
		
		System.out.println("Test 3 Nodes: " + test3);
		
		//remove node from test3
		test3.removeNodeAfterThis();
		
		// Try to remove null from an already null test1
		test1.removeNodeAfterThis();
		
		// Printing test3 to see if node was removed 
		System.out.println("Test 3 with a node Removed: " +test3);
		
		// Search to see if there's a 2 in test3
		System.out.println("Searching for #2 in Test 3: " + test3.search(test3, 2));
		
		// Search to see if there is a 2 in test1
		System.out.println("Searching for #2 in Test 1: " + test3.search(test1, 2));
		
		System.out.println("The length of Test 3 is: " + test3.listLength(test3));
		
		test2.setLink(test1);
		test2.setValue(3);
		
		System.out.println("The value of Test 2 is: " + test2.getValue());
		System.out.println("The value of the node for Test 2 is: " +test2.getLink());
		
		
		

	}

}
