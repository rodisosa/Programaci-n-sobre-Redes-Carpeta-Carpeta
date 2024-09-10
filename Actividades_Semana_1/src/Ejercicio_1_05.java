import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_1_05 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error = false;
		int numUno = 0;
		int numDos = 0;
		int numTres = 0;
		int resultI = 0;
			
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
		
		do {
			error=false;
			System.out.println("Tercer un número entero:");
			try {
				numTres = s.nextInt();
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
		
		System.out.println("+--------------------------+");
		
		if(numUno>numDos && numUno>numTres) {
			System.out.println("El primer número es el mayor");
			if(numDos>numTres) {
				System.out.println("El tercer número es el menor");
			}else if(numDos<numTres){
				System.out.println("El segundo número es el menor");
			}else {
				System.out.println("El segundo número y el tercer número son iguales");
			}
		}else if(numDos> numUno && numDos>numTres) {
			System.out.println("El Segundo número es el mayor");
			if(numUno>numTres) {
				System.out.println("El tercer número es el menor");
			}else if(numUno<numTres){
				System.out.println("El primer número es el menor");
			}else {
				System.out.println("El primer número y el tercer número son iguales");
			}
		}else if(numTres>numUno && numTres>numDos) {
			System.out.println("El Tercero número es el mayor");
			if(numUno>numDos) {
				System.out.println("El segundo número es el menor");
			}else if(numUno<numDos){
				System.out.println("El primer número es el menor");
			}else {
				System.out.println("El segundo número y el primer número son iguales");
			}
		}else {
			System.out.println("Todos son iguales");
		}
		
		System.out.println("+--------------------------+");
		
		resultI=numUno+numDos+numTres;
		System.out.println(numUno+" + "+numDos+" + "+numTres+" = "+resultI);
		resultI=0;
		resultI=(numUno*numDos)*numTres;
		System.out.println("("+numUno+" x "+numDos+") x "+numTres+" = "+resultI);
		resultI=0;
		resultI=(numUno+numDos+numTres) / 3 ;
		System.out.println("El promedio de: "+numUno+", "+numDos+" y "+numTres+" es: "+resultI);
		resultI=0;	
		s.close();

	}

}
