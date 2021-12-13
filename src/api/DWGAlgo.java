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
        if(g!=null)
        {
            this.g=g;
        }
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
        if (this.g.nodeSize() == 0) {
            return true; }
        Iterator<NodeData> it = g.nodeIter();
        NodeData node = it.next();
        boolean result=Bfs(node,this.g);
        DirectedWeightedGraph rever = revers((DWgraph) this.g);
        boolean result_revers=Bfs(node,rever);
        return false;
    }
    public boolean Bfs(NodeData s,DirectedWeightedGraph G) {
        Queue<NodeData> q = new LinkedList<>();
        s.setInfo("Black");
        //int c=0;
        q.add(s);
        while (!(q.isEmpty())) {
            NodeData flag = q.poll();
            //Iterator<EdgeData> iter = g.edgeIter(flag.getKey());
            while (G.edgeIter(s.getKey()).hasNext()) {
                EdgeData e = G.edgeIter(s.getKey()).next();
                NodeData n = this.g.getNode(e.getDest());
                if (n.getInfo().equals("white")) {
                    n.setInfo("Black");
                    q.add(n);
                }
            }
            flag.setInfo("Black");
            while (G.nodeIter().hasNext()){
                NodeData node = g.nodeIter().next();
                if(node.getInfo().equals("white")){
                    return false;}
                }
            }
        return true;

    }
    public DirectedWeightedGraph revers(DWgraph g){
        DirectedWeightedGraph NewOne = new DWgraph();
        Iterator<NodeData> nodeDataIterator =g.nodeIter();
        Iterator<EdgeData> EdgeDataIterator =g.edgeIter();

        while(nodeDataIterator.hasNext()) {
            NodeData n = nodeDataIterator.next();
            NewOne.addNode(new Node(n.getKey(), n.getLocation()));
        }
        while (EdgeDataIterator.hasNext()){
               EdgeData e= EdgeDataIterator.next();
               NewOne.connect(e.getDest(),e.getSrc(),e.getWeight());
            }
            return NewOne;
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
        Iterator<NodeData> i= g.nodeIter(); //the all child off the Node
        while (i.hasNext()) {
            Node data = (Node) i.next();
            data.setWeight(Infi);   //restart the weight
            data.setFather(null);   //restart the father to be null
        }
        src.setWeight(0);
        PriorityQueue<NodeData> q = new PriorityQueue<>(Comparator.comparing(NodeData::getWeight));
        //src.setInfo("Black");
        Node n = src;
        q.add(n);  //add the src
        while (!(q.isEmpty())) {
            NodeData nada = q.poll();
            if (nada.getInfo() == null) {
                if(nada.getKey()==dest.getKey()){ //break
                    return;
                }
                nada.setInfo("Black");
                Iterator<EdgeData> iter = g.edgeIter(nada.getKey());
                while (iter.hasNext()) {
                    EdgeData e = iter.next();
                    NodeData a = this.g.getNode(e.getDest());
                    rel(e);  //help function
                    q.add(a);

                }

            }
        }
    }
    public void rel(EdgeData e) { //update the father and the true w
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
        while (Dest.getFather()!=null){   // inside tha all the new w off the Node to the list
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
