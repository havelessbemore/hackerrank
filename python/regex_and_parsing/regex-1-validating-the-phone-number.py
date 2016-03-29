#https://www.hackerrank.com/challenges/regex-1-validating-the-phone-number
import fileinput
import re

def isMobileNum(numStr):
    return "YES" if re.match(r"^[7-9]\d{9}$", numStr)  else "NO"

lines = fileinput.input()
N = lines[0]
for s in lines:
    print(isMobileNum(s.strip()))