#https://www.hackerrank.com/challenges/saveprincess

#!/usr/bin/python
def displayPathtoPrincess(n, grid):

    #Find the bot
    for y,x in ((cy, cx) for cy in range(0, n) for cx in range(0, n)):
    	if grid[y][x] == 'm':
    		by, bx = (y, x)
    		break

    #Find the princess
    for y,x in ((cy, cx) for cy in range(0, n, n-1) for cx in range(0, n, n-1)):
    	if grid[y][x] == 'p':
    		py, px = (y, x)
    		break

    ydir = "LEFT" if py < by else "RIGHT"
    xdir = "UP" if px < bx else "DOWN"

    #Output moves
    for i in range(0, abs(py - by)):
        print(ydir)
    for i in range(0, abs(px - bx)):
        print(xdir)

#end displayPathToPrincess

#Input
n = int(input())
grid = [] 
for i in range(0, n): 
    grid.append(input().strip())

#Solve
displayPathtoPrincess(n,grid)
