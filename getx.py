import random
import sys

datf = open("data" + sys.argv[1] + ".dat", "r")
dim = int(sys.argv[1])
mat = []
for line in datf:
    mat.append(line.split(" "))
datf.close()

print(random.choice(random.choice(mat)))
