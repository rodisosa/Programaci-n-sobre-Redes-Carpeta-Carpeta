import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_1_03 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error = false;

		int numUno = 0;
		int numDos = 0;
		int resultI = 0;
		float resultF = 0;
			
		do {
			error=false;
			System.out.println("Ingrese el primer número entero:");
			try {
				numUno = s.nextInt();
			}catch(InputMismatchException e) {
				error = true;
				System.out.println("|Error|, no ingresó un número");
				s.nextLine();
			}catch(Exception e) {
				error = true;
				System.out.println("|Error|, no ingresó un número");
				s.nextLine();
			}
			}while(error);
		
		do {
			error=false;
			System.out.println("Segundo un número entero:");
			try {
				numDos = s.nextInt();
			}catch(InputMismatchException e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}catch(Exception e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}
			}while(error);
		System.out.println("+--------------------------+");
		resultI=numUno+numDos;
		System.out.println(numUno+" + "+numDos+" = "+resultI);
		resultI=0;
		resultI=numUno-numDos;
		System.out.println(numUno+" - "+numDos+" = "+resultI);
		resultI=0;
		resultI=numUno*numDos;
		System.out.println(numUno+" x "+numDos+" = "+resultI);
		resultI=0;
		resultF= (float)numUno/(float)numDos;
		System.out.println(numUno+" / "+numDos+" = "+resultF);
		resultF=0;
		resultF= (float)numUno%(float)numDos;
		System.out.println(numUno+" % "+numDos+" = "+resultF);
		resultF=0;
		System.out.println("+--------------------------+");
		s.close();

	}

}
