import random

def prime_number():
	state=False
	while state==False:
		p=random.getrandbits(10)
		state=is_prime(p)
		if state==True:
			return p

def is_prime(p):
	for i in range(2,p):
		if(p%i==0):
			return False
	return True

def co_prime(a):
 	k=2
 	gcd=1
 	for i in range(2,a):
 		for j in range(k,i+1):
 			if((a%j)==0 and (k%j)==0):
 				gcd=j
 		if gcd==1:
 			return k	
 		k=k+1
 		gcd=1

def decryption_key(e,phi_n):
	d=0
	i=1
	while True:
		d=((phi_n*i)+1)/e
		if (d).is_integer():
			return d
		else:
			i=i+1


a=prime_number()
b=prime_number()


while(a==b):
 	b=prime_number()

n=(a*b)

phi_n=(a-1)*(b-1)

e=co_prime(phi_n)
print("Encryption Key ",e)

d=decryption_key(e,phi_n)
d=int(d)
print("Decryption Key",d)

p=input("Enter value less than {} ".format(n))
p=int(p)

c=(p**e)%n
print("Cypher ",c)

decrypted_Plaintext=(c**d)%n
print("Decrypted Plaintext ",decrypted_Plaintext)


"""
python3 rsa.py 
Encryption Key  5
Decryption Key 11405
Enter value less than 19303 2
Cypher  32
Decrypted Plaintext  2
"""