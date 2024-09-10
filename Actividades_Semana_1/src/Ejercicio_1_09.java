import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_1_09 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int num = 0;
		boolean error = false;
		int ceros = 0;
		int pos = 0;
		int neg = 0;
		
		for(int i=0; i<5; i++) {
			
			do {
				error=false;
				System.out.println("Ingrese un número:");
				try {
					num=s.nextInt();
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
			
			
			if (num==0) {
				ceros++;
			} else if (num>0) {
				pos++;
			} else {
				neg++;
			}
		}
		System.out.println("Hay "+ceros+" ceros, "+pos+" positivos y "+neg+" negativos");
		s.close();

	}

}
