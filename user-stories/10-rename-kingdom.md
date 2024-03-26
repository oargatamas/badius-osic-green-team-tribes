# 10. Rename Kingdom

## Description

Sometimes, you just want to reinvent yourself. Or you just mis-spelled the name
first time. Either way, you can rename your kingdom if you need.

## Backend Part

### Endpoint

`PUT /kingdoms/{id}`

### Form Data Validations

- **kingdomName**: required, may not be an empty string

### Sample Request

```json
{
  "kingdomName": "Hahalkovo",
}
```

### Sample Response (status 200)

```json
{
  "kingdomId": 1,
  "kingdomName": "Hahalkovo" 
}
```

### Sample Response (status 400)

```json
{
  "error": "Field kingdomName was empty!"
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

Given the /kingdoms/{id} route. When the page is loaded. Then the rename form
exists.

#### Scenario 2

Given the loaded /kingdoms/{id} page. When I click on the submit button. And the
input fields are blank. Then an error message shows up: "Kingdom name is
required."

#### Scenario 3

Given the loaded /kingdoms/{id} page. When I click on the submit button. And I
give a some kingdom name. The kingdom name is changed. And I am navigated to the
/kingdom/{id} page.

### Testing (FE)

- Create ***unit tests*** that should cover both the positive & negative cases
- Create an ***endpoint test*** that verifies the registration endpoint works
  properly
