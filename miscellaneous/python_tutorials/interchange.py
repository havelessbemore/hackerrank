#https://www.hackerrank.com/challenges/interchange-two-numbers
import fileinput

#Input
a, b = fileinput.input()

#Solve
a, b = (b, a)

#Output
print(a)
print(b)