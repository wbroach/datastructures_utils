package datastructures; 

import java.util.HashMap; 

public class SimpleHashSet<T> {

    private Object plcHldr;
    private HashMap<T, Object> map;

    public <T> SimpleHashSet() {
	plcHldr = new Object(); // can use just one object because all we're checking in a hashset is if it's null or not;
	map = new HashMap<>();
    }

    public void add(T elem) {
	map.put(elem, plcHldr);
    }

    public boolean contains(T elem) {
	return map.get(elem) != null;
    }

    public static void main(String[] args) {

	String[] words = "test of a hash set which is really just a hash map under the hood".split(" "); 
	SimpleHashSet<String> set = new SimpleHashSet<>();

	for (String s : words) {
	    set.add(s);
	}
       
	String[] newWords = "test of what is included in the hash set".split(" ");

	for (String s : newWords) {
	    if (set.contains(s)) {
		System.out.println("Set contains: " + s); 
	    }
	    else {
		System.out.println("Set does not contain: " + s); 
	    }
	}

    }

}