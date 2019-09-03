package datastructures; 

import java.util.HashSet; 

public class CharHashMap {

    private int size; 
    private Integer[] arr; // needs to be a class type so array elements start as null 

    public CharHashMap(int size) {
	this.size = size; 
	this.arr = new Integer[size];
    }

    private int hashCode(char c) {
	return c % size; // can do because char types have an int representation
    }

    public Integer put(char key, int val) {
	int hash = hashCode(key); // calc hash value for key
	Integer ret = arr[hash];  // get the original value stored in array

	arr[hash] = new Integer(val); // put the new value in the array

	return ret; // return the old value
    }

    public Integer get(char key) {
	int hash = hashCode(key);
	return arr[hash];
    }
    
    public static void main(String[] args) {
	
	String[] words = { "abbadabbadooxzr", "yeehaw", "hashmaps", "are", "freakinamazing" };

	for (String s : words) {
	    CharHashMap map = new CharHashMap(99);

	    System.out.println("\n-----Original String: " + s + "-----\n"); 
	    for (char c : s.toCharArray()) {
		
		if (map.get(c) == null) { // i.e., the first time you've seen that character
		    map.put(c, 1);
		}
		else { // i.e., I've seen this before
		    int prevCount = map.get(c);
		    map.put(c, prevCount + 1);
		}
	    }    
	    
	    HashSet<Character> set = new HashSet<>(); // just so we don't double-print
	    for (char c : s.toCharArray()) {
		if (map.get(c) != null && !set.contains(c)) {
		    System.out.println("Count of " + c + ": " + map.get(c) + ", HashCode of " + c + ": " + map.hashCode(c)); 
		}
	    
		set.add(c); 
	    }
	}
    }

}