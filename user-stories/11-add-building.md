# 11. Add Building

## Description

Not all buildings have to be available since the beginning of the game. Or may
be none of the buildings are. And you as a ruler have to have them built all...
All you need to specify is a type of new building. If there is place for it, it
will be built. If not builder's guild will let you know. Don't you worry about
that!  

Certain buildings can have requirements like townhall has to be at least on
level 5, or that supported building needs to be of certain minimal level. The
main rule is that no building can have higher level than townhall. If townhall
is level 10, maximum level for all the other buildings is 10 as well.

This is the suggested list of the buildings for your kingdom:

- 1x **townhall** (limits capacity for resources)
- 1x **barracks** (training troops)
- 1x **academy** (upgrading troops)
- 1x **Walls** (increasing defense of kingdom)
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

`POST /kingdoms/{id}/buildings`

### Sample Request

```json
{
  "type": "farm"
}
```

### Sample Response (status 200)

```json
{
  "id": 2,
  "type": "farm",
  "level": 1,
  "hp": 1,
  "startedAt": 12345789,
  "finishedAt": 12399999
}
```

### Sample Response (status 400)

```json
{
  "error": "Type is required."
}
```

### Sample Response - Not enough gold (status 400)

```json
{
  "error": "You don't have enough gold to build that!"
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

Given the POST /kingdom/{id}/buildings endpoint. When I send an empty request to
it. Then I get back a message: "Type is required.".

#### Scenario 2

Given the POST /kingdom/{id}/buildings endpoint. When I send a request to it
with a right type: farm/mine/barrack/academy/wall. And I have enough money for
it. Then I get back informations about the new building.

#### Scenario 3

Given the POST /kingdom/{id}/buildings endpoint. When I send a request to it
with a right type: farm/mine/barrack/academy/wall. And I don't have enough money
for it. Then I get back a message: "You don't have enough money".

#### Scenario 4

Given the POST /kingdom/{id}/buildings endpoint. When I send a request to it
with a wrong type. Then I get back a message: "Wrong type."

#### Scenario 5

Given the POST /kingdom/{id}/buildings endpoint. When I send a request to it
with a right type: farm/mine/barrack/academy/wall, but higher townhall level is
required. Then I get back a message: "You don't have high enough town hall. You
need levl XX to build this building".

#### Scenario 6

Given the POST /kingdom/{id}/buildings endpoint. When I send a request to it
with a right type: farm/mine/barrack/academy/wall, but you need another building
(potentially with specific lvl) already be built. Then I get back a message:
"You need building XX on level XX to be able to build this building".

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
