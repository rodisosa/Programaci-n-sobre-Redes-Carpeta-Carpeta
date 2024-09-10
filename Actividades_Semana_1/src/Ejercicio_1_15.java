import java.util.Scanner;

public class Ejercicio_1_15 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String numero;
		int num = 0;
		boolean error = false;
		
		do {
			error = false;
			System.out.println("Ingrese una número:");
			numero=s.next();		
			
			if(numero.matches("[A-Za-z]*")) {
				error=true;
				System.out.println("|Error|, ingrese un número");
			}else {
				num=Integer.valueOf(numero);
			}
		}while(error);
		
		if(num>=0 && num<=9) {
			System.out.println("Esta entre el 0 y 9, siendo: "+num);
		} else {
			System.out.println("No esta entre el 0 y 9, siendo: "+num);
		}
		
		s.close();

	}

}
