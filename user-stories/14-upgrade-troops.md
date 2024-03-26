# 14. Upgrade Troops

## Description

Academy is the building where it happens, but the troop is the target for the
upgrade. You can upgrade each type of your troops (if you have multiple types)
from basic level 1 to highest level 20. Maximum level is limited by the
townhall. I suggest you start thinking about the custom formula how to increase
provess of your units, because fixed values just won't cut it here.  

Let's make it simple for us. Yo either upgrade all of the troops for given type,
or none of them. Although it would be very realistic, it wouldn't be very
practical for us to work with such diversity. So we bulk upgrade the
qualification of the troops at once. It takes some time of course, but once it's
done, it is done.

***Note:** It is of the most importance to mention that the levels of troops
should not be directly stored within troop's entity. Rather, think about
creating an entity in your data storage where you keep all this information in
one place, without repetition and only once per each type of troop. Since the
level of the troop will change, also its properties like attack & defense will
change. So think about maybe storing those at the same place as well. Trust me
with this one. You'll thank me later.*

## Backend Part

### Endpoint

`PUT /kingdoms/{id}/troops`

### Sample Request

```json
{
  "type": "knight",
}
```

### Sample Response (status 200)

```json
{
  "status": "ok"
}
```

### Sample Response (status 400)

```json
{
  "error": "You don't have enough gold to upgrade this type of troops!"
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

Given PUT /kingdoms/{id}/troops endpoint. When I send a request to it. And I
have enough money. Then I can upgrade troops.

#### Scenario 2

Given the PUT /kingdoms/{id}/troops endpoint. When I send a request to it. And I
don't have enough money. Then I get back a message: "You don't have enough
gold.".

#### Scenario 3

Given the PUT /kingdoms/{id}/troops endpoint. When I send a request to it. And I
have enough money. And I reach town hall level Then I get back a message: "You
reached the maximum level, upgrade Townhall first.".

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
