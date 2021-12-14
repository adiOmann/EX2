### EX2
Written by Adi Finkelman and Adi Miller

Introduction In this project we performed object programming of a weighted directed graph. The project consist 5 classes, 3 interfaces and 3 test class. The project implemented a number of algorithms of operations that can be done on graphs. At the end of the project we created a graph ourselves that implemented all the functions and algorithms we wrote.


![](src/d6496dbd-fa14-4874-a98a-c4b7bd69a4d9.jfif)


## #DWGAlgo Class

This class is an implementation of DirectedWeightedGraphAlgorithms interface. This class represents a Direct Weighted Graph Theory Algorithm. init - This function inits the graph on which this set of algorithms operates on. getGraph - This function returns the underlying graph of whic this class works. copy - Computes a deep copy of this weighted graph. isConnected - Returns true if and only if (iff) there is a valid path from each node to each other node. shortestPathDist - Computes the length of the shortest path between src to dest. The method used Dijkstra's algorithms. shortestPath - returns the shortest path between src to dest - as an ordered List of nodes:src --> n1 --> n2 --> ... --> dest. save - saves this weighted directed graph to the given file name. load - loads a graph to this graph algorithm.

### Auxiliary functions

Dijkstra (NodeData src, NodeData dest) - This function based on Dijkstra algorithm. The function is an algorithm for finding the shortest paths between nodes in a graph.

### DWgraph Class

This class is an implementation of DirectedWeightedGraph interface. This class represents a Direct Weighted Graph. getNode - This function get int- key and returns the NodeData. ##### complexity: O(1). getEdge - This function get two int- src and dest and returns the data of edge. ##### complexity: O(1). addNode - Adds a new node to the graph with the given NodeData. ##### complexity: O(1). connect - Connects an edge with weight w between node src to node dest. ##### complexity: O(1). nodeIter - his method returns an Iterator for the collection representing all the nodes in the graph. The iterator include NodeData. edgeIter - This method returns an Iterator for all the edges in this graph. The iterator include EdgeData. edgeIter(int node_id) - This method returns an Iterator for edges getting out of the given node (all the edges starting (source) at the given node). removeNode - This function get a int the represent id of Node and remove thie Node and all edges which starts or ends at this node. removeEdge - This function get a src and dest and remove the edge between them. #####complexity: O(1). nodeSize - Returns the number of nodes in the graph. edgeSize - Returns the number of edges in the graph. getMC - Returns the Mode Count - for testing changes in the graph.

## NodeData Interface

This interface represents the set of operations applicable on a node in a directional weighted graph.

## EdgeData Interface

This interface represents the set of operations applicable on a directional edge (src,dest) in a directional weighted graph.

## GeoLocation Interface

This interface represents a geolocation <x,y,z>.


