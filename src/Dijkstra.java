import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


public class Dijkstra
{
    public static void computePaths(Vertex source)
    {	//initializes min distance
        source.minDistance = 0.;
        //create a priority queue
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
      	//adds source
        vertexQueue.add(source);
        
	while (!vertexQueue.isEmpty()) {
	    Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
		  //if we find small v
            if (distanceThroughU < v.minDistance) {
		    vertexQueue.remove(v);
		    v.minDistance = distanceThroughU ; //set min distance
		    v.previous = u;//set previous
		    vertexQueue.add(v); //add
		}
            }
        }
    }
    
    //gets shorts part to every vertex in the graph
    public static List<Vertex> getShortestPathTo(Vertex target)
    {
    	//builds arraylist of path to a given vertex using shortest part
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);//adds vertices
        Collections.reverse(path);
        return path;
    }


}
