

import java.util.Arrays;

/*************************************************************************
*@author Gabriella Garcia
*@version Lab 2 - 02/05/2019
*@note The copy constructor creates a new instance of StringSet and copies
* the content from the current instance to a new instance.
*@note This method will add the String given to the first available index 
	 * in the String array. If there is not enough space, we will call 
	 * ensureCapacity to double the space.
 @note We are using the variable @param a to add string to the array.
	 * We need to verify it is not a null object and if it is a null object,
	 * we return false. Otherwise, if the String value passed through is equal
	 * to the collection of strings, we will return true. If we do not find 
	 * a matching String, we return false.
@note This method removes a String from the array when the array contains
	 * the same value.
 @note ensureCapacity sets the minimumCapacity and makes sure
	 * that the array can hold minimumCapacity String if the array's
	 * capacity is smaller than the input parameter. Otherwise we leave it
	 * alone.
@note This is similar to the previous add method, but instead we are ordering
	 * the array in alphabetical order.
@note My main method, where we test each of the above methods.
**************************************************************************
**/

public class StringSet {

	private int size;
	private int capacity; 
	private String[] data = new String[capacity];
	
	
	// Default Constructor
	public StringSet(){		
		capacity = 2; 
		data = new String[capacity];
	}
	
	// Constructor with a parameter passed
	public StringSet(int _capacity){		
		capacity = _capacity;
		data = new String[capacity];		
	}
	
/*************************************************************************
* 
* @note The copy constructor creates a new instance of StringSet and copies
* the content from the current instance to a new instance.
* 
*************************************************************************
***/
	public StringSet(Object obj){		
		if( obj != null){
			if(obj instanceof StringSet) {
				StringSet objStringSet = (StringSet)obj;
				size = objStringSet.size;
				capacity = objStringSet.capacity;
				data = objStringSet.data;
				for(int i = 0; i < size; i++) 
						data[i] = objStringSet.data[i]; 
			}
		}
	}
	
	public int size(){
		return size;
	}
	
	public int capacity(){
		return capacity;
	}
	
	/*************************************************************************
	 * @note This method will add the String given to the first available index 
	 * in the String array. If there is not enough space, we will call 
	 * ensureCapacity to double the space.
	 *************************************************************************
	 ***/
	 
	public void add(String a){
		if(a != null) {
			if(capacity == size){
				capacity = data.length *2;
				String[] newArr = new String [capacity];
				System.arraycopy(data, 0, newArr, 0, size);
				data = newArr;
				data[size] = a;
				size++;
			}else{
				data[size] = a;
				size++;
			}
		}
	}
	/*************************************************************************
	 * @note We are using the variable @param a to add string to the array.
	 * We need to verify it is not a null object and if it is a null object,
	 * we return false. Otherwise, if the String value passed through is equal
	 * to the collection of strings, we will return true. If we do not find 
	 * a matching String, we return false.
	 *************************************************************************
	 ***/

	public boolean contains(String a){
		if(a != null) {	
			for(int i = 0; i < size; i++) {
				if(data[i].equals(a)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*************************************************************************
	 * @note This method removes a String from the array when the array contains
	 * the same value.
	 *************************************************************************
	 ***/
	public boolean remove(String a){
		if(a != null) {	
			for(int i = 0; i < size; i++){
				if(data[i].equals(a)){
					data[i] = data[size - 1];
					size--;
					return true;
				}
			}
		}
		return false;
	}
	
	/*************************************************************************
	 * @note ensureCapacity sets the minimumCapacity and makes sure
	 * that the array can hold minimumCapacity String if the array's
	 * capacity is smaller than the input parameter. Otherwise we leave it
	 * alone.
	 *************************************************************************
	 ***/
	private void ensureCapacity(int minimumCapacity){
		if(minimumCapacity > 0){
			if(capacity < minimumCapacity){
				capacity = minimumCapacity;
				String[] newArr = new String [capacity];
				System.arraycopy(data, 0, newArr, 0, size);
				data = newArr;
			}
		}
	}
	
	/*************************************************************************
	 * @note This is similar to the previous add method, but instead we are ordering
	 * the array in alphabetical order.
	 *************************************************************************
	 ***/
	public void addOrdered(String a){		
		
		int num;
		
		if(a != null){
			if(capacity == size){
				capacity = data.length *2;
				String[] newArr = new String [capacity];
				System.arraycopy(data, 0, newArr, 0, size);
				data = newArr;
				data[size] = a;
				size++;
			}else{
				data[size] = a;
				size++;
			}
			
		}
		
		}
		
	/*************************************************************************
	 * @note My main method, where we test each of the above methods.
	 *************************************************************************
	 ***/
	public static void main(String[] args){
		
		StringSet s1 = new StringSet(); 
		StringSet s2 = new StringSet(3); 
		
		
		s1.add("Apples");
		s1.add("Oranges");
		s1.add("Bananas");
		s1.add("Strawberries");
		s1.add("Kiwis");
		s1.add("Pineapples");
		s1.add("Mangoes");
		s1.add("Peaches");
		
		System.out.println("String 1 Size: " + s1.size());
		System.out.println("String 1 Capacity: " + s1.capacity());
		System.out.println("String 1: ");
		
			for(int i = 0; i < s1.size; i++) {
				System.out.print(s1.data[i] + " ");
			}
			
		System.out.println();
		System.out.println("Does S1 have Bananas: " + s1.contains("Bananas"));
		System.out.println("Does S1 have Durians: " + s1.contains("Durians"));
		
		System.out.println();
		
		s2.add("Water");
		s2.add("Rain");
		s2.add("Snow");
		s2.add("Ice");
		
		System.out.println("String 2 Size: " + s2.size());
		System.out.println("String 2 Capacity: " + s2.capacity());
		System.out.print("String 2 : ");
			for(int i = 0; i < s2.size; i++) {
				System.out.print(s2.data[i] + " ");
			}
		System.out.println();
		System.out.println("If there is Water in S2, remove it: " + s2.remove("Water"));
		System.out.println("If there are Clouds in S2 remove it: " + s2.remove("Clouds"));
		System.out.println("If there is Snow in S2 remove it" + s2.remove("Snow"));
			for(int i = 0; i < s2.size; i++) {
				System.out.print(s2.data[i] + " ");
			}
		
		System.out.println();
		StringSet copy_s1 = new StringSet(s1);
		
		System.out.println("Copy 1 Size: " + copy_s1.size());
		System.out.println("Copy 1 Capacity: " + copy_s1.capacity());
		System.out.print("Copy 1 : ");
		for(int i = 0; i < copy_s1.size; i++) {
			System.out.print(copy_s1.data[i] + " ");
		}
	}
}// of StringSet class
