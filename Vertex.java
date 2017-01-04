/**
 * Vertex.java
 * ALG3 Assessed Exercise 1
 * Name: Terence Tan Boon Kiat
 * GlasgowID: 2228167T
 * This is my own work.
 */

import java.util.PriorityQueue;

public class Vertex{

    private PriorityQueue<AdjVertices> adjVerticesList; // the adjacency list 
    private int index; // the index of this vertex in the graph
    private int shortestDist; // shortest distance from the input vertex
    int predecessor; // index of predecessor vertex in a traversal

    public Vertex(int n) {
        adjVerticesList = new PriorityQueue<>();
        setIndex(n);
        setShortestDist(Integer.MAX_VALUE);
    }

    public Vertex(Vertex v) {
        adjVerticesList = v.getAdjVerticesList();
        index = v.getIndex();
    }

    public PriorityQueue<AdjVertices> getAdjVerticesList() {
        return adjVerticesList;
    }

    public int getIndex() {
        return index;
    }

    public final void setIndex(int n) {
        index = n;
    }

    public int getShortestDist() {
        return shortestDist;
    }

    public final void setShortestDist(int n) {
        shortestDist = n;
    }

    public int getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(int n) {
        predecessor = n;
    }

    public void adjVerticesAdd(int n, int w) {
        adjVerticesList.add(new AdjVertices(n, w));
    }

    public int vertexDegree() {
        return adjVerticesList.size();
    }
    
}
