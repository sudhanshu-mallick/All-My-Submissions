import java.util.Scanner;

public class Vus_the_Cossack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		
		int a = t.nextInt();
		int b = t.nextInt();
		int c = t.nextInt();
		
		if (a <= b && a <= c)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
