#!/bin/bash

OUTF=$1

for i in {1..50}
do
	for j in {1..3}
	do
		x=$(python getx.py $i)
		for k in {1..3}
		do
			runtime=$(java -jar Project2.jar $i "data$i.dat" $x | tail -1 | awk '{print $1;}')
			echo "$i,$runtime" >> $OUTF
		done
	done
	echo "Finished $i"
	
done
