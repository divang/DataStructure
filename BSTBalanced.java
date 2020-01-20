/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tree;

import java.util.ArrayList;

/**
 *
 * @author d0s02xb
 */
public class BSTBalanced {

    public Node root;

    public void traverse() {
        System.out.println(" ");
        traverse(root);
    }

    private void traverse(Node node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        System.out.print(node.data + " ");
        traverse(node.right);
    }

    public boolean isBalanceTree() {
        if (root == null) {
            return true;
        }
        return Math.abs(heightOfBST(root.left) - heightOfBST(root.right)) <= 1;
    }

    public boolean isBalanceTree(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(heightOfBST(node.left) - heightOfBST(node.right)) <= 1;
    }

    public void balance() {
        root = balance(root);
    }

    private Node balance(Node node) {

        if (node == null) {
            return null;
        }
        node.left = balance(node.left);
        if (!isBalanceTree(node.left)) {
            node.left = rotate(node.left);
        }
        node.right = balance(node.right);
        if (!isBalanceTree(node.right)) {
            node.right = rotate(node.right);
        }
        if (!isBalanceTree(node)) {
            node = rotate(node);
        }
        return node;
    }

    public Node rotate(Node node) {

        Node newParent = null;
        if (node == null) {
            return newParent;
        }
        if (node.left != null && node.left.left != null) {
            newParent = rotateRight(node);
        } else if (node.right != null && node.right.right != null) {
            newParent = rotateLeft(node);
        } else if (node.left != null && node.left.right != null) {
            newParent = rotateLeftThenRight(node);
        } else if (node.right != null && node.right.left != null) {
            newParent = rotateRightThenLeft(node);
        }
        return newParent;
    }

    public Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }

    public Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }

    public Node rotateLeftThenRight(Node node) {
        Node nodeLeft = node.left;
        Node nodeLeftRight = node.left.right;
        node.left = nodeLeftRight;
        nodeLeft.right = nodeLeftRight.left;
        nodeLeftRight.left = nodeLeft;
        return rotateRight(node);
    }

    public Node rotateRightThenLeft(Node node) {
        Node nodeRight = node.right;
        Node nodeRightLeft = node.right.left;
        node.right = nodeRightLeft;
        nodeRight.left = nodeRightLeft.right;
        nodeRightLeft.right = nodeRight;
        return rotateLeft(node);
    }

    public boolean hasRequiredSum(int sum) {
        ArrayList<Integer> lookup = new ArrayList<>();
        return hasRequiredSum(root, sum, lookup);
    }

    public boolean hasRequiredSum(Node node, int sum, ArrayList<Integer> lookup) {
        if (node == null) {
            return false;
        }
        int counterValue = sum - node.data;
        if (lookup.contains(counterValue)) {
            return true;
        } else {
            lookup.add(node.data);
        }
        return hasRequiredSum(node.left, sum, lookup) || hasRequiredSum(node.right, sum, lookup);
    }

    public void BFS() {
        BFS(root);
        System.out.println(" ");
    }

    private void BFS(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        BFS(root.left);
        BFS(root.right);
    }

    public void add(int v) {
        if (root == null) {
            root = new Node();
            root.data = v;
            System.out.println("Added root:" + v);
        } else {
            add(root, v);
        }
    }

    public int heightOfBST() {
        return heightOfBST(root);
    }

    public int heightOfBST(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(heightOfBST(node.left), heightOfBST(node.right)) + 1;
    }

    public void add(Node node, int v) {
        if (node == null) {
            return;
        }

        if (v > node.data) {
            if (node.right == null) {
                node.right = new Node();
                node.right.data = v;
                System.out.println("Added right:" + v + " of " + node.data);
            } else {
                add(node.right, v);
            }
        } else {
            if (node.left == null) {
                node.left = new Node();
                node.left.data = v;
                System.out.println("Added left:" + v + " of " + node.data);
            } else {
                add(node.left, v);
            }
        }
    }

    static class Node {

        public int data;
        public Node left;
        public Node right;
    }
}
