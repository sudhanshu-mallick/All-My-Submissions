import java.util.Scanner;

public class Repeating_Cipher {

	public static void main(String[] args) {
		Scanner t=new Scanner(System.in);
		
		int n=t.nextInt();
		String s="";
		s=t.next();
		int k=1;
		
		for(int i=0;i<s.length();i+=k)
		{
			System.out.print(s.charAt(i));
			k++;
		}
		

	}

}
