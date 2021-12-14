package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    class EdgeTest {

        Edge e1 = new Edge (2,4,6.7);
        Edge e2 = new Edge (1,3,8.3);
        Edge e3 = new Edge (5,7,10.2);
        Edge e4 = new Edge (9,10,22.1);
        Edge e5 = new Edge (7,5,9.4);

        @Test
        void getSrc() {
            assertEquals(2,e1.getSrc());
            assertEquals(7,e5.getSrc());
        }

        @Test
        void getDest() {
            assertEquals(3,e2.getDest());
            assertEquals(10,e4.getDest());
        }

        @Test
        void getWeight() {
            assertEquals(8.3,e2.getWeight());
            assertEquals(10.2,e3.getWeight());
        }

        @Test
        void getInfo() {
            assertEquals("e4",e4.getInfo());
            assertEquals("e5",e5.getInfo());
        }

        @Test
        void setInfo() {
            e1.setInfo("Java");
            assertEquals("Java",e1.getInfo());
            e2.setInfo("Python");
            assertEquals("Python",e2.getInfo());
        }

        @Test
        void getTag() {
            assertEquals(3,e4.getTag());
            assertEquals(2,e3.getTag());
        }

        @Test
        void setTag() {
            e4.setTag(7);
            assertEquals(7,e4.getTag());
            e3.setTag(10);
            assertEquals(10,e3.getTag());
        }
    }

