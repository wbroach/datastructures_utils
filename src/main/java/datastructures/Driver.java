package datastructures;

import datastructures.utils.BinaryTreeUtils; 
import java.util.Random;

public class Driver {


    private static final int SIZE = 12;
    private static final int CEILING = 100;

    public static void main(String[] args) {

	Random r = new Random();

	Heap<Integer> myHeap = new Heap<>();

	for (int i = 0; i < SIZE; ++i) {
	    myHeap.insert(r.nextInt(CEILING));
	}

	myHeap.printTree();
	if (myHeap.isValidHeap()) {
	    System.out.println("\nIt's GOOD!");
	}
	else {
	    System.out.println("\nnot a valid tree");
	}

	for (int i = 0; i < SIZE; ++i) {
	    int val = myHeap.delete();
	    System.out.println("Removed val: " + val);

	    myHeap.printTree();
	    if (myHeap.isValidHeap()) {
		System.out.println("\nIt's GOOD!");
	    }
	    else {
		System.out.println("\nnot a valid tree");
	    }   
	}
	

    }

}