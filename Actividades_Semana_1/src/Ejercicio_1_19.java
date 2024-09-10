import java.util.Scanner;

public class Ejercicio_1_19 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i=0, sNum=0, t=0;
		
		int n=6;
		int a=2;
		int r=2;
		
		while(i<=n) {
			
			int res = 1;
		       for (int j = 0; j < i; j++) {
		           res = r * res;
		       }
			t=a*res;
			sNum+=t;
			i++;
		}
		
		System.out.println("S es: "+sNum);
		s.close();
	}

}
