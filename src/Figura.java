import java.io.Serializable;


public abstract class Figura implements Comparable<Figura>, Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int compareTo (Figura fig){
		return Double.compare(this.area(), fig.area());
	}
	
	public abstract double area ();
}
