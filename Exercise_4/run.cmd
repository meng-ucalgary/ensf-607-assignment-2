@REM CLEAR THE SCREEN
CLS

@REM COMPILE THE FILES
javac -sourcepath src -d bin src/*java

@REM RUN
java -cp bin Game

@REM DON'T SUDDENLY QUIT
PAUSE
