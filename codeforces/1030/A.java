import java.util.Scanner;

public class In_Search_Of_Easy_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		
		int n = t.nextInt();
		int a;
		boolean ans = false;
		
		while (n-- > 0) {
			a = t.nextInt();
			
			if (a == 1)
				ans = true;
		}
		
		if (ans)
			System.out.println("HARD");
		else
			System.out.println("EASY");
	}

}