import sys
import random

dim = 0
if len(sys.argv) > 1:
    dim = int(sys.argv[1])
else: 
    print("error, please provide a dimension")

mat = []
for y in range(dim):
    mat.append([])
    for x in range(dim):
        above = 1
        left = 1
        if x > 0:
            left = mat[y][x-1]
        if y > 0:
            above = mat[y-1][x]
        start = max(above, left)
        mat[y].append(random.randint(start, start + 4))

print(mat)

datf = open("data" + str(dim) + ".dat", "w")

for y in range(dim):
    for x in range(dim):
        datf.write(str(mat[y][x]) + " ")
    datf.write("\n")

datf.close()

