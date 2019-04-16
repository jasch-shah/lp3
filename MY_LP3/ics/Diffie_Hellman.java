/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.util.*;

class Diffie_Hellman
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first prime number: ");
		int p=sc.nextInt();
		System.out.println("Enter second prime number: ");
		int q=sc.nextInt();
		System.out.println("Choose 1st secret no(Alice)");
		int a=sc.nextInt();
		System.out.println("Choose 2nd secret no(BOB)");
		int b=sc.nextInt();
				
		int A = (int)Math.pow(q,a)%p;
		int B = (int)Math.pow(q,b)%p;
		
		int S_A = (int)Math.pow(B,a)%p;
		int S_B =(int)Math.pow(A,b)%p;	
		
		if(S_A==S_B)
		{
			System.out.println("ALice and Bob can communicate with each other!!!");
			System.out.println("They share a secret no = "+S_A);			
		}
		
		else
		{
			System.out.println("ALice and Bob cannot communicate with each other!!!");
		}
	}	
}

/*
Enter first prime number: 
17
Enter second prime number: 
7
Choose 1st secret no(Alice)
5
Choose 2nd secret no(BOB)
3
ALice and Bob can communicate with each other!!!
They share a secret no = 5
*/
