package datastructures.utils; 

import java.util.ArrayList;

public class BinaryTreeUtils {

    private static final int TABSIZE = 4; // number of spaces equiv to a tab

    public static <T> void printTree(ArrayList<T> nodes, int size) {
	int currLevel = 0; 
	StringBuilder buf = new StringBuilder();

	int numTabs = log2(nodes.size()) + 1; 

	for (int i = 0; i < size; ++i) {
	    boolean newLevel = Math.pow(2, currLevel) - 1 == i ? true : false; 
	    
	    if (newLevel) {

		buf.append("\n");

		for (int j = 0; j < numTabs - 1; ++j) {
		    buf.append("\t");
		}
		numTabs--;
		currLevel++;
	    }

	    buf.append("\t");
	    buf.append(nodes.get(i).toString());
	}

	System.out.println(buf.toString());
	
    }
    
    private static int log2(int x) {
	return (int) (Math.log(x) / Math.log(2));
    }

}