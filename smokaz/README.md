# Smokaz
At the table sits a dealer and 3 smokers. Each smoker requires a cigarette, a match, and some striking paper so they can shmoke. But they each 
have only 2 of the ingredients (creating each possible combination - no 2 have the same items).

Fortunately the dealer will put 1 smoking item on the table, which will may then rightfully be claimed by only the smoker who needs that item.

Once the smoker has claimed the item from the table they will then smoke a cigarette.

- The dealer can only put 1 item on the table at a time

- The dealer can not put an item on the table that is for a smoker who is currently smoking a cigarette

## Implementation
This implementation uses actors and state machines - a declarative-like way of expressing the rules of the game. Communication occurs using 
Akka's event bus. This allows all entities involved in the game to be completely decoupled from each other - and without any shared state. 
Apparently that's good for concurrency and parallelism - and no threads or locks necessary].

## Running the application
Just fire up sbt and "run" the thing. It will continue forever so you have to kill it yourself (pull requests welcome)

## Sample output
```
[Smokaz-akka.actor.default-dispatcher-2] INFO akka.event.slf4j.Slf4jLogger - Slf4jLogger started
[Smokaz-akka.actor.default-dispatcher-6] INFO NeedPaperSmoker - I neeeeed some paper. Feed my lungs with tar
[Smokaz-akka.actor.default-dispatcher-6] INFO NeedACigSmoker - I neeeeed a cigarette. Feed my lungs with tar
[Smokaz-akka.actor.default-dispatcher-6] INFO NeedAMatchSmoker - I neeeeed a match. Feed my lungs with tar
[Smokaz-akka.actor.default-dispatcher-3] INFO Dealer - Placed Paper on table
[Smokaz-akka.actor.default-dispatcher-3] INFO NeedPaperSmoker - I am now smoking leave me alone
[Smokaz-akka.actor.default-dispatcher-6] INFO Dealer - Placed Cigarette on table
[Smokaz-akka.actor.default-dispatcher-6] INFO NeedACigSmoker - I am now smoking leave me alone
[Smokaz-akka.actor.default-dispatcher-3] INFO Dealer - Placed Match on table
[Smokaz-akka.actor.default-dispatcher-3] INFO NeedAMatchSmoker - I am now smoking leave me alone
[Smokaz-akka.actor.default-dispatcher-5] INFO NeedACigSmoker - Finished smoking. Feed me more tar
[Smokaz-akka.actor.default-dispatcher-5] INFO Dealer - Placed Cigarette on table
[Smokaz-akka.actor.default-dispatcher-5] INFO NeedACigSmoker - I am now smoking leave me alone
[Smokaz-akka.actor.default-dispatcher-4] INFO NeedACigSmoker - Finished smoking. Feed me more tar
[Smokaz-akka.actor.default-dispatcher-4] INFO Dealer - Placed Cigarette on table
[Smokaz-akka.actor.default-dispatcher-4] INFO NeedACigSmoker - I am now smoking leave me alone
[Smokaz-akka.actor.default-dispatcher-5] INFO NeedPaperSmoker - Finished smoking. Feed me more tar
[Smokaz-akka.actor.default-dispatcher-5] INFO NeedAMatchSmoker - Finished smoking. Feed me more tar
[Smokaz-akka.actor.default-dispatcher-5] INFO Dealer - Placed Paper on table
[Smokaz-akka.actor.default-dispatcher-5] INFO NeedPaperSmoker - I am now smoking leave me alone
[Smokaz-akka.actor.default-dispatcher-5] INFO Dealer - Placed Match on table
[Smokaz-akka.actor.default-dispatcher-5] INFO NeedAMatchSmoker - I am now smoking leave me alone
```