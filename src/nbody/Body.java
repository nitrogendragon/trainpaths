package nbody;

import edu.princeton.cs.StdDraw;
import java.awt.Color;


/**
 * ****************************************************************************
 * Compilation: javac Body.java Execution: java Body Dependencies: Vector.java
 * StdDraw.java
 *
 * Implementation of a 2D Body with a position, velocity and mass.
 *
 *
 *****************************************************************************
 */
public class Body {

    private final double diameter; // planet size
    private Vector r;      // position
    private Vector v;      // velocity
    private final double mass;   // mass
    private final Color color;  // color
    private final double universeradius; //radius of universe

    /**
     *
     * @param r//position of body initial
     * @param v//velocity of body
     * @param diameter//diameter of body
     * @param mass//mass of body
     * @param color//color of body
     * @param universeradius// radius of universe
     */
    public Body(Vector r, Vector v, double diameter, double mass, Color color, double universeradius) {//added color to body
        this.r = r;
        this.v = v;
        this.diameter = diameter;
        this.mass = mass;
        this.color = color;
        this.universeradius = universeradius;
    } // Body( Vector, Vector, double, color )

    /**
     *
     * @param f//?
     * @param dt//?
     */
    public void move(Vector f, double dt) {
        Vector a = f.times(1 / mass);
        setVelocity(getVelocity().plus(a.times(dt)));
        r = r.plus(getVelocity().times(dt));
        
        double xCoord = this.r.cartesian(0);
        double yCoord = this.r.cartesian(1);
        if (xCoord > universeradius || xCoord < -universeradius){
            // reverse x velocity
            double[] factors = {-1.0, 1.0};
            this.v = this.v.times(factors);
        }
        if (yCoord > universeradius || yCoord < -universeradius){
            // reverse y velocity
            double[] factors = {1.0, -1,0};
            this.v = this.v.times(factors);
        }
            

    } // move( Vector, double )

    /**
     *
     * @param b//?
     * @return//?
     */
    public Vector forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    } // forceFrom( Body )

    /**
     *
     */
    public void draw() {
        StdDraw.setPenColor(color);//adds color to drawing
        StdDraw.setPenRadius(this.diameter);//new size of planets
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    }

    /**
     * @return the v
     */
    public Vector getVelocity() {
        return v;
    }

    /**
     * @param v the v to set
     */
    public void setVelocity(Vector v) {
        this.v = v;
    }
} 
// draw()
