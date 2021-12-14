package api;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

 class NodeTest {


        Glocation g1 = new Glocation(1.0,2.0,3.0);
        Glocation g2 = new Glocation(1.5,2.5,3.5);
        Glocation g3 = new Glocation(0.0,2.0,4.0);
        Glocation g4 = new Glocation(1.8,7.0,5.4);
        Glocation g5 = new Glocation(2.2,3.3,4.4);

        Node n1 = new Node (1,g1);
        Node n2 = new Node (2,g2);
        Node n3 = new Node (3,g3);
        Node n4 = new Node (4,g4);
        Node n5 = new Node (5,g5);

        @Test
        void getKey() {
            assertEquals(1,n1.getKey());
        }

        @Test
        void getLocation() {
            assertEquals(1.5, n2.getLocation().x());
            assertEquals(2.5, n2.getLocation().y());
            assertEquals(3.5, n2.getLocation().z());
        }

        @Test
        void setLocation() {
            Glocation g = new Glocation(10,20,30);
            n3.setLocation(g);
            assertEquals (10,n3.getLocation().x());
            assertEquals (20,n3.getLocation().y());
            assertEquals (30,n3.getLocation().z());
        }

        @Test
        void getWeight() {
            assertEquals(9.1,n5.getWeight());
        }

        @Test
        void setWeight() {
            n3.setWeight(8.3);
            assertEquals(8.3,n3.getWeight());
        }

        @Test
        void getInfo() {
            assertEquals("n4", n4.getInfo());
        }

        @Test
        void setInfo() {
            n2.setInfo("Hi");
            assertEquals("Hi", n2.getInfo());
        }

        @Test
        void getTag() {
            assertEquals(3, n3.getTag());
        }

        @Test
        void setTag() {
            n1.setTag(7);
            assertEquals(7,n1.getTag());
        }
    }


