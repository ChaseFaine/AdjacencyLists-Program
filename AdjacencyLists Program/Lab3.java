import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Lab3.
 * 
 * @author Chase Faine 
 * @version Fall 2020 
 * 
 */
public class Lab3
{
    /**
    * Main method.
    */
    public static void main(String[] args)
    {
        try 
        {
            // Reading the filename from the command line.
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);

            // Getting the contents of the first line in the file and splitting it into an array of integers.
            // The first number will be the number of vertices and the second number will determine if it's directed.     
            String firstLine = scanner.nextLine();
            String[] firstLineSplit = firstLine.split(" ");
            int[] firstLineNumbers = new int[firstLineSplit.length];
            for (int i = 0; i < firstLineNumbers.length; i++)
            {
                firstLineNumbers[i] = Integer.parseInt(firstLineSplit[i]);
            }
            int order = firstLineNumbers[0];
            int directedOrNot = firstLineNumbers[1];
            boolean directed = false;
            if (directedOrNot == 1)
            {
                directed = true;
            }
            
            // Creating a new Adjacency List based on the last output.
            AdjacencyLists adjList = new AdjacencyLists(order, directed);

            // Splits the rest of the lines up the same way as previously.
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] lineSplit = line.split(" ");
                int[] lineNumbers = new int[lineSplit.length];
                for (int i = 0; i < lineNumbers.length; i++)
                {
                    lineNumbers[i] = Integer.parseInt(lineSplit[i]);
                }
                int x = lineNumbers[0];
                int y = lineNumbers[1];

                // Check to see if it's the end of the file.
                if (x == -1 && y == -1)
                {
                    break;
                }

                // Adding the numbers as edges to the Adjacency List.
                adjList.addEdge(x, y);
                adjList.setSize(adjList.size() + 1);
            }

            // Printing the neighbors 
            for (int i = 0; i < adjList.order(); i++)
            {
                System.out.print(i + ": ");
                Iterator it = adjList.neighborIterator(i);
                while (it.hasNext())
                {
                    int a = (int)it.next();
                    System.out.print(a + " ");
                }
                System.out.println();
            }

            // Printing the number of edges.
            System.out.println("There are " + adjList.size() + " edges.");
            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found.");
        }
    }
}