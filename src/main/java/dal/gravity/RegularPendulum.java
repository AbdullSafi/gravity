package dal.gravity;

/**
 * Represents a pendulum
 */
public class RegularPendulum extends AbstractPendulum {
    private double delta, iterations = 0;
    private double dissipation;
    private double lastTheta, lastVel, lastAccel;
    private GravityConstant grField;
   // private gravity

    /**
     * Creates a new Pendulum instance 
     */
    public RegularPendulum (double inLength, double inMass, double inTheta0, 
		     double inDelta, double inDiss,GravityConstant gravity) {
	super (inLength, inMass, inTheta0, grField.getGravitationalField ());
	delta=inDelta;
	dissipation = inDiss;
	lastVel = 0;
	lastTheta = this.getMaxAngularDisplacement ();
	lastAccel = -(grField.getGravitationalField () / this.getStringLength ())*Math.sin (lastTheta);
    }

    public RegularPendulum (double inLength, double inMass, double inTheta0, 
		     double inDelta) {
	this (inLength, inMass, inTheta0, inDelta, 0);
    }

    public void step () {
	iterations++;
	lastTheta = lastTheta + lastVel*delta;
	lastVel = lastVel + lastAccel*delta;
	lastAccel = - dissipation*lastVel - grField.getGravitationalField () / this.getStringLength () * Math.sin (lastTheta);
    }

    public double getLastTheta () { return lastTheta; }
    public double getLastVelocity () { return lastVel; }
    public double getLastAcceleration () { return lastAccel; }
    public double getLastTime () { return iterations*delta; }
    public double getDissipationConstant () { return dissipation; }
    

}
