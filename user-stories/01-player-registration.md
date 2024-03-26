# 01. Player Registration

## Description

I, as a new player, want to register into the game. I have to provide
***username*** and ***password***. I can optionally provide also ***kingdom
name***, but if not provided, it will be automatically created using my
***username*** concatenated with words ***'s kingdom***.

## Backend Part

### Endpoint

`POST /registration`

### Form Data Validations

- **username**: required, may not be an empty string, must be unique
- **password**: must be at least 8 characters long
- **kingdomName**: optional, but if provided, it may not be an empty string,
  must be unique

### Sample Request

```json
{
    "username": "adam001",
    "password": "password123",
    "kingdomname": "Discovery Channel"
}
```

### Sample Response

```json
{
    "username": "adam001",
    "kingdomId": 1
}
```

### Testing (BE)

- Create ***unit tests*** that should cover both the positive & negative cases

## Frontend Part

### Acceptance Criteria

#### Scenario 1

Given the /register route. When the page is loaded. Then the register form
exists.

#### Scenario 2

Given the loaded register page. When I click on the submit button. And the input
fields are blank. Then an error message shows up: "Username and password are
required."

#### Scenario 3

Given the loaded register page. When I click on the submit button. And the
username was taken. Then an error message shows up: "Username is already taken,
choose another one."

#### Scenario 4

Given the loaded register page. When I click on the submit button. And the
password is under 8 characters. Then an error message shows up: "Password must
be 8 characters."

#### Scenario 5

Given the loaded register page. When I click on the submit button. And I give a
unique user name And I give an 8 character long password And I optionally give a
kingdom name Then a new user is created And I am navigated to the /login page.

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
