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
    private  static final double Infi=Double.POSITIVE_INFINITY;

    //Inits the graph on which this set of algorithms operates on.
    @Override
    public void init(DirectedWeightedGraph g) {

    }

    // Returns the underlying graph of which this class works.
    @Override
    public DirectedWeightedGraph getGraph() {
        return this.g = g;
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
        return false;
    }

    @Override
    //Computes the length of the shortest path between src to dest
    public double shortestPathDist(int src, int dest) {

        List<NodeData> temp = shortestPath(src, dest);
        if (temp == null)
            return -1;

        if (this.g.getNode(dest).getWeight() != Infi){
            return this.g.getNode(dest).getWeight();}

        return -1;
    }
    private void Dijkstra(Node src, Node dest) {
        Iterator<NodeData> i= g.nodeIter();
        while (i.hasNext()) {
            Node data = (Node) i.next();
            data.setWeight(Infi);
            data.setFather(null);
        }
        src.setWeight(0);
        PriorityQueue<NodeData> q = new PriorityQueue<>(Comparator.comparing(NodeData::getWeight));
        //src.setInfo("Black");
        Node n = src;
        q.add(n);
        while (!(q.isEmpty())) {
            NodeData nada = q.poll();
            if (nada.getInfo() == null) {
                if(nada.getKey()==dest.getKey()){
                    return;
                }
                nada.setInfo("Black");
                Iterator<EdgeData> iter = g.edgeIter(nada.getKey());
                while (iter.hasNext()) {
                    EdgeData e = iter.next();
                    NodeData a = this.g.getNode(e.getDest());
                    rel(e);
                    q.add(a);

                }

            }
        }
    }
    public void rel(EdgeData e) { //updata the father and the true w
        Node src=(Node) this.g.getNode(e.getSrc());
        Node dest=(Node) this.g.getNode(e.getDest());
        if(dest.getWeight()> src.getWeight()+e.getWeight()){
            dest.setWeight(src.getWeight()+e.getWeight());
            dest.setFather(src);
        }
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        Node Src = (Node) g.getNode(src);
        Node Dest = (Node) g.getNode(dest);
        Dijkstra(Src,Dest);
        List<NodeData> ans=new ArrayList<>();
        while (Dest.getFather()!=null){
            ans.add(Dest);
            Dest= (Node) Dest.getFather();
        }
        ans.add(Src);
        Collections.reverse(ans);
        return ans;

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
            Gson g = new GsonBuilder().setPrettyPrinting().create();
            FileWriter w = new FileWriter(file);
            FormalGraph f = new FormalGraph(this);
            g.toJson(f, w);
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
        this.g = new DWgraph(file);
        if (g != null) {
            return true;
        } else {
            return false;
        }
    }
}
