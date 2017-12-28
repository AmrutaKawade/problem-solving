#https://code.google.com/codejam/contest/4244486/dashboard#s=p0
readFile = open("A-small-practice.in")
testCases = eval(readFile.readline())
#testCases = int(raw_input())
ans = {}
for t in range(0,testCases):
    R,C,W = readFile.readline().split()
    #R,C,W = raw_input().split()    
    score = int(R)*(int(C)/int(W))
    score += (int(W)-1)
    if int(C)%int(W) != 0:
	score += 1
    ans[t] = score
    #print ans
outputFile = open("Battleship_2015_1C_small.txt",'w')
for i in range(0,len(ans)):
    outputFile.write("Case #%d: %d\n" % (i+1,ans[i]))
readFile.close()
outputFile.close()

