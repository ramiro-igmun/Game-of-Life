# Game-of-Life
Implementation of Conway's Game of Life


We create the main components of the MVC pattern and their dependencies. 
The Model is composed by the class Board, which represents the state of the 
"universe" and the class Generations, which contains the main evolving 
algorithm in a static method.
The View is represented by the GameWindow class, which contains all the 
wing elements.
The Controller is represented by the class Controller, which controlls
the GameWindow and the Model(Board-Generations) 