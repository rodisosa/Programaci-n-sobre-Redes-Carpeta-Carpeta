import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_1_08 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error=false;
		int res;
		int numUno = 0;
		int numDos = 0;

		do {
			error=false;
			System.out.println("Ingrese el primer número:");
			try {
				numUno=s.nextInt();
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
		
		do {
			error=false;
			System.out.println("Ingrese el segundo número:");
			try {
				numDos=s.nextInt();
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
		
		res = numUno%numDos;
		if (res==0) {
		  System.out.println(numUno+" Es múltiplo de: "+numDos);
		} else {
		  System.out.println(numUno+" No es múltiplo de: "+numDos);
		}
		s.close();

	}

}
