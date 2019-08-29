import java.util.Scanner;

public class Burger {

	public static void main(String[] args) {
		Scanner t=new Scanner(System.in);
		
		int n=t.nextInt();
		
		while(n-->0)
		{
			int b=t.nextInt();
			int p=t.nextInt();
			int f=t.nextInt();
			int h=t.nextInt();
			int c=t.nextInt();
			
			fun(b,p,f,h,c);
		}
	}
	
	public static void fun(int b,int p,int f,int h,int c)
	{
		int ans=0;
		
		if(h>c)
		{
			if(2*p>b)
			{
				if(b<=1)
				{
					System.out.println(ans);
					return;
				}
				ans+=h*(b/2);
				b=b-(b/2)*2;
			}
			else
			{
				if(b<=1)
				{
					System.out.println(ans);
					return;
				}
				ans+=h*(p);
				b=b-2*p;
			}
			
			if(2*f>b)
			{
				if(b<=1)
				{
					System.out.println(ans);
					return;
				}
				ans+=c*(b/2);
				b=b-(b/2)*2;
			}
			else
			{
				if(b<=1)
				{
					System.out.println(ans);
					return;
				}
				ans+=c*(f);
				b=b-2*f;
			}
		}
		else
		{
			if(2*f>b)
			{
				if(b<=1)
				{
					System.out.println(ans);
					return;
				}
				ans+=c*(b/2);
				b=b-(b/2)*2;
			}
			else
			{
				if(b<=1)
				{
					System.out.println(ans);
					return;
				}
				ans+=c*(f);
				b=b-2*f;
			}
			
			if(2*p>b)
			{
				if(b<=1)
				{
					System.out.println(ans);
					return;
				}
				ans+=h*(b/2);
				b=b-(b/2)*2;
			}
			else
			{
				if(b<=1)
				{
					System.out.println(ans);
					return;
				}
				ans+=h*(p);
				b=b-2*p;
			}
		}
		
		System.out.println(ans);
		
	}

}