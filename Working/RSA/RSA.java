

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
 System.out.println("Enter 1st prime number p");
 p=sc.nextInt();
 System.out.println("Enter 2nd prime number q");
 q=sc.nextInt();
 
 n=p*q;
 z=(p-1)*(q-1);
 System.out.println("the value of z = "+z); 
 
 for(e=2;e<z;e++)
 {
 if(gcd(e,z)==1)            // e is for public key exponent
 { 
 break;
 }
 }
 System.out.println("the value of e = "+e); 
 for(i=0;i<=9;i++)
 {
 int x=1+(i*z);
 if(x%e==0)      //d is for private key exponent
 {
 d=x/e;
 break;
 }
 }
 System.out.println("the value of d = "+d); 
 c=(Math.pow(msg,e))%n;
 System.out.println("Encrypted message is : -");
 System.out.println(c);
                //converting int value of n to BigInteger
 BigInteger N = BigInteger.valueOf(n);
 //converting float value of c to BigInteger
 BigInteger C = BigDecimal.valueOf(c).toBigInteger();
 msgback = (C.pow(d)).mod(N);
 System.out.println("Derypted message is : -");
 System.out.println(msgback);
 
 }
 
 static int gcd(int e, int z)
 {
 if(e==0)
 return z; 
 else
 return gcd(z%e,e);
 }
}
/*Enter the number to be encrypted and decrypted
12
Enter 1st prime number p
11
Enter 2nd prime number q
13
the value of z = 120
the value of e = 7
the value of d = 103
Encrypted message is : -
12.0
Derypted message is : -
12
*/
/*msv@ubuntu:~$ javac rsa.java
msv@ubuntu:~$ java rsa
Enter a number to be encrypted
12
Enter 2 prime numbers
13
11
N=p*q= 143
Z=p-1*q-1= 120
Public Key is: 7
Private Key is: 103
Encrypted message is: 12.0
The Decrypted Message is: 12
msv@ubuntu:~$ java rsa
Enter a number to be encrypted
1253
Enter 2 prime numbers
17
19
N=p*q= 323
Z=p-1*q-1= 288
Public Key is: 5
Private Key is: 461
Encrypted message is: 37.0
The Decrypted Message is: 284
msv@ubuntu:~$ java rsa
Enter a number to be encrypted
1204
Enter 2 prime numbers
11
17
N=p*q= 187
Z=p-1*q-1= 160
Public Key is: 3
Private Key is: 427
Encrypted message is: 92.0
The Decrypted Message is: 82
msv@ubuntu:~$ java rsa
Enter a number to be encrypted
13
Enter 2 prime numbers
13
11
N=p*q= 143
Z=p-1*q-1= 120
Public Key is: 7
Private Key is: 103
Encrypted message is: 117.0
The Decrypted Message is: 13
msv@ubuntu:~$ java rsa
Enter a number to be encrypted
59
Enter 2 prime numbers
3
11
N=p*q= 33
Z=p-1*q-1= 20
Public Key is: 3
Private Key is: 47
Encrypted message is: 20.0
The Decrypted Message is: 26
msv@ubuntu:~$ java rsa
Enter a number to be encrypted
10
Enter 2 prime numbers
7
17
N=p*q= 119
Z=p-1*q-1= 96
Public Key is: 5
Private Key is: 173
Encrypted message is: 40.0
The Decrypted Message is: 10
*/
