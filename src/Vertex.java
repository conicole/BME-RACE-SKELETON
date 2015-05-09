import java.util.ArrayList;


class Vertex implements Comparable<Vertex>
{
	//abstraction of a vertex
    public final Segment seg;
    public ArrayList<Edge> adjacencies = new ArrayList<Edge>();
    public double minDistance = Double.POSITIVE_INFINITY;//default to infinity
    public Vertex previous;
    public Vertex(Segment s) { seg = s; }//constructor
    public Segment getSegment() { return seg; } //gets segment
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}