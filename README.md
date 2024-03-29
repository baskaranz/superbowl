# superbowl
Dius coding challenge  - Bowling scoring system

### Problem Statement

DiUS is starting a bowling club. To help with the club, we have engaged you to program a scoring system.

The features on the system are:

One player only
In each frame, the bowler has 2 tries to knock down all the pins
If in 2 tries, the bowler fails to knock down all the pins, their score is the sum of the number of pins they've knocked down in the 2 attempts
E.g, if a bowler rolls, 4,4

Their score is 8.

If in 2 tries, the bowler knocks down all the pins, it is a spare. The scoring of a spare is the sum of the number of pins knocked down plus the number of pins knocked down in the next bowl.
E.g, if a bowler rolls, 4,6 | 5, 0

Their score is 20. So that's (4 + 6 + 5) + (5 + 0)

If in one try, the bowler knocks down all the pins, it is a strike. The scoring of a strike is the sum of the number of pins knocked down plus the number of pins knocked down in the next two bowls.
E.g, if a bowler rolls, 10 | 5, 4

Their score is 28. So that's (10 + 5 + 4) + ( 5 + 4)

There are 10 pins in a frame
There are 10 frames in a match
Don't worry about validating the number of rolls in a frame

### Test

Run `gradle clean test` to run the unit tests.

The tests should cover all possible cases/scenarios defined in problem statement.
