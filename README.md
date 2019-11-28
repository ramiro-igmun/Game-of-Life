# Game-of-Life
Implementation of Conway's Game of Life


In this implementation of the classic "Game of Life" I have tried to structure 
the code using the main components of the MVC pattern.

The Model is composed by the class Board, which represents the state of the 
"universe" and the class Generations, which contains the main evolving 
algorithm.

The View is represented by the GameWindow class, which is a GUI made with
Java Swing.

The Controller is represented by the class Controller, which controlls
the GameWindow and the Model(Board-Generations). 