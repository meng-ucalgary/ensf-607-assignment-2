#!/bin/bash

# clear the screen
clear

# print the commands as they execute
set -o xtrace

# compile the files
javac -sourcepath Exercise_4 -d Exercise_4/bin Exercise_4/*java

# run
java -cp Exercise_4/bin Game
