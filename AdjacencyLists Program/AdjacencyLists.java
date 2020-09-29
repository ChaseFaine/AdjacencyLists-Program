import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * AdjacencyLists.
 * 
 * @author Chase Faine 
 * @version Fall 2020 
 * 
 */
public class AdjacencyLists 
{   
    private int order;
    private int size;
    private boolean directed;
    private ArrayList<LinkedList<Integer>> adjList;

    /**
     * Creates AdjacencyLists for an undirected graph with the specified
     * number of vertices and no edges.
     * 
     * @param order 
     *            the number of vertices in the graph 
     *
     * Allocates memory for an ArrayList of LinkedList of Integer, and
     *      makes an empty list for each vertex.
     */
    public AdjacencyLists(int order)
    {
        this.order = order;
        adjList = new ArrayList<LinkedList<Integer>>(order);
        for (int i = 0; i < order; i++) 
        {
            adjList.add(new LinkedList<Integer>());
        }
    }

    /**
     * Creates AdjacencyLists for a graph with the specified 
     * number of vertices and no edges.
     * 
     * @param order 
     *            the number of vertices in the graph 
     * @param directed 
     *            true if the graph is directed, false otherwise 
     *
     * Allocates memory for an ArrayList of LinkedList of Integer, and
     *      makes an empty list for each vertex.
     */
    public AdjacencyLists(int order, boolean directed)
    {   
        this.order = order;
        this.directed = directed;
        adjList = new ArrayList<LinkedList<Integer>>(order);
        for (int i = 0; i < order; i++) 
        {
            adjList.add(new LinkedList<Integer>());
        }
    }

    /**
     * Adds an edge x, y to the graph. 
     * 
     * @param x
     * @param y 
     *      x,y are the endpoints of the edge
     * 
     *  If the graph is undirected, x is added to y's list and y is
     *     added to x's list.  
     *  If the graph is directed, y is added to x's list
     *
     *  Throws an IndexOutOfBoundsException if 
     *    x >= order or y >= order() 
     */

    public void addEdge(int x, int y)
    {
        if (x >= order() || y >= order())
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        else
        {
            if (directed())
            {
                adjList.get(x).add(y);
            }
            else
            {
                adjList.get(x).add(y);
                adjList.get(y).add(x);
            }
        }
    }

    /**
     * Access the neighbors of a given vertex.
     * 
     * @param vertex
     *    a vertex in the graph 
     * 
     * @return an iterator to the neighbors of vertex, throws
     *   an IndexOutOfBoundsException if vertex >= order() 
     *
     */
    public Iterator<Integer> neighborIterator(int vertex)
    {
        if (vertex >= order())
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return adjList.get(vertex).iterator();
    }
    
    /**
     * Setter method for the number of vertices.
     * 
     * @param order
     */
    public void setOrder(int order) 
    {
        this.order = order;    
    }

    /**
     * Accessor method for the number of vertices.
     * 
     * @return the number of vertices in the graph
     */
    public int order()
    {
        return order;
    }
    
    /**
     * Setter method for the number of edges.
     *
     * @param size
     */
    public void setSize(int size)
    {
        this.size = size;
    }

    /**
     * Accessor method for the number of edges.
     * 
     * @return the number of edges in the graph
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Setter method to determine if a graph is directed.
     *
     * @param directed
     */
    public void setDirected(boolean directed)
    {
         this.directed = directed;
    }
    
    /**
     * Accessor method to see if the graph is directed. 
     *
     * @return true if the graph is directed 
     */
    public boolean directed()
    {
        return directed;
    }

}