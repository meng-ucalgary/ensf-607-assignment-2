@REM CLEAR THE SCREEN
CLS

@REM COMPILE THE FILES
javac -sourcepath Exercise_4 -d Exercise_4/bin Exercise_4/*java

@REM RUN
java -cp Exercise_4/bin Game

@REM DON'T SUDDENLY QUIT
PAUSE
