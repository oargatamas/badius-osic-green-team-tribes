# 13. Create Troops

## Description

Troops are backbone of your kingdom's army. You can train one at a time or you
can put an order into queue to train multiples of a given troop type. Troops can
have customized attack/defense/hp/properties. Levels of troops are not
multiplication of base level, but have custom formula. Also some troops like
catapults are capable of destroying buildings, gather information about enemy
(spy) and take over their kingdom (senator).

**Note:** You either need to implement desertion (removal) for the troops that
could not be fed on time or there should be check whether the
totalFoodConsumption of kingdom <= total foodGeneration. And if not, the limit
of units is reached for the moment.

Here are the suggested types of units for your kingdom:

- basic defensive unit (defense >> attack)
- basic offensive unit (attack >> defense)
- mounted heavy unit (attack > defense, faster than basic units)
- spies (fastest, but minimal or no attack & defense)
- senators (slow, weak unit, with option to ake over enemy kingdom)

## Backend Part

### Endpoint

`POST /kingdoms/{id}/troops`

### Sample Request

```json
{
   "type": "knight",
   "quantity": 2
}
```

### Sample Response (status 200)

```json
{
    "id": 1,
    "level": 1,
    "hp": 1,
    "attack": 1,
    "defence": 1,
    "startedAt": 12345789,
    "finishedAt": 12399999
}, 
{
    "id": 2,
    "level": 1,
    "hp": 1,
    "attack": 1,
    "defence": 1,
    "startedAt": 12345789,
    "finishedAt": 12399999
}
```

### Sample Response (status 400)

```json
{
    "error": "You don't have enough gold to train all these units!"
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

Given POST /kingdoms/{id}/troops endpoint. When I send a request to it. And I
have enough money. Then I can create troops. And get back informations about the
new troops.

#### Scenario 2

Given the POST /kingdoms/{id}/troops endpoint. When I send a request to it. And
I don't have enough money. Then I get back a message: "You don't have enough
gold.".

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
