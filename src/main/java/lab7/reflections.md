Dependency Injection

Rather than creating a DataService object in the process, searchRecipes needs one as a parameter.
It enables us to upload any implementation—real database, CSV reader, or mock—that we select.


Interface

The recipe storage and retrieval methods are not provided by the DataService interface, which identifies 
getRecipes().
Any field of study that regulates this interface can use the method.

Polymorphism

It is possible to apply multiple DataService implementations collectively, such as SqliteDataService, 
CSV reader, and mock via lambda.
The actual data service kind is meaningless to searchRecipes; it is only relevant because it works the 
same as the DataService.


Mock

For receiving managed recipe data in tests, we may send a mock DataService that was made via an unidentified
class or lambda expression.
This helps in testing without having an actual database.



Coupling / Decoupling

SearchRecipes is connected loosely to the data source by means of a combination of dependencies and interface 
programming.
Flexibility, reusability, and testability are made easier by this decoupling.

