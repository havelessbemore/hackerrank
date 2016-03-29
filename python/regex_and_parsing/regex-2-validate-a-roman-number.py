#https://www.hackerrank.com/challenges/regex-2-validate-a-roman-number
import fileinput
import re
'''
0-10: X | #10
      IX|V?I{0,3} #0-9

0-50: L | #50
      XL (I[VX]|V?I{0,3}) | #40-49
      X{0,3}(IX|V?I{0,3}) #0-39

0-100: C | #100
       XC(I[VX]|V?I{0,3}) |#90-99
       LX{0,3}(I[VX]|V?I{0,3}) | #50-89
       XL(I[VX]|V?I{0,3}) | #40-49
       X{0,3}(I[VX]|V?I{0,3}) #0-39

0-500: D | #500
       CD(0-99) | #400-499
       C{0,3}(0-99) #0-399

0-1000: M | #1000
        CM(0-99) | #900-999
        DC{0,3}(0-99) | #500-899
        CD(0-99) | #400-499
        C{0,3}(0-99) #0-399

_1to99 = (X[LC]|L?X{0,3})(I[VX]|V?I{0,3}) #0-99

0-3999: M{0,3}
        CM(_1to99)
        DC{0,3}(_1to99) | #500-899
        CD(_1to99) | #400-499
        C{0,3}(_1to99) #0-399
        =
        M{0,3}
        (C[MD]|D?C{0,3})(_1to99)
        =
        M{0,3}(C[MD]|D?C{0,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3})
'''
print(True if re.match(r"^M{0,3}(C[DM]|D?C{0,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3})$", input()) else False)