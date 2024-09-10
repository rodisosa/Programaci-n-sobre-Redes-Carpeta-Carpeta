import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_1_07 {

	public static void main(String[] args) {
		int num=0;
		boolean error = false;
		Scanner s = new Scanner(System.in);
		
		do {
			error=false;
			System.out.println("Ingrese un número");
			try {
				num = s.nextInt();
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
		
		if(num%2==0){
			System.out.println("Su número es par");
		} else {
			System.out.println("Su número es impar");
		}
		
		s.close();

	}

}
