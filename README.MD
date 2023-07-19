# Virtual Internship Experience: Walmart

### Task 1: 
> Your task is to implement a novel data structure - your project lead is calling it a power of two max heap. The rest of your  team is doing their best to come up with a better name. The requirements of the data structure are as follows:

> - The heap must satisfy the heap property.
> - Every parent node in the heap must have 2^x children.
> - The value of x must be a parameter of the heap’s constructor.
> - The heap must implement an insert method.
> - The heap must implement a pop max method.
> - The heap must be implemented in Java.
> - The heap must be performant.
> - You must use a more descriptive variable name than x in your implementation.

> Think carefully about how you implement each method, and manage the underlying data. Performance is critical, so keep cycles and memory usage to a minimum. Be sure to test your heap with very small and very large values of x. As always, keep a weather eye out for sneaky edge cases.

### Task 2:
> Your task is to draft a UML class diagram describing the data processors for a pipeline. The component responsible for reading in input data is being designed by another engineer, so you only need to worry about what happens to the data when it reaches your processor. 

> You may assume three classes already exist:
- Datapoint: this class represents both raw and processed data points. Any time data moves between methods you may use this class as an abstraction.
- ModeIdentifier: an enum used to identify a processor mode.
- DatabaseIdentifier: an enum used to identify a database connection.

> Here are the requirements for your design:
> - The processor must implement a configure method that accepts a ModeIdentifier and a DatabaseIdentifier as parameters.
> - This method is called to change the operating mode of the processor, and/or select the current database.
> - The processor must be able to change between the following modes:
> - Dump mode: simply drops the data.
> - Passthrough mode: inserts the data into the currently configured database.
> - Validate mode: validates the data, then inserts it (both operations are carried out on the currently configured database).
> - The processor must be able to swap between the following databases. Each database will require a different implementation to insert and validate data
> 1. Postgres.
> 2. Redis.
> 3.  Elastic.
> - The processor must implement a process method that accepts a DataPoint as a parameter.
> - This method will have different behavior depending on the currently configured mode and database.
> There is no need to get into implementation specifics, keep things abstract and high level. For example, you need only specify connect, insert, and validate methods for each database, there is no need to specify how those methods go about performing their verbs. The point of this task is to think about how code is structured 

### Task 3: 
> Your task is to draft an ERD for an appropriately normalized relational database that satisfies these requirements:

> - The database should store information related to the following products.
> - Pet food, which has a name, manufacturer, weight, flavor, and target health condition.
> - Pet toys, which have an associated material, name, manufacturer, and durability.
> - Pet apparel, which has a color, manufacturer, size, name, and specific care instructions.
> - Each product should be associated with one or more animals.
> - Each product should be associated with a manufacturer.
> - The database should track customers and their transactions.
> - It should store customer names and email addresses.
> - Customers can make transactions to purchase one or more products.
> - Each transaction should store the date and the products involved.
> - The database should track shipments to various Walmart locations.
> - Each location should be represented by a name and a zip code.
> - A shipment is recorded as an origin, a destination, and a collection of products, each with an associated quantity.

### Task 4:
> Part 1: Get the data
> First, you need to get your hands on the relevant data. The shipping department has been kind enough to provide you with a repository containing all of their spreadsheets, as well as a copy of the sqlite database. First, fork and clone the repository at: https://github.com/theforage/forage-walmart-task-4

> Part 2: Populate the database
> Your task is to insert all of the data contained in the provided spreadsheets into the SQLite database. You will write a Python script which:
> - Reads each row from the spreadsheets.
> - Extracts the relevant data.
> - Munges it into a format that fits the database schema.
> - Inserts the data into the database.
> Spreadsheet 0 is self contained and can simply be inserted into the database, but spreadsheets 1 and 2 are dependent on one another. Spreadsheet 1 contains a single product per row, you will need to combine each row based on its shipping identifier, determine the quantity of goods in the shipment, and add a new row to the database for each product in the shipment. The origin and destination for each shipment in spreadsheet 1 are contained in spreadsheet 2. You may assume that all the given data is valid - product names are always spelled the same way, quantities are positive, etc. 
