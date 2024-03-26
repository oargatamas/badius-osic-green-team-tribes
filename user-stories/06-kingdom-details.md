# 06. Kingdom Details

## Description

After the successful login, the page you see should be the overall information
page of your kingdom. This page can be divided into multiple section. First of
all, it should give you the basic kingdom information - name of the kingdom,
ruler. Then you should be able to see the current amount of resources available
in your kingdom. Each kingdom has two main resources - that is gold & food.
Another important section is list of buildings that are currently built in your
kingdom. This list should contain list of buildings, one by one, with the
building type (e.g. farm, town hall, barracks), its current level and in case it
produces any resource, also its production per minute. Next section is the
troops section where you can see the list of all the available troops. You can
decide to only have one type of troop and in that case, you just specify the
total number of the troops, their properties like attack power, defense power,
current level (excluding upgrade in progress). Optionally you can also show the
queue of buildings and troops that are planned to be built/created, but are
waiting for its turn with the date and time in ascending order.

This use case should utilize other use cases and combine their results into
overall larger picture. Following use cases should be definitely included:

- Kingdom Resources
- Kingdom Buildings
- Kingdom Troops

## Backend Part

### Endpoint

`GET /kingdoms/{id}`

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
  "resources": [
    {
      "type": "food",
      "amount": 1,
      "generation": 1,
      "updatedAt": 1353647
    }, {
      "type": "gold",
      "amount": 1,
      "generation": 1,
      "updatedAt": 1235346
    }
  ],
  "buildings": [
    {
      "id": 2,
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
  ],
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

Given the /kingdom/{id} route. When the page is loaded. Then the view with data
exists.

#### Scenario 2

Given the /kingdom/{id} page. When {id} does not belong to authenticated user.
Then an error message shows up: "Authenticated user does not rule this kingdom!"

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
