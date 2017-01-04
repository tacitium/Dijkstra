/**
 * Graph.java 
 * ALG3 Assessed Exercise 1 
 * Name: Terence Tan Boon Kiat 
 * GlasgowID: 2228167T
 * This is my own work.
 */

import java.util.LinkedList;

public class Graph {

    private Vertex[] vertices; // vertices array
    private int totalVertices; // total vertices in graph

    public Graph(int n) {
        setSize(n);
        createVertices(n);
    }

    public final int getSize() {
        return totalVertices;
    }

    public final void setSize(int n) {
        totalVertices = n;
    }

    public final void createVertices(int n) {
        vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }
    }

    public Vertex getVertex(int i) {
        return vertices[i];
    }

    public void setVertex(int i) {
        vertices[i] = new Vertex(i);
    }

    // method to calculate shortest distance from start vertex to every vertex it can visit
    public void calculateShortestDistances(int start) {
        Vertex first = vertices[start]; // get the vertex from start index
        first.setShortestDist(0); // initialise distance to 0 for first vertex
        LinkedList<Vertex> queue = new LinkedList<>(); // create queue to store current vertex being visited
        queue.add(first); // add the first vertex into the queue

        try {
            while (!queue.isEmpty()) {
                Vertex current = queue.poll(); // save the first vertex as the current vertex and remove it from queue

                // Visit all adjacent vertices in adjlist for the current vertex
                for (AdjVertices a : current.getAdjVerticesList()) {
                    Vertex next = getVertex(a.getVertexNumber()); // get the next adjacent vertex of current vertex
                    int weight = a.getVertexWeight(); // get the weight of the first adjacent vertex
                    int dist = current.getShortestDist() + weight; // save the distance from current to adjacent vertex
                    // since default distance is infinite, first distance will always be less
                    // distance should always be more than next distance unless it is not visited yet
                    if (dist < next.getShortestDist()) {
                        queue.remove(next); // ensure next vertex is not in the queue
                        next.setShortestDist(dist); // set the next vertex's distance from start vertex
                        next.setPredecessor(current.getIndex()); // save current vertex as predecessor
                        queue.add(next); // adds the vertex into queue to loop until no more vertices can be visited
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    // function to get the shortest path from a start vertex to an end vertex
//    public LinkedList getShortestPath(int start, int end) {
//        Vertex first = vertices[start]; // get first vertex
//        Vertex last = vertices[end]; // get last vertex
//        LinkedList<Integer> path = new LinkedList<>(); // new list to store path
//        try {
//            // loop through all predecessor vertices of last vertex to find the path back to first vertex
//            for (Vertex v = last; v != first; v = vertices[v.getPredecessor()]) {
//                path.add(v.getIndex()); // add index of predecessor into path
//            }
//            Collections.reverse(path); // since path is from last to second vertex, reverse it
//            path.addFirst(first.getIndex()); // add first vertex as first element
//        } catch (Exception e) {
//            System.err.println("Exception: " + e.getMessage());
//        }
//        return path;
//    }
    // function to get the shortest path from a start vertex to an end vertex
    public String getShortestPath(int start, int end) {
        Vertex first = vertices[start]; // get first vertex
        Vertex last = vertices[end]; // get last vertex
        String path = ""; //store path
        try {
            // loop through all predecessor vertices of last vertex to find the path back to first vertex
            for (Vertex v = last; v != first; v = vertices[v.getPredecessor()]) {
                if (v != last) {
                    path = v.getIndex() + " " + path; // add index of predecessor into path
                } else {
                    path = v.getIndex() + path; // add index without extra space for last vertex
                }
            }
            path = first.getIndex() + " " + path; // add first vertex's index at front of path
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return path;
    }

    // gets the shortest distance to an end vertex
    public int getShortestDistance(int end) {
        Vertex last = vertices[end];
        return last.getShortestDist();
    }

}
