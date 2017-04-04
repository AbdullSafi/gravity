package dal.gravity;

public class GravityConstant implements GravityModel{
	 
	double grConst;
 
	public GravityConstant(double g)
	{
		grConst = g ;
	}
	
	public double getGravitionalField() {return grConst;}
	
	public void setGravitionalField(GravityConstant newGr) {grConst = newGr.getGravitionalField();}

}
