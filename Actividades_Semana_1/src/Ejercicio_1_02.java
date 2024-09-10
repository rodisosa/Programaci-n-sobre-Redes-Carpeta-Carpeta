import java.util.Scanner;

public class Ejercicio_1_02 {

	public static void main(String[] args) {
		boolean error = false;
		Scanner s = new Scanner(System.in);
		String nombre = null;
		String apellido = null;
				
			do {
				error = false;
				System.out.println("Ingrese su Nombre:");
				nombre = s.nextLine();	
				if(nombre.matches("[A-Za-z]*")) {
				}else {
					error=true;
					System.out.println("|Error|");
				}
			}while(error);
			
			do {
				error = false;
				System.out.println("Ingrese su Apellido:");
				apellido = s.nextLine();
				if(apellido.matches("[A-Za-z]*")) {
				}else {
					error=true;
					System.out.println("|Error|");
				}
			}while(error);
			System.out.println("Su nombre y apellido son: " +nombre+ " " +apellido);	
			s.close();

	}

}
