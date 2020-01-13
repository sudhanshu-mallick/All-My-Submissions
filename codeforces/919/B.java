import java.util.Scanner;

public class Perfect_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int i = 1, ans = 0;

		while (n > 0) {
			if (sum(i) == 10) {
				ans = i;
				n--;
			}
			
			i++;
		}

		System.out.println(ans);
	}

	static int sum(long n) {
		int sum = 0;

		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}

		return sum;
	}

}
