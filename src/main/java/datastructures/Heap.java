package datastructures;

import datastructures.utils.BinaryTreeUtils; 
import java.util.ArrayList;

public class Heap<T extends Comparable> extends BinaryTree<T> {

    private ArrayList<T> nodes; 
    private int size; 

    public <T>Heap() {

	nodes = new ArrayList<>(); 
	size = 0;

    }

    @Override
    public void insert(T elem) {

	nodes.add(elem);
	reheapUp(size++);

    }

    private void reheapUp(int nodeIdx) {

	int parent = getParent(nodeIdx);

	if (parent < 0 || nodes.get(parent).compareTo(nodes.get(nodeIdx)) >= 0) {
	    return;
	}
	else {
	    T temp = nodes.get(nodeIdx);
	    nodes.set(nodeIdx, nodes.get(parent));
	    nodes.set(parent, temp);
	    reheapUp(parent);
	}

    }


    @Override
    public T delete() {

	if (size == 0) { return null; }

	T ret = nodes.get(0);
	size--;
	
	nodes.set(0, nodes.get(size));
	reheapDown(0);
	return ret;
    }

    private void reheapDown(int nodeIdx) {

	if (nodeIdx >= size) {
	    return;
	}
	else {
	    T val = nodes.get(nodeIdx);
	    int leftIdx = 2 * nodeIdx + 1; 
	    int rightIdx = leftIdx + 1; 
	    T left = leftIdx < size ? nodes.get(leftIdx) : null;
	    T right = rightIdx < size ? nodes.get(rightIdx) : null;
	    
	    int max = nodeIdx;

	    if (left != null && val.compareTo(left) == -1) {
		max = leftIdx; 
		val = nodes.get(leftIdx);
	    } 

	    if (right != null && val.compareTo(right) == -1) {
		max = rightIdx; 
	    }


	    if (nodeIdx != max) {
		T temp = nodes.get(nodeIdx);
		nodes.set(nodeIdx, nodes.get(max));
		nodes.set(max, temp);

		reheapDown(max);
	    }
	    
	}
	

    }

    @Override
    public ArrayList<T> toArray() {
	return nodes; 
    }

    @Override 
    public void printTree() {

	BinaryTreeUtils.printTree(nodes, size);

    }

    private int getParent(int i) {

	if (i % 2 == 0) {
	    return (i / 2) - 1; 
	}
	else {
	    return i / 2; 
	}

    }

    public boolean isValidHeap() {

	return isValidRec(0);

    }

    private boolean isValidRec(int nodeIdx) {

	if (nodeIdx >= size) {
	    return true;
	}
	else {
	    int leftIdx = 2 * nodeIdx + 1; 
	    int rightIdx = 2 * nodeIdx + 2; 
	    T val = nodes.get(nodeIdx);
	    T left = leftIdx < size ? nodes.get(leftIdx) : null;
	    T right = rightIdx < size ? nodes.get(rightIdx) : null;

	    if (left != null && val.compareTo(left) == -1) {
		return false;
	    }

	    if (right != null && val.compareTo(right) == -1) {
		return false;
	    }

	    return isValidRec(leftIdx) && isValidRec(rightIdx);

	}



    }

}