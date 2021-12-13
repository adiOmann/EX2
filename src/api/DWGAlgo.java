package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//This interface represents a Directed (positive) Weighted Graph Theory Algorithms
public class DWGAlgo implements DirectedWeightedGraphAlgorithms {

    private DirectedWeightedGraph g;

    //Inits the graph on which this set of algorithms operates on.
    @Override
    public void init(DirectedWeightedGraph g) {

    }
   // Returns the underlying graph of which this class works.
    @Override
    public DirectedWeightedGraph getGraph()
    {
        return this.g=g;
    }

    @Override
    //Computes a deep copy of this weighted graph
    public DirectedWeightedGraph copy() {
        Iterator it = this.g.nodeIter();

        while (it.hasNext()) {
            Node i = (Node) it.next();
            g.addNode(i);
        }
            return this.g;
        }

    @Override
    //Returns true if and only if (iff) there is a valid path from each node to each
    // other node. NOTE: assume directional graph (all n*(n-1) ordered pairs).
    public boolean isConnected() {

    }
    @Override
    //Computes the length of the shortest path between src to dest
    public double shortestPathDist(int src, int dest) {
       return src; //temp
    }

    private double Dijkstra (Node src, Node dest,DWgraph g) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        src.setInfo("Black");
        Node n=src;
        Iterator iter=g.edgeIter();

        while(!(q.isEmpty())){


        while (!q.isEmpty()) {
            Node flag = (Node) q.poll();

        }
           return shortest;//temp
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return null;
    }

    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    //Saves this weighted (directed) graph to the given
    //file name - in JSON format
    public boolean save(String file) {
try {
    Gson g=new GsonBuilder().setPrettyPrinting().create();
    FileWriter w=new FileWriter(file);
    FormalGraph f=new FormalGraph(this);
    g.toJson(f,w);
    return true;


} catch (IOException e) {
    e.printStackTrace();
    return false;
}
    }
    //This method loads a graph to this graph algorithm.
    //if the file was successfully loaded - the underlying graph
    @Override
    public boolean load(String file) throws FileNotFoundException {
        this.g= new DWgraph(file);
        if(g!=null){
        return true ;}
        else{
            return false;
            }
    }
}
