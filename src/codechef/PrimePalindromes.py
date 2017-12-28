#https://www.codechef.com/problems/PRPALIN
import math
inputNum = eval(input())

def getPrimeList(primeList,num):
    count = primeList[-1]  
    while count < num:
        trackLen = 0
        count += 1
        for i in primeList:
            trackLen += 1
            if count%i == 0:
                break           
        if len(primeList) == trackLen:
            primeList.append(count)
    return primeList


count = inputNum
primeList = [2]
while count >= inputNum:
    trackLen = 0
    if count > 98689:
        print(1003001)
        break
    elif count > 10000:
        primeList = getPrimeList(primeList,round(math.sqrt(count)))
    else:
        primeList = getPrimeList(primeList,count)
    for i in primeList:
        trackLen += 1
        if count%i == 0:
            break          
    if len(primeList) == trackLen:
        x = str(count)
        if str(count) == x[::-1]:                 
            print(count)
            break
        else:
            count += 1
    else:
        count += 1


            
    
    
