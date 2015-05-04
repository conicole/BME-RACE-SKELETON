import java.util.ArrayList;


class Vertex implements Comparable<Vertex>
{
    public final Segment seg;
    public ArrayList<Edge> adjacencies = new ArrayList<Edge>();
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(Segment s) { seg = s; }
    public Segment getSegment() { return seg; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}