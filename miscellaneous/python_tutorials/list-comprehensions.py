#https://www.hackerrank.com/challenges/list-comprehensions
import fileinput

#Input
X, Y, Z, N = map(int, fileinput.input())

#Solve
arr = [[x, y, z] for x in range(X+1) for y in range(Y+1) for z in range(Z+1) if x + y + z != N]

#Output
print(arr)