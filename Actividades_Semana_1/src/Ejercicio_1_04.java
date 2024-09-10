import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_1_04 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numUno = 0;
		int numDos = 0;
		boolean error = false;
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
		if(numUno>numDos) {
			System.out.println("El primer número es el número mayor y el segundo el menor");
		}else if(numUno<numDos) {
			System.out.println("El segundo número es el número mayor y el primero el menor");
		}else {
			System.out.println("Ambos números son iguales");
		}
		s.close();

	}

}
