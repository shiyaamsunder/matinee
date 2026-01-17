# Development Log:

## 17/01/2026
1. Setup server project with springboot
    - chose springboot since thats what I want to skill up
2. setup flyway for database migration
    - to have have db migration and history
3. Write initial ddl scripts for the tables
    -  chose uuid for ids and to generate them in db level.
    -  will prevent duplicates if you have multiple client instances, for example load balanced web servers

TODO for next day
1. need to check how to map postgres uuid type to jpa
2. Add proper comments
3. add on delete on update for foreign keys
4. valuate whether a trigger is needed for modified_date
5. Generate ER diagram whenever there is a schema change.

	
	
	
Questions

1. Can we use the interval postgres type for the show timings?
2. How to account for seat numbers and occupied capacity of a given screen.?
