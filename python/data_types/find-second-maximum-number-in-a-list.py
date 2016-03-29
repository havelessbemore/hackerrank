#https://www.hackerrank.com/challenges/find-second-maximum-number-in-a-list
import fileinput

lines = fileinput.input()

N = int(lines[0])
A = list(set(map(int, lines[1].split(" "))))
A.sort()

print(A[len(A)-2])