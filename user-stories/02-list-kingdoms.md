# 02. List Kingdoms

## Description

Player is registered and persisted in a database. Now, it is time to specify
coordinates of a kingdom. But we do not know, which coordinates are available
and which not. Also, we do not want to jump in the middle of enemy kingdoms,
that are stronger than us. To make an informed guess about kingdom's position,
we need some general information about all available kingdoms, their rulers and
their size. The size of a kingdom is determined by the amount of buildings. Each
building has a level. Simply summarize the levels of all the buildings in a
kingdom to get its size.

## Backend Part

### Endpoint

`GET /kingdoms`

### Sample Response (status 200)

```json
{
  "kingdoms": [
    {
      "kingdom_id": 1,
      "kingdomname": "Katarina's kingdom",
      "ruler": "kateTheTerrible",
      "population": 14,
      "location": {
        "coordinateX": 12,
        "coordinateY": 8
      }
    },
    {
      "kingdom_id": 2,
      "kigndomname": "Adamovo",
      "ruler": "adam123",
      "population": 26,
      "location": {
        "coordinateX": 14,
        "coordinateY": 14
      }
    }
  ]
}
```

### Testing (BE)

- Create ***unit tests*** that should cover case of zero kingdoms, one kingdom
  or multiple kingdoms

## Frontend Part

### Testing (FE)

- Create ***unit tests*** that should cover various cases
