import random

def prime_number():
	state=False
	while state==False:
		p=random.getrandbits(10)
		state=is_Prime(p)
		if state==True:
			return p
		
def is_Prime(p):
	for i in range(2,p):
		if p%i==0:
			return False
	return True
        
            	
def large_number():
	p=random.getrandbits(10)
	return p

p=0
q=0

p=prime_number()
q=prime_number()

a=large_number()
b=large_number()

r=(q**a)%p 
s=(q**b)%p

rk=(s**a)%p
sk=(r**b)%p

if(rk==sk):
	print("Keys matched !")
	print("\nrk",rk)
	print("\nsk",sk)
else:
	print("Keys doesn't match")
	print("\nrk",rk)
	print("\nsk",sk)


"""
python3 dhke.py 
Keys matched !

rk 640

sk 640
"""