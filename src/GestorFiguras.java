import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class GestorFiguras {

	public static double suma(Figura[] figuras) {

		double sum = 0;

		for (Figura f : figuras) {
			sum += f.area();
		}

		return sum;
	}

	public static Figura[] sort(Figura[] figuras) {
		Arrays.sort(figuras);
		return figuras;
	}

	public static void main(String[] args) {

		Figura[] figuras = new Figura[4];

		figuras[0] = new Rectangulo(5, 3);
		figuras[1] = new Cuadrado(5);
		figuras[2] = new Circulo(7);
		figuras[3] = new Triangulo(7, 8);

		// TODO Auto-generated method stub
		System.out.println("Bienvenido a mi gestor de figuras!");
		System.out.println("-------------------------------------------------");

		System.out.println("El area es " + suma(figuras) + ".");

		System.out.print("Areas sin orden: ");
		for (Figura f : figuras) {
			System.out.print(String.format("%.3f", f.area()) + "; ");
		}
		System.out.print("\n");

		sort(figuras);

		System.out.print("Areas con orden: ");
		for (Figura f : figuras) {
			System.out.print(String.format("%.3f", f.area()) + "; ");
		}
		System.out.print("\n");
		
		/*
		 * Parse File
		 */
		try (
			OutputStream file = new FileOutputStream("quarks.ser");
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
		){
			output.writeObject(figuras);
		}  
		catch(IOException ex){
			System.out.println("ERROR: fichero no existente...\n");
		}
		
	    //deserialize the quarks.ser file
	    try(
	      InputStream file = new FileInputStream("quarks.ser");
	      InputStream buffer = new BufferedInputStream(file);
	      ObjectInput input = new ObjectInputStream (buffer);
	    ){
	      //deserialize the List
	    	Figura[] recoveredFiguras = (Figura[])input.readObject();
	      //display its data
			System.out.print("Areas con orden: ");
			for (Figura f : recoveredFiguras) {
				System.out.print(String.format("%.3f", f.area()) + "; ");
			}
			System.out.print("\n");
	    }
	    catch(ClassNotFoundException ex){
	    	System.out.println("Cannot perform input. Class not found.");
	    }
	    catch(IOException ex){
	    	System.out.println("Cannot perform input.");
	    }
	}

}
