package api;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class GlocationTest {


        GeoLocation gl = new Glocation(2.0, 4.0, 6.0);
        GeoLocation gl1 = new Glocation(4.0,8.0 ,12.0);

        @Test
        void x () {
            assertEquals(2.0, gl.x());
        }

        @Test
        void y () {
            assertEquals(4.0, gl.y());
        }

        @Test
        void z () {
            assertEquals(6.0, gl.z());
        }

        @Test
        void distance() {
            double dis = (Math.sqrt(14))*2;
            assertEquals(dis,gl.distance(gl1));
        }
    }

