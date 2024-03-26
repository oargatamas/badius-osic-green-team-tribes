# 18. Beyond The Scope

## Description

There's always space for improvement and this project is no exception to that
rule. Because of that fact, this section exists. Let's try and summarize here
all the possible improvements that can be applied to the project within
reasonable time frame. And let's categorize them into some logical parts, so
it's not complete mess.

### Registration

- When the user registers he receives an email with a clickable link that is
  going to confirm his registration into our app. Without it he cannot log in
  and receive a token. This feature should be easily turned off based on the
  environment variable.

### Authentication & Authorization

- Users can use their FB or Google account to get access to our app
- Implement refresh token that has validity much longer than standard access
  token and servicec to handle seamless replacement of access/refresh token pair
  when needed.

### Gameplay features

- Player should be able to make alliances which provides support while battling,
  but also the obligation to help other kingdoms and accept losses
- Player should have option to peacefully start new kingdom somewhere on map
  just like in other games of this kind
- Messaging functionality among two players directly, but also larger messaging
  rooms for example for an alliance members or game-wide discourse forum

### Implementation

- Use Faker library to randomize kingdom names - if not provided and also name
  for anything purchasable (troops, ships etc.)
- Implement swagger middleware with proper settings so that we are able to run
  the app and test all our endpoints without the Postman
- Take troops upkeep into consideration. Refer to game's ruleset to get the
  exact formulas (attached).
- Call this function in Time service's scheduled method, so that resources are
  recalculated every tick or every request (timestamps).
- This service is going to simulate passage of time in our application. In game
  rule terms, a single unit of time is called "game tick".
- As per default rules, game tick should be one minute but we should be able to
  easily change this amount to anything (to speed up or slow down the game).
- Write the service with this in mind, and take the actual tick length from
  newly created environment variable called TRIBES_GAMETICK_LEN storing length
  in seconds. Update README with information about this variable.

### Logging / History

- Keeping track of kingdom history should be possible - we would log all
  purchases/upgrades/battling events etc into DB.
