# 03. Kingdom Registration

## Description

Player is registered and persisted in a database. Now, it is time to specify
coordinates of a kingdom. Kingdom coordinates is simply a touple of values, both
between 0 and 99. For example \[15, 17\] is a valid value. First value
represents row, second one represents columns. Edge of a game world has size of
hundred. Coordinates must be unique and not yet used. Otherwise you get error
and need to repeat the activity.

***Note:*** It is completely up to you what size of world you choose, but keep
in mind, that if you plan to also provide frontend, you will need to somehow
represent each available field. As you can see in the image example below, the
size of the world there is only 20 x 20 fields. And there is one more
restriction. The first kingdom has to be in the center square of 10 x 10, where
all the other players are. The outer part is dedicated to AIs (if you decide to
implemented them).

## Backend Part

### Endpoint

`PUT /registration/`

### Form Data Validations

- **coordinateY**: required, must be number between 0 and 99, represents rows
- **coordinateX**: required, must be number between 0 and 99, represents columns
- **kingdomId**: required, must be of a kingdom that belongs to authenticated
  user and does not possess coordinates yet

### Sample Request

```json
{
    "coordinateY": 14,
    "coordinateX": 71,
    "kingdomId": 1
}
```

### Sample Response (status 200)

```json
{
    "status": "ok"
}
```

### Sample Response - Out of Range (status 400)

```json
{
    "error": "One or both coordinates are out of valid range (0-99)."
}
```

### Sample Response - Coordinates taken (status 400)

```json
{
    "error": "Given coordinates are already taken!"
}
```

### Testing (BE)

- Create ***unit tests*** that should cover both the positive & negative cases

## Frontend Part

### Acceptance Criteria

#### Scenario 1

Given the /register/kingdom route. When the page is loaded. Then the register
kingdom page exists.

#### Scenario 2

Given the loaded register/kingdom page. When I click on the chosen coordinates
field. And the input fields is occupied. Then an error message shows up:
"Coordinates are already taken!"

#### Scenario 3

Given the loaded register/kingdom page. When I click on the chosen coordinates
field. And the field is available. And I am navigated to the /kingdom page.

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration//kingdom endpoint
  works properly
