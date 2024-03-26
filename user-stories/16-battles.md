# 16. Battles

## Description

And there we are...battles. The ultimate challenge. Battle is a last and at the
same time most challenging concept you will need to implement into the game
logic. It is up to you howsimple or how complex you want it to be.

Based on the desired amount of complexity, we can divide implementation options
into three options:

### Dead simple

- you have decided that one troop type is exactly right amount of variance on a
  battlefield
- there's no reason to wait for anything, so battles take places at the moment
  you initiate it
- no randomness, no bonuses, simple math. Does attacker have higher attack
  number than defender defense number? Attacker wins! Not the case? Defender
  wins.
- winner takes it all, which means that loser loses all the troops, winner loses
  only part represented by losers (total attack, or total defense based on the
  role it played)
- all that you can do is attack to destroy enemy troops and may be steal some
  resources

### Simplicity in complexity

- you want to have multiple types of troops, but reality of taking time into
  consideration is still too much for you
- troop numbers aren't all in this case, but what matters is honor, so your
  units patiently wait for the next opponent to kill
- your troops have HP, because otherwise it doesn't really makes sence
- attacking army is instantly transported to the defender's kingdom at the
  moment of battle initiation
- each attacking troop gets randomly assigned defending troop, the troops left
  on either side patiently wait for their turn
- paired troops hit each other and if one is still standing at the end, it can
  take on another opponent
- troops valiantly and honorably try to kill each other in turns until there is
  only one side alive
- you should be able to do something else beyond merely stealing resources...may
  be destroying the kingdom's buildings?

### Make it real

- you have multiple types of troops
- there are different types of attack, that you can partake in (stealing/killing
  troops, spying attacks, destructive attacks with catapults, takeover attacks
  with senators)
- the time and space play important role here - you take into consideration
  coordinates of the fighting kingdoms
- based on Math - specifically Pythagoras's theorem, you calculate the distance
  between the two kingdoms and apply to it the speed of slowest attackng troops.
  That's how long it is going to take to get there and probably back - if
  anybody survives
- you feel comfortable applying a little randomness into the battle by giving
  each side (attacker, defender) randomly powerful boost/hinder
- buildings can play a role too (townhall, walls)
- not all is equal in life, so neither result nor total losses should be linear
  as well. Apply a little curvature to the result based on the significance of
  the difference between attacker and defender
- at least result is calculated by single number difference in the end: total
  attack power minus total defense power equals result
- the complexity happens because your troops take some time to travel to enemy
  kingdom and then it takes some time for them to get back
- therefore you don't know the results of the battle immediately  

## Backend Part

### Endpoint for creating battle

`POST /kingdoms/{id}/battles`

### Sample Request

```json
{
  "target": {
    "kingdomId": 1,
    "kingdomName": "Bukurest",
    "ruler": "adam123",
    "location": {
      "coordinateX": 12,
      "coordinateY": 8
    }
  },
  "battleType": "plunder",
  "troops": [
    {  
      "type": "axemen",
      "quantity": 45,
    }, 
    {
      "type": "knight",
      "quantity": 12
    }
  ]
}
```

### Sample Response (status 200)

```json
{
  "battleId": 12,
  "resolutionTime": 1635643280
}
```

### Endpoint for reading result of battle

`GET /kingdoms/{id}/battles/{id}`

### Sample Response - Battle status (status 200)

```json
{
  "battleId": 12,
  "resolutionTime": 1635643280,
  "battleType": "plunder",
  "result": "win",
  "attacker": {
    "resourcesStolen": {
      "gold": 450,
      "food": 375
    },
    "troopsLost": [
      {  
        "type": "axemen",
        "quantity": 15,
      }, 
      {
        "type": "knight",
        "quantity": 2
      }
    ]
  },
  "defender": {
    "troopsLost": [
      {  
        "type": "phalanx",
        "quantity": 18,
      }
    ]
  }
}
```

***Note:** There is so many options and possibilities that it's simply not
possible to cover them all. Make the battles as simple or as complex as you
wish. The same applies to the results of the battle. Make it as detailed or as
short as you deem fit. As long as everything works properly and there are no
mistakes in the logic and all is saved correctly...*

### Testing (BE)

- Create ***unit tests*** that should cover both the positive & negative cases

## Frontend Part

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
