#https://www.hackerrank.com/challenges/map-and-lambda-expression
import fileinput

N = int(input())

fibs = [] if N < 1 else [0] if N < 2 else [0, 1]
for i in range(1, N-1):
    fibs.append(fibs[i] + fibs[i-1])

print(list(map(lambda x : x*x*x, fibs)))