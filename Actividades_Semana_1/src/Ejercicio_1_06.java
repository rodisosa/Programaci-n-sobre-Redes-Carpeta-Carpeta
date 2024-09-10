import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_1_06 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int num = 0;
		int max = 0;
		int min = 0;
		boolean error = false;
		
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
		
			if(i==0) {
				max=num;
				min=num;
			} else if(max<num) {
				max=num;
			} else if(min>num) {
				min=num;
			}
		}
		System.out.println("El mayor es: "+max+" y el menor es: "+min);
		s.close();

	}

}
