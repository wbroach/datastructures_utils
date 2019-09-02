package datastructures; 

import java.util.ArrayList;

public abstract class BinaryTree<T> {

    public abstract void insert(T elem); 

    public abstract T delete();

    public abstract ArrayList<T> toArray();

    public abstract void printTree();

}