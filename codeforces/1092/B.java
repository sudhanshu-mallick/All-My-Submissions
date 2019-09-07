
import java.util.Arrays;
import java.util.Scanner;

public class Team_Forming {

	public static void main(String[] args) {
		Scanner t=new Scanner(System.in);
		
		int n=t.nextInt();
		int[] a=new int[n];
		int skill=0;
		
		for(int i=0;i<n;i++)
			a[i]=t.nextInt();
		
		Arrays.sort(a);
		
		for(int i=0;i<n-1;i+=2)
			skill+=a[i+1]-a[i];
		
		System.out.println(skill);
	}

}
