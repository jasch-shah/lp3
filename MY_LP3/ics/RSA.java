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
import java.math.*;
 
class RSA
{
 public static void main(String args[])
 {
 Scanner sc=new Scanner(System.in);
 int p,q,n,z,d=0,e,i;
 System.out.println("Enter the number to be encrypted and decrypted");
 int msg=sc.nextInt();
 double c;
 BigInteger msgback; 
 System.out.println("Enter 1st prime number (p):");
 p=sc.nextInt();
 System.out.println("Enter 2nd prime number (q):");
 q=sc.nextInt();
 
 n=p*q;                       //n chi value ji lagnar ahe aplyala public-key(e,n) ani priate-key(d,n) kadhayla

 z=(p-1)*(q-1);
 //System.out.println("the value of z = "+z); 
 
 for(e=2;e<z;e++)     
 {
 if(gcd(e,z)==1)
 { 
 break;
 }
 }
 System.out.println("The value of Encryption Key (e) = "+e); 


 for(i=0;i<=9;i++)
 {
 int x=1+(i*z);          //jabtak x point mai aa raha hai tab tak skeep karo and i ki value inc karo         
 if(x%e==0)
 {
 d=x/e;                //to find d
 break;
 }
 }
 

 c=(Math.pow(msg,e))%n;      //to encrypt the msg and convert it into cipher text we use public key combination i.e. (e,n)

 System.out.println("Encrypted message is : ");
 System.out.println(c);
 

 System.out.println("The value of Decryption Key (d) = "+d); 
 //BigInteger N = BigInteger.valueOf(n);     //as valueOf is a static method so no need to create object of it
 
 //BigInteger C = BigDecimal.valueOf(c).toBigInteger();
 //msgback = (C.pow(d)).mod(N);
 double ms=(Math.pow(c,d))%n;  
System.out.println("Derypted message is : ");
 System.out.println(ms);
 
 }
 
 static int gcd(int e, int z)
 {
 if(e==0)
  return z;
 if(z==0)
  return e;
 if(e==z)
   return e;
 if(e>z)
 return gcd(e-z,z);
 return gcd(e,z-e);
}

}

/*
Enter the number to be encrypted and decrypted
7
Enter 1st prime number (p):
11
Enter 2nd prime number (q):
3
The value of Encryption Key (e) = 3
Encrypted message is : 
13.0
The value of Decryption Key (d) = 7
Derypted message is : 
7
*/
