import java.util.Scanner;

public class Young_Physist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int x = 0, y = 0, z = 0;

		for (int i = 0; i < n; i++) {
			x += t.nextInt();
			y += t.nextInt();
			z += t.nextInt();
		}

		if (x == 0 && y == 0 && z == 0)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
