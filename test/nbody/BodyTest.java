/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbody;

import java.awt.Color;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class BodyTest {
    
    public BodyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of move method, of class Body.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        double[] vecVal = {2, 2};
        Vector f = new Vector(2);
        double dt = 2.0;
        
        Body instance = new Body(new Vector(vecVal),new Vector(vecVal),5,5, Color.RED, 100 );
        instance.move(f, dt);
        
    }

    /**
     * Test of forceFrom method, of class Body.
     */
    @Test
    public void testForceFrom() {
        System.out.println("forceFrom");
        Body b = null;
        Body instance = null;
        Vector expResult = null;
        Vector result = instance.forceFrom(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class Body.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        double[] vecVal = {2, 2};
        Body instance = new Body(new Vector(vecVal),new Vector(vecVal),5,5, Color.RED, 100 );
        instance.draw();
       
    }

    /**
     * Test of getVelocity method, of class Body.
     */
    @Test
    public void testGetVelocity() {
        System.out.println("getVelocity");
        double[] vecVal = {2, 2};
        Body instance = new Body(new Vector(vecVal),new Vector(vecVal),5,5, Color.RED, 100 );
        Vector expResult = new Vector(vecVal) ;
        Vector result = instance.getVelocity();
        assertEquals(expResult.cartesian(0), result.cartesian(0), .001);
        assertEquals(expResult.cartesian(1), result.cartesian(1),.001);
       
    }

    /**
     * Test of setVelocity method, of class Body.
     */
    @Test
    @SuppressWarnings("empty-statement")
    public void testSetVelocity() {
        System.out.println("setVelocity");
        double[] vecVal = {2, 2};
        Vector v = new Vector(vecVal);
        Body instance = new Body(new Vector(vecVal),new Vector(vecVal),5,5, Color.RED, 100 );
        instance.setVelocity(v);
      
    }
    
}
