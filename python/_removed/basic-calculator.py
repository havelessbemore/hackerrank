#https://www.hackerrank.com/challenges/basic-calculator
import fileinput

#Input
A = float(input())
B = float(input())

#Solve and output
print("%.2f" % (A+B))
print("%.2f" % (A-B))
print("%.2f" % (A*B))
print("%.2f" % (A/B))
print("%.2f" % (A//B))