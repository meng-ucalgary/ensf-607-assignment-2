#!/bin/bash

# clear the screen
clear

# print the commands as they execute
set -o xtrace

# compile the files
javac -sourcepath Exercise_2 -d Exercise_2/bin Exercise_2/*java

# run
java -cp Exercise_2/bin Drawing
