import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_1_18 {

	public static void main(String[] args) {
		int cont=0;
		Scanner s= new Scanner(System.in);
		int num=0;
		boolean error=false;
		int res=0;
		
		
		do {
			error=false;
			System.out.println("Ingrese un número entero:");
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
		
		res=num;
		while(num>0) {
			num/=10;
			cont++;
		}
		System.out.println("El número "+res+" tiene "+cont+" cifras");
		s.close();

	}

}
