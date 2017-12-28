#https://code.google.com/codejam/contest/32016/dashboard#s=p0
readFile = open("A-large-practice.in")
testCases = int(readFile.readline())
#testCases = int(raw_input())
ans = {}
for t in range(0,testCases):
    arrLen = int(readFile.readline())
    #arrLen = int(raw_input())
    arr1 = [int(i) for i in readFile.readline().split()]
    arr2 = [int(i) for i in readFile.readline().split()]
    arr1 = sorted(arr1)
    arr2 = sorted(arr2,reverse=True)
    temp = 0
    for i in range(0,arrLen):
	temp += arr1[i]*arr2[i]
    ans[t] = temp
    
outputFile = open("MinimumScalarProduct_1A_Large.txt",'w')
for i in range(0,len(ans)):
    outputFile.write("Case #%d: %s\n" % (i+1,ans[i]))
