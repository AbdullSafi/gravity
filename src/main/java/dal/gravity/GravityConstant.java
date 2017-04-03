package dal.gravity;

public class GravityConstant implements GravityModel{
 
	double grCons;
 
	public GravityConstant(double g)
	{
		grConst = g ;
	}
	
	public double getGravitionalField(){return grConst};

}