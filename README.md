# Game-of-Life
Implementation of Conway's Game of Life


In this implementation of the classic "Game of Life" I have tried to structure 
the code using the main components of the MVC pattern.

The Model is composed by the class Board, which represents the state of the 
"universe" and the class Generations, which contains the main evolving 
algorithm.

The View is represented by the GameWindow class, which is a GUI made with
Java Swing.

The Controller is represented by the class Controller, which controls
the GameWindow and the Model(Board-Generations). 

* Running The App:

   You can run the app from the command line after installing Maven on your computer with the following command
   from the project folder:

   ```
   mvn exec:java -Dexec.mainClass=igmun.ramiro.gameoflife.Main
   ```

![alt text](https://github.com/ramiro-igmun/Game-of-Life/blob/master/gameOfLife.gif "Game of Life")
