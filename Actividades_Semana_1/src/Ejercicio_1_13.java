
public class Ejercicio_1_13 {

	public static void main(String[] args) {
		int n = 20;
		for(int i=1;i<=n;i++) {
			if(i==1) {
				System.out.println("El nro: "+i+" no es primo");
			} else if(i>1) {
				boolean primo = true; 
			    for(int j = 2; j < i; j++) {
			        if (i % j == 0) {
			            primo = false;
			            break;
			        }
			    }
			    if (primo) {
			    	System.out.println("El nro: "+i+" es primo");
			    } else {
			    	System.out.println("El nro: "+i+" no es primo");
			    }
			}
		}

	}

}
