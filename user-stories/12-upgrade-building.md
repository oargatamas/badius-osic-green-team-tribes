# 12. Upgrade Building

## Description

Buildings can be upgrade. So they provide more value in the same given space.
More value, more efficiency. Nice, right? But of course, it comes with a
price...which is...the price of the upgraded building being much higher than the
original one.

***Note:** You can 'hardcode' the prices into the rules of the game, which we
will talk about later, or you can be creative and come up with some interesting
mathematical formulas how to count everything. As usual, choice is yours.*

## Backend Part

### Endpoint

`PUT /kingdoms/{id}/buildings/{id}`

### Sample Response (status 200)

```json
{
  "id": 2,
  "type": "farm",
  "level": 2,
  "hp": 1,
  "startedAt": 12345789,
  "finishedAt": 12399999
}
```

### Sample Response (status 400)

```json
{
  "error": "You don't have enough gold to upgrade that!"
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

Given the PUT /kingdom/{id}buildings/{id} endpoint. When I send a request to it.
And the building level is less than the townhall level. And I have enough money
for the upgrading. Then I can upgrade my building. And get my upgraded building
details back.

#### Scenario 2

Given the PUT /kingdom/{id}buildings/{id} endpoint. When I send a request to it.
And the building level is equal to the townhall level. Then I get back a
message: "Townhall level needs to be increased.".

#### Scenario 3

Given the PUT /kingdom/{id}buildings/{id} endpoint. When I send a request to it.
And the building level is less than the townhall level. And I don't have enough
money for the upgrading. Then I get back a message: "You don't have enough
money.".

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
