#!/bin/bash
DIM=4
DATF="data1.dat"
NUM=14

java -jar Project2.jar 4 data1.dat 14 7 | awk '{print $1;}'

