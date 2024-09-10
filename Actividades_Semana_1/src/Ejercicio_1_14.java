import java.util.Scanner;

public class Ejercicio_1_14 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char letra;
		boolean error = false;
		
		do {
			error = false;
			System.out.println("Ingrese una letra:");
			letra=s.next().charAt(0);		
			String dato = Character.toString(letra);
			if(dato.matches("[A-Za-z]*")) {
				if(dato.matches("[AEIOUaeiou]")) {
					System.out.println("Es vocal");
					
				}else {
					System.out.println("Es consonante");
				}
			}else {
				error=true;
				System.out.println("|Error|, ingrese una letra");
			}
		}while(error);
		s.close();

	}

}
