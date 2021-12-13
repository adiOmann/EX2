package api;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class DWgraphTest {

    @org.junit.jupiter.api.Test
    void getNode() {
    }

    @org.junit.jupiter.api.Test
    void getEdge() {
    }

    @org.junit.jupiter.api.Test
    void addNode() {
    }

    @org.junit.jupiter.api.Test
    void connect() {
    }

    @org.junit.jupiter.api.Test
    void nodeIter() {
    }

    @org.junit.jupiter.api.Test
    void edgeIter() {
    }

    @org.junit.jupiter.api.Test
    void testEdgeIter() {
    }

    @org.junit.jupiter.api.Test
    void removeNode() {
    }

    @org.junit.jupiter.api.Test
    void removeEdge() {
    }

    @org.junit.jupiter.api.Test
    void nodeSize() {
    }

    @org.junit.jupiter.api.Test
    void edgeSize() {
    }

    @org.junit.jupiter.api.Test
    void getMC() {
    }

    @org.junit.jupiter.api.Test
    void main() throws FileNotFoundException {
        //DWgraph g= new DWgraph("C:/Users/adi.fin45/Desktop/jsons/G1.json");
        DWGAlgo da = new DWGAlgo();
        da.load("C:/Users/adi.fin45/Desktop/jsons/G1.json");
        da.save("C:/Users/adi.fin45/Desktop/jsons/G1_res.json");

    }
}