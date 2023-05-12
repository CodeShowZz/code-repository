package com.algorithm;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-04-27 10:52
 */
public class BST {

    class Node {
        int key;
        Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    Node root;

    public BST() {
        root = null;
    }

    public void insert(int key) {
        root = insertRecursive(root,key);
    }

    private Node  insertRecursive(Node root,int key) {
        if(root == null) {
            root = new Node(key);
            return root;
        }
        if(key < root.key) {
            root.left =  insertRecursive(root.left,key);
        } else if (key >root.key) {
            root.right =  insertRecursive(root.right,key);
        }
        return root;
    }

    public boolean search(int key)  {
        root = searchRecursive(root, key);
        if (root!= null)
            return true;
        else
            return false;
    }

    private Node searchRecursive(Node root,int key) {
        if(root == null) {
            return root;
        }
        if(key <root.key) {
             return searchRecursive(root.left,key);
        } else if(key > root.key) {
             return searchRecursive(root.right, key);
        } else {
            return root;
        }
    }

    public void deleteKey(int key) {
         root = deleteRecursive(root,key);
    }

    private Node deleteRecursive(Node root,int key) {
        if(key < root.key) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRecursive(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return  root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRecursive(root.right, root.key);
        }
        return root;
    }


    void inorder() {
        inorderRecursive(root);
    }

    // recursively traverse the BST
    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.key + " ");
            inorderRecursive(root.right);
        }
    }

    int minValue(Node root)  {
        int minVal = root.key;
        while (root.left != null)  {
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    }




    public static void main(String[] args) {
        BST bst = new BST();
        /* BST tree example
              45
           /     \
          10      90
         /  \    /
        7   12  50   */
        //insert data into BST
        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);
        //print the BST
        System.out.println("The BST Created with input data(Left-root-right):");
        bst.inorder();

        //delete leaf node
        System.out.println("\nThe BST after Delete 12(leaf node):");
        bst.deleteKey(12);
        bst.inorder();
        //delete the node with one child
        System.out.println("\nThe BST after Delete 90 (node with 1 child):");
        bst.deleteKey(90);
        bst.inorder();

        //delete node with two children
        System.out.println("\nThe BST after Delete 45 (Node with two children):");
        bst.deleteKey(45);
        bst.inorder();
        //search a key in the BST
        boolean ret_val = bst.search (50);
        System.out.println("\nKey 50 found in BST:" + ret_val );
        ret_val = bst.search (12);
        System.out.println("\nKey 12 found in BST:" + ret_val );
    }

}