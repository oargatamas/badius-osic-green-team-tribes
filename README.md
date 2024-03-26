# TRIBES - Project Guideline

## Main goal

The vision of the Tribes project is to create an online browser-based
multiplayer game, where every player has their own kingdom and they battle with
each other in order to gain control over the other kingdoms.

## Execution

There are two options for the implementation of the project:

- ***"backend"*** project team: implements only REST API in programming language
  like JAVA, C# or Python
- ***"fullstack"*** project team: implements both backend (REST API) & frontend
  part usually using combination of JS frameworks (Node.js+Expres.js with
  React/Angular/Vue)

This guide will provide information in a form, that is not technology specific,
but rather focuses on overall functionality that needs to be implemented. Of
course, it will still diferentiate between "frontend" & "backend" parts where
applicable.

## Roles

There are three main roles in the project:

- **Player**: has a kingdom and actually plays the game
- **Admin**: Manages the game and the players
- **Visitor**: doesn't have an account on the page, but still can check out
  other kingdoms

***Note***: The only mandatory role in the project is the role "Player".
Implementation of other roles, while encouraged, is completely optional.

## Basic game entities

| Name      | Description                                                                              |
| --------- | ---------------------------------------------------------------------------------------- |
| Player    | The person that can interact with the game (usually Player - ruler of the kingdom)       |
| Kingdom   | The main playable entity in Tribes; every player controls a Kingdom after registration   |
| Buildings | Every Kingdom has several buildings with specific features                               |
| Troops    | Every Kingdom will train Troops in order to battle with the other Kingdoms               |
| Resources | Every Kingdom gathers Resources: Gold and Food in order to purchase Buildings and Troops |
| Map       | Displays the grid with cells that represents some kingdom or empty plot of land          |

## Minimal requirements to start development

***Note**: Every project team member must have the development environment set
up*

The development setup is done if the team member is able to do the following
activities successfuly:

- Install all the necessary dependencies locally
- Run the application in local development environment
- Run all the unit and integration tests
- Run the linter locally
- Deploy a new version of the application

## List of use cases

Following are the use cases that need to be implemented in the project for it to
be considered finished.

### [01. Player Registration](./user-stories/01-player-registration.md)

### [02. List Kingdoms](./user-stories/02-list-kingdoms.md)

### [03. Kingdom Registration](./user-stories/03-kingdom-registration.md)

### [04. Player Login](./user-stories/04-player-login.md)

### [05. Player Identity](./user-stories/05-player-identity.md)

### [06. Kingdom Details](./user-stories/06-kingdom-details.md)

### [07. Kingdom Resources](./user-stories/07-kingdom-resources.md)

### [08. Kingdom Buildings](./user-stories/08-kingdom-buildings.md)

### [09. Kingdom Troops](./user-stories/09-kingdom-troops.md)

### [10. Rename Kingdom](./user-stories/10-rename-kingdom.md)

### [11. Add Building](./user-stories/11-add-building.md)

### [12. Upgrade Building](./user-stories/12-upgrade-building.md)

### [13. Create Troops](./user-stories/13-create-troops.md)

### [14. Upgrade Troops](./user-stories/14-upgrade-troops.md)

### [15. Leaderboards](./user-stories/15-leaderboards.md)

### [16. Battles](./user-stories/16-battles.md)

### [17. Game Rules](./user-stories/17-game-rules.md)

### [18. Beyond The Scope](./user-stories/18-beyond-the-scope.md)
