# 05. Player Identity

## Description

You have your token, but you are not totally sure, that it belongs to the ruler,
that you need. How to check it? Endpoint for this use case is the solution!

***IMPORTANT:* There should be a service that handles verification of a JWT
access token implemented as a separate service. Every time a player tries to
access any REST API resource, the validation should be triggered verifying that
the player indeed tries to access the resources which are linked only to
player's own kingdom. In case this condition is met, resources should be shared
with the player. If not, player should be informed about problem with
authorization.**

## Backend Part

### Endpoint

`POST /auth`

### Form Data Validations

- **username**: required, may not be an empty string
- **password**: must be at least 8 characters long

### Sample Request

```json
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIxIiwidXNlcm5hbWUiOiJhZGFtMTIzIiwia2luZ2RvbUlkIjoxLCJraW5nZG9tTmFtZSI6IkJ1a3VyZXN0IiwiaWF0IjoxNTE2MjM5MDIyfQ.bu2OWGryuKz2AQMLFNQ5rwEoFirYAYtPjsBq_7JGUSA"
}
```

### Sample Response (status 200)

```json
{
    "ruler": "adam001",
    "kingdomId": 1,
    "kingdomName": "Bukurest",
}
```

### Testing (BE)

- Create ***unit tests*** that should cover both the positive & negative cases
