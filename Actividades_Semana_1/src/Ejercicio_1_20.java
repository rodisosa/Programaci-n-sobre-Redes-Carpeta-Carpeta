import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_1_20 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error=false;
		int num=0;
		float res=0;
		
		do {
			error=false;
			System.out.println("Ingrese un número:");
			try {
				num = s.nextInt();
			}catch(InputMismatchException e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}catch(Exception e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}
			if(!error) {
				if(num<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
		}}}while(error);
		
		for(int i=1; i<=num; i++) {
			
			res+=(1/(float)i);
		}
		
		System.out.println("El resultado es: "+res);
		s.close();
	}

}
