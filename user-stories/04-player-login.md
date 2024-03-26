# 04. Player Login

## Description

The process of registration is finished. My kingdom has a name and a place in a
world. It is time to start ruling it, now. The player provides ***username***
and ***password***. In case of success, the player receives access token. In
case of failure, player receives error with the message.

## Backend Part

### Endpoint

`POST /login`

### Form Data Validations

- **username**: required, may not be an empty string
- **password**: must be at least 8 characters long

### Sample Request

```json
{
 "username": "adam001",
 "password": "password123",
}
```

### Sample Response (status 200)

```json
{
    "status": "ok",
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIxIiwidXNlcm5hbWUiOiJhZGFtMTIzIiwia2luZ2RvbUlkIjoxLCJraW5nZG9tTmFtZSI6IkJ1a3VyZXN0IiwiaWF0IjoxNTE2MjM5MDIyfQ.bu2OWGryuKz2AQMLFNQ5rwEoFirYAYtPjsBq_7JGUSA"
}
```

### Sample Response (status 400)

```json
{
    "error": "Field username and/or field password was empty!"
}
```

### Sample Response (status 401)

```json
{
    "error": "Username and/or password was incorrect!"
}
```

### Testing (BE)

- Create ***unit tests*** that should cover both the positive & negative cases

## Frontend Part

### Acceptance Criteria

#### Scenario 1

Given the /login route. When the page is loaded. Then the login form exists.

#### Scenario 2

Given the loaded login page. When I click on the submit button. And the input
fields are blank. Then an error message shows up: "Username and password are
required."

#### Scenario 3

Given the loaded login page. When I click on the submit button. And I give a
correct username And I give correct password And I am navigated to the
/kingdom/{id} page.

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
