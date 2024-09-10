
public class Ejercicio_1_17 {

	public static void main(String[] args) {
		int numUno=13;
		int numDos=3;
		float res=0;
		int cont=0;
		
		res=(float)numUno;
		while(res>=numDos) {
			
			res-=(float)numDos;
			cont++;
		}
		System.out.println(numUno+" / "+numDos+" = "+cont+" resto: "+res);

	}

}
