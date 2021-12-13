package api;



import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class DWgraph implements DirectedWeightedGraph {
    private HashMap<Integer, NodeData> NodeMap;
    private HashMap<Integer, HashMap<Integer, EdgeData>> EdgeMap;
    private HashMap<Integer, HashMap<Integer, EdgeData>> Map_for_dest;
    private int edge_size;
    private int MC;


    public DWgraph() {
      this.MC = 0;
      this.NodeMap = new HashMap <Integer, NodeData>();
      this.EdgeMap = new HashMap <Integer, HashMap <Integer, EdgeData>>();
      this.Map_for_dest = new HashMap <Integer, HashMap <Integer, EdgeData>> ();
      this.edge_size = 0;

     }

    public DWgraph(String filename) throws FileNotFoundException {
        NodeMap = new HashMap<Integer, NodeData>();
        EdgeMap = new HashMap<Integer, HashMap<Integer, EdgeData>>();
        Map_for_dest = new HashMap<Integer, HashMap<Integer, EdgeData>>();


        //load file and build listNode
        JSONArray Nodes_array = null;
        JSONArray Edge_array = null;


        try {
            Object obj = new JSONParser().parse(new FileReader(filename));
            JSONObject jo = (JSONObject) obj;
            JSONArray edges_array = (JSONArray) jo.get("Edges");
            JSONArray Node_array = (JSONArray) jo.get("Nodes");


            Iterator itr2 = edges_array.iterator();

            while (itr2.hasNext()) {
                //Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();

                Map m = (Map) itr2.next();

                int src = (int) (long) m.get("src");
                int dest = (int) (long) m.get("dest");
                double w = (double) m.get("w");

                Edge ed = new Edge(src, dest, w);
                HashMap<Integer, EdgeData> h1 = new HashMap<Integer, EdgeData>();
                h1.put(dest, ed);
                HashMap<Integer, EdgeData> h2 = new HashMap<Integer, EdgeData>();
                h2.put(src, ed);

                this.EdgeMap.put(src, h1);
                this.Map_for_dest.put(dest, h2);
            }


            Iterator iter = Node_array.iterator();

            while (iter.hasNext()) {
                //Iterator<Map.Entry> itr = ((Map) iter.next()).entrySet().iterator();
                Map m1 = (Map) iter.next();

                String pos = (String) m1.get("pos");
                String[] pos1 = pos.split(",");
                double x = Double.valueOf(pos1[0]);
                double y = Double.valueOf(pos1[1]);
                double z = Double.valueOf(pos1[2]);
                int id = (int) (long) m1.get("id");


                Glocation g = new Glocation(x, y, z);
                Node n = new Node(id, g);
                this.NodeMap.put(id, n);


            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public DWgraph(DWgraph g) {
        this.NodeMap = new HashMap<Integer, NodeData>(g.NodeMap);
        this.EdgeMap = new HashMap<Integer, HashMap<Integer, EdgeData>>(g.EdgeMap);
        this.MC = g.MC;
    }



    @Override
    //return the NodeData by the node_id, null if none.
    public NodeData getNode(int key) {
        if (NodeMap.containsKey(key)) {
            return NodeMap.get(key);
        } else return null;
    }

    @Override
    //returns the data of the edge (src,dest), null if none.
    public EdgeData getEdge(int src, int dest) {
        if (!(EdgeMap.containsKey(src) && EdgeMap.get(src).containsKey(dest))) {
            return null;
        } else {
            return EdgeMap.get(src).get(dest);
        }
    }

    @Override
    //adds a new node to the graph with the given node_data in O(1) time.
    public void addNode(NodeData n) {
        NodeMap.put(n.getKey(), n); //add n to Nodes.
        HashMap<Integer, EdgeData> edges = new HashMap<>();
        HashMap<Integer, EdgeData> edges2 = new HashMap<>();
        EdgeMap.put(n.getKey(), edges);
        Map_for_dest.put(n.getKey(), edges2);
        MC++;
    }
        // to check
        @Override
        //Connects an edge with weight w between node src to node dest
        //positive weight representing the cost (aka time, price, etc) between src-->dest.

        public void connect ( int src, int dest, double w){
            if(w<=0)
                throw new RuntimeException("ERR: The weight should be larger than 0");
            if(src==dest)
                throw new RuntimeException("ERR: The nodes should be different");

            if (getNode(dest) != null && getNode(src) != null && src != dest) {
                Edge Edge = new Edge(src, dest, w);
                if (EdgeMap.get(src).containsKey(dest)==true) {
                    edge_size--;}

                EdgeMap.get(src).put(dest, Edge);
                Map_for_dest.get(dest).put(dest, Edge);
                edge_size++;
                MC++;
            }
        }


        @Override
        //This method returns an Iterator for the collection representing all the nodes in the graph.
        //Note: if the graph was changed since the iterator was constructed - a RuntimeException should be thrown.
        public Iterator<NodeData> nodeIter () {
            Iterator<NodeData> iter = this.NodeMap.values().iterator();
            return iter;
        }

        @Override
        public Iterator<EdgeData> edgeIter ( int node_id){
            Iterator<EdgeData> Iter = EdgeMap.get(node_id).values().iterator();
            return Iter;
        }

        @Override
        public Iterator<EdgeData> edgeIter () {
            List<EdgeData> ans = new ArrayList<>();
            for (NodeData n : NodeMap.values()) {
                ans.addAll(EdgeMap.get(n.getKey()).values());
            }
            return ans.iterator();
        }

        @Override
        //Deletes the node (with the given ID) from the graph -and removes all edges which starts or ends at this node.
        //This method should run in O(k), V.degree=k, as all the edges should be removed.
        public NodeData removeNode ( int key){
            if (getNode(key) == null){
                return null;
            }
                if(EdgeMap.get(key) == null) {
                return null;
            }
            //change the number off edges to like the number of edges coming out
            Iterator<EdgeData> iterGraph = edgeIter(key);
            while (iterGraph.hasNext()) {
                iterGraph.next();
                edge_size--;
                MC++;
            }
            //change the number off edges to like the number of edges coming in .
            for (int e : Map_for_dest.get(key).keySet()) {
                edge_size--;
                MC++;
            }
            NodeData removeNode = NodeMap.get(key);
            NodeMap.remove(key);
            EdgeMap.remove(key);
            Map_for_dest.remove(key);
            MC++;
            return removeNode;
        }


        @Override
        //	Deletes the edge from the graph,run on o(1) time
        public EdgeData removeEdge ( int src, int dest){
            if (EdgeMap.get(src) == null || EdgeMap.get(src).get(dest) == null) {
                return null;
            }
            EdgeData deleteEdge = EdgeMap.get(src).get(dest);
            EdgeMap.get(src).remove(dest);      //remove src to dest
            Map_for_dest.get(dest).remove(src); //remove dest to src
            edge_size--;
            MC++;
            return deleteEdge;
        }

        @Override
        // Returns the number of vertices (nodes) in the graph.
        public int nodeSize () {
            return this.NodeMap.size();
        }

        @Override
        //Returns the number of edges (assume directional graph).
        public int edgeSize () {
            return this.edge_size;
        }

        @Override
        //Returns the Mode Count - for testing changes in the graph.
        public int getMC () {
            return MC;
        }


}