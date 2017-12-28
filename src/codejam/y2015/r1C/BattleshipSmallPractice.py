#https://code.google.com/codejam/contest/4244486/dashboard#s=p0
readFile = open("A-large-practice.in")
testCases = eval(readFile.readline())
#testCases = int(raw_input())
ans = {}
for t in range(0,testCases):
    R,C,W = readFile.readline().split()
    #R,C,W = raw_input().split()
    cells = int(R)*int(C)
    combination = 0
    boatWidth = int(W)
    for i in range(0,cells,int(W)):
        combination += 1
    if combination == 1:
        score = boatWidth
    else:
        score = combination + (boatWidth-1)
    ans[t] = score
    #print ans
outputFile = open("Battleship_2015_1C_large_practice.txt",'w')
for i in range(0,len(ans)):
    outputFile.write("Case #%d: %d\n" % (i+1,ans[i]))
readFile.close()
outputFile.close()

