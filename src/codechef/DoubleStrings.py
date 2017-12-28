#https://www.codechef.com/problems/DOUBLE
n = eval(raw_input())
for i in range(0,n):
    inputN = eval(raw_input())
    if inputN%2==0:
        print inputN
    else:
        print inputN-1
