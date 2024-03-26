# 15. Leaderboards

## Description

What is the point to the game, when zou don't know who's actually winning? And
that's what leaderboards are here for...you can measure success in game with
different measure than the other players. So let's have multiple leaderboards to
solve this issue as well.

Let's create three different leaderboards focusing on three different aspects of
the game:

- buildings
- troops
- kingdoms

First leaderboard measures points as a sum of levels of all the buildings that
you have built. Second leaderboard counts total food consumption of all units
you have in a kingdom. The last one combines both these metrics into the larger
one which should quite reliably point to the "best" kingdom there is.

**Note:** *Of course you don't have to implement all 3 leaderboards. You can
choose only some of them and you can decide to implement the points differently
and that is completely okay. The point is not to tell you what to do, ubut to
give you some pointers to start your own thing. So if you have better idea, by
all means. Do that!*

## Backend Part

### Endpoint

`GET /leaderboards/troops`

`GET /leaderboards/buildings`

`GET /leaderboards/kingdoms`

***Note:*** **Samples are for 'buildings' leaderboards**

### Sample Response (status 200)

```json
{
  "results":[
    {
      "ruler": "adam123",
      "kingdom": "Bukurest",
      "buildings": 12,
      "points": 187
    },
    {
      "ruler": "hanickaAmurko",
      "kingdom": "StatenIsland",
      "buildings": 12,
      "points": 163
    },
    {
      "ruler": "permanent001",
      "kingdom": "HajajBuvaj",
      "buildings": 12,
      "points": 147
    }
  ]
}
```

### Testing (BE)

- Create ***unit tests*** that should cover both the positive & negative cases

## Frontend Part

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
