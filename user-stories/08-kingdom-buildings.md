# 08. Kingdom Buildings

## Description

Without buildings, there is no kingdom. You need different types of buildings to
make your kingdom sustainable. Ruler needs farms to feed the people and troops,
mines to be able to pay for troops training and building additional buildings.
It is a never-ending cycle of resources spent, to get more resources.

Your kingdom can posses following types & quantities of buildings:

- 1x **townhall** (limits capacity for resources)
- 1x **barracks** (training troops)
- 1x **academy** (upgrading troops)
- 5x **farm** (collects food)
- 3x **mine** (harvests gold)

***Note:** There is no right or wrong way, how to deal with buildings. You can
start with each type of building already on level 1. Youcan decide that only
townhall will be build with one farm and one mine, to guarantee at least some
production in the beginning. You can decide that there will be option to build
multiple farms and/or mines. You can set number of mines and farms to a fixes
number and allow only one of the other buildings. You can even come up with
completely new buildings like "Walls" to increase defense of a kingdoms or
"Hideout" to keep certain small amount of resources hidden from attackers. Sky
is the limit.*

## Backend Part

### Endpoint

`GET /kingdoms/{id}/buildings`

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
  "buildings": [
    {
      "id": 1,
      "type": "farm",
      "level": 1,
      "startedAt": 12345789,
      "finishedAt": 12399999
    },
    {
      "id": 2,
      "type": "townhall",
      "level": 1,
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

Given the /kingdom/{id}/buildings route. When the page is loaded. Then the view
with data exists.

#### Scenario 2

Given the /kingdom/{id}/buildings page. When {id} does not belong to
authenticated user. Then an error message shows up: "Authenticated user does not
rule this kingdom!"

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
