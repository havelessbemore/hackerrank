#https://www.hackerrank.com/challenges/find-a-string
import fileinput

#Input
string, substring = fileinput.input()

#Solve
count = len([True for i in range(0, len(string) - len(substring)) if string[i:i+len(substring)] == substring])

#Output
print(count)