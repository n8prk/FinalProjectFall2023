# FinalProjectFall2023
This my final project for Comp 152 Fall 2023, the Digits game.

# Function
  When the code is ran, a window is opened in which you try to use mathematical operations on the given numbers in an attempt to get to the Target Number

# Things I've Learned
1. Instantiation optimizations and redundancies
 - When I first started this project, it was mostly brute force coding. I made every component individually and gave each of them their own ActionListeners, layout coordinates, etc.
 - I soon realized that much of the instantion and layout setting could be optimized by looping through arrays.
 - I created arrays of numbers and their associated buttons so that I may access and instantiate them through loops as well as set their coordinates.
 - I also discovered unconventional looping patterns in that the buttons I was instantiating through loops were not organized in a square grid but rather a 2 by 3 grid.
 - Because of this, I saw that the coordinates were being set in a mod 3 cycle for its columns, and quotient cycle (no remainder) and used that to loop as well.

2. The nature of interfaces and different instantiation methods
 - As previously mentioned, I gave each number button its own ActionListener (i.e. btn.addActionListener(new ActionListener( {} );).
 - However, I also learned in a previous project that instantiation could be looped and so I needed to create a class that implemented ActionListener as it was an interface.
 - I could do this for the operation buttons as well and have different ActionListener implementations. I could also add my own attributes to fit my needs.
 - Now, I could create generalized ActionListeners that would use specific attributes I gave it through instantiation.
