#https://www.hackerrank.com/challenges/fibonacci-modified/problem
def fibonacci(a,b,n,t):
    Tn0 = a
    Tn1 = b
    Tn2 = Tn1*Tn1 + Tn0
    if t==n:
	return Tn2
    else:
        return fibonacci(Tn1,Tn2,n,t+1)

arr = map(int,raw_input().strip().split(' '))
print fibonacci(arr[0],arr[1],arr[2],3)

