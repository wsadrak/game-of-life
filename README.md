# Conway’s Game Of Life implementation in Java

# Summary
A simple console implemenation of Conway's Game of Life. The application  communicates with the user and retrieves data from him, which allow to generate random initial state, then proceeds to calculate the next states.

## Basic Rules
* Any live cell with fewer than two live neighbours dies (referred to as underpopulation or exposure[1]).
* Any live cell with more than three live neighbours dies (referred to as overpopulation or overcrowding).
* Any live cell with two or three live neighbours lives, unchanged, to the next generation.
* Any dead cell with exactly three live neighbours will come to life.
