# 09. Kingdom Troops

## Description

Kingdom can not defend itself without troops. Without troops, it can not attack
others. Troops are therefore essential tool in a toolbox of every great ruler.
It does not matter whether there is only one type of troops (attack 1, defense
1, ukeep 1 food), that multiplies its stats based on Academy level. But for more
realism and also for more fun, why not invent more of them. You can have a
primarily defensive unit like a pikemen, primarily offensive units like axemen,
spies, catapults that can destroy enemy buildings during attack and knights on
horses that can wreak havoc among weaker units and even great senators that can
overturn enemy rulers and make the enemy kingdom part of your empire.
Possibilities are endless...

Suggested types of units:

- basic defensive unit (defense >> attack)
- basic offensive unit (attack >> defense)
- mounted heavy unit (attack > defense, faster than basic units)
- spies (fastest, but minimal or no attack & defense)
- senators (slow, weak unit, with option to ake over enemy kingdom)

## Backend Part

### Endpoint

`GET /kingdoms/{id}/troops`

### Sample Response (status 200)

```json
{
  "kingdom": {
    "kingdomId": 1,
    "kingdomName": "Bukurest",
    "ruler": "adam123",
    "population": 14,
    "location": {
      "coordinateX": 12,
      "coordinateY": 8
    } 
  },
  "troops": [
    {
      "id": 1,
      "level": 1,
      "hp": 1,
      "attack": 1,
      "defence": 1,
      "startedAt": 12345789,
      "finishedAt": 12399999
    }, {
      "id": 2,
      "level": 1,
      "hp": 1,
      "attack": 1,
      "defence": 1,
      "startedAt": 12345789,
      "finishedAt": 12399999
    }
  ]
}
```

### Sample Response (status 401)

```json
{
  "error": "This kingdom does not belong to authenticated player"
}
```

### Testing (BE)

- Create ***unit tests*** that should cover both the positive & negative cases

## Frontend Part

### Acceptance Criteria

#### Scenario 1

Given the /kingdom/{id}/troops route. When the page is loaded. Then the view
with data exists.

#### Scenario 2

Given the /kingdom/{id}/troops page. When {id} does not belong to authenticated
user. Then an error message shows up: "Authenticated user does not rule this
kingdom!"

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
