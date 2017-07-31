package bhcc.android.stockapp;

import java.util.Stack;

/**
 * Created by dotca on 4/22/2017.
 */

// Binary

public class BinaryTree<Customer extends Comparable<Customer>> {

    public Stack<Customer> nodeStack = new Stack<>();

    public Customer c = null;
    private int nodeCount = 0;
    protected BinaryNode<Customer> root;

    public BinaryTree() {
        root = null;
    }

    // traverse in order and add to stack as you go
    public void inOrder(){
        inOrder(root);
    }
    protected void inOrder(BinaryNode<Customer> root){

        if(root == null){
            return;
        }

        inOrder(root.left);
        nodeStack.push(root.mCustomer);
        inOrder(root.right);
    }

    // left and right swapped, inferior nodes on the right
    public boolean insert(Customer c) {
        if (root == null) {
            root = new BinaryNode<>(c);

        } else {
            BinaryNode<Customer> parent = null;
            BinaryNode<Customer> current = root;

            // compare nodes
            while (current != null) {
                if (c.compareTo(current.mCustomer) < 0) {
                    parent = current;
                    current = current.right;
                } else if (c.compareTo(current.mCustomer) > 0) {
                    parent = current;
                    current = current.left;
                } else {
                    return false;
                }
                // insert nodes into tree
                if (c.compareTo(parent.mCustomer) < 0 && parent.right == null) {
                    parent.right = new BinaryNode<>(c);
                }
                if (c.compareTo(parent.mCustomer) > 0 && parent.left == null){
                    parent.left = new BinaryNode<>(c);
                }
            }
        }
        nodeCount++;
        return true;
    }

    // class definition for the node
    public static class BinaryNode<Customer extends Comparable<Customer>> {

        protected Customer mCustomer;
        protected BinaryNode<Customer> left;
        protected BinaryNode<Customer> right;

        public BinaryNode(Customer c) {
            mCustomer = c;
            left = right = null;
        }
    }

    // get size
    public int getNodeCount(){
        return nodeCount;
    }

    // get the stack
    public Stack<Customer> getNodeStack() {
        inOrder();
        return nodeStack;
    }

}
