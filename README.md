# String-Permutations
This program finds all possible permutations of letters given a user generated string.  This program is implemented with a 'cell' object that contains attributes that aid in selecting characters that have or have not been used to create a previous permutation. Once a new permutation is found, it's added to an ArrayList and thrown into Java Collections for re-ordering in alphabetical order and displayed to the user.

## Installation and Execution
Requirements: ```javac``` and ```jar```

### stringPermutations
Compile with:
```javac stringPermutations.java```

Execute with:
```java stringPermutations```

### Misc
All possible permutations given a string of length N has a total of: N! / ((character repeats)! * (character repeats)! etc...) possible combinations.  As N increases, you will notice a drastic delay in displaying all possibilities, also becuase my propietary algorithm to solve this problem is less than optimal... This project was more of a "proof of concept" to develop a program under time stress.  The entirety of this program was written during a flight from LAX to BWI.
