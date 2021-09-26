@REM CLEAR THE SCREEN
CLS

@REM COMPILE THE FILES
javac -sourcepath Exercise_2 -d Exercise_2/bin Exercise_2/*java

@REM RUN
java -cp Exercise_2/bin Drawing

@REM DON'T SUDDENLY QUIT
PAUSE
