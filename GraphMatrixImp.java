/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.graph;

public class GraphMatrixImp {

    private final int MAX_POINTS = 6;
    private int[][] connectedGraph = new int[MAX_POINTS][MAX_POINTS];
    
    /***
     * Assume that point start with 0 
     * @param point1 Source
     * @param point2 Destination
     * @param distance 
     */
    public void addDirectedConnectedPoints(int point1, int point2, int distance) {
        if (MAX_POINTS > point1 && point1 >= 0 && MAX_POINTS > point2 && point2 >= 0) {
            connectedGraph[point1][point2] = distance;
        }
    }
    
    public void addUnDirectedConnectedPoints(int point1, int point2, int distance) {
        if (MAX_POINTS > point1 && point1 >= 0 && MAX_POINTS > point2 && point2 >= 0) {
            connectedGraph[point1][point2] = distance;
            connectedGraph[point2][point1] = distance;
        }
    }
    
    public boolean isConnected(int point1, int point2) {
        Stack stack = new Stack();
        stack.push(point1);
        int nextPoint;
        while((nextPoint = stack.pop()) != -1) {
            if (nextPoint == point2) return true;
            for(int i=0; i< MAX_POINTS;i++) {
                if(connectedGraph[nextPoint][i] > 0) {
                    stack.push(i);
                }
            }
        }
        
        return false;
    }
    
    static class Stack {
        private Node top;
        
        public void push(int i) {
            Node node = new Node();
            node.data = i;
            node.next = top;
            top = node;
        }
        
        public int pop() {
            int value = -1;
            if(top != null) {
                value = top.data;
                top = top.next;
            }
            return value;
        }
    }
    
    static class Node{
        int data;
        Node next;
    }
}
