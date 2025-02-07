# newtonIteration
Program which prompts user to enter a double 'epsilon' to dictate relative error, and another double to see it's computed SQRT through Newton Iteration.

This was Project 2 assigned to us in OSU's Software 1 class. Here's the long description if your interested:

"Your first job is to create a Java program that repeatedly asks the user whether they wish to calculate a square root. Each time, if the response is "y", then the program should proceed; if it is anything else, then the program should quit. Whenever it proceeds, the program should prompt the user for a number (a positive double, and your program may simply assume the input is consistent with this requirement) and then report the square root of that number to within a relative error of no more than 0.01%. The computation must be done using Newton iteration.

The intuitive idea of Newton iteration for computing square roots is fairly straightforward. Suppose you have a guess r for x^(1/2) that is too large; the argument is similar if it is too small. If r is too large to be the square root of x, then x/r must be too small, so the average of r and x/r should be a better guess than either r or x/r. This suggests that if you repeatedly replace your current guess r by (r + x/r)/2, then your sequence of guesses should converge to x^(1/2). And indeed it can be proved that it does. A good initial guess for x^(1/2) is simply r = x. If you continue updating r until |r2 – x |/x < ε2, then the relative error of the guess r will be less than ε."
