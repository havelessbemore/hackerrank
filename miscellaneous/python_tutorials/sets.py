#https://www.hackerrank.com/challenges/sets
import fileinput

#Input and Solve
M = int(input())
SM = set(map(int, input().split(" ")))
N = int(input())
SN = set(map(int, input().split(" ")))
diff = list(SM.difference(SN).union(SN.difference(SM)))
diff.sort()

#Output
for v in diff:
    print(v)