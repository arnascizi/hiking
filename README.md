# springboot hiking app
## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

In `api` module `ApiApplication` class, go to edit configuration and add `Workign directory` default shortcut on Intellij IDEA `Alt+W`.
In `Working directory` provide such configuration: `$MODULE_WORKING_DIR$` and start application.

Application is accessible on port: `7070` 

list all items: GET `http://localhost:7070/api/v1/items`

list items by season: GET `http://localhost:7070/api/v1/items/{season}` (spring, winter, summer, fall, all)

calculate items for trip: POST `http://localhost:7070/api/v1/trip/calculate` 

Example body:
```
{
    "tripLength": 22,
    "travelDate":  "2021-07-03 00:00:00"
}
```

## TODO

* add person entity to determine average caloric intake for a day during trips.
* add trip length in days, distance divided by average persons pace.
* create a new entity that differentiates all items from food / beverages 
* food can have caloric values to determine how much food needed for certain trip
* resolve item quantity to accumulate how many items needed for longer trips
* migrate to gradle
* create endpoint to add your items
* refactor logic
* clean code

## DONE

* create model, business, api layers
* add H2 DB support
* flyway migration
* fix maven dependency management 
* create base entities, repositories
* add starting logic for project