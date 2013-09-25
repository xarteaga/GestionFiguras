
public class Triangulo extends Figura {
	private double h;
	private double b;
	
	public Triangulo (double h, double b){
		super();
		this.h = h;
		this.b = b;
	}

	public double area() {
		// TODO Auto-generated method stub
		return (h*b/2);
	}
	
}
