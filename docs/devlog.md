# Development Log:

## 17/01/2026
1. Setup server project with springboot
    - chose springboot since thats what I want to skill up
2. setup flyway for database migration
    - to have have db migration and history
3. Write initial ddl scripts for the tables
    -  chose uuid for ids and to generate them in db level.
    -  will prevent duplicates if you have multiple client instances, for example load balanced web servers

Questions

1. Can we use the interval postgres type for the show timings?
2. How to account for seat numbers and occupied capacity of a given screen.?


## 18/01/2026

TODO for previous day
- [x] need to check how to map postgres uuid type to jpa
- [x] Add proper comments in db schema
- [x] add on delete on update for foreign keys
- [ ] evaluate whether a trigger is needed for modified_date => Task for another day
- [ ] Generate ER diagram whenever there is a schema change => Task for another day

### Thoughts on Auditing

Automatically updating the timestamps as the data gets updated. I wanted to make use of this so that it is possible to track when an entry has been modified. This is but one aspect of the auditing mechanism. Hence the dilemma on whether to use triggers or jpa annotations for handling timestamp updates seems redudant to me.
I'm seeing polarizing views and takes on where to have the "update" logic for a given entry. Some say having it on db side helps if there are multiple clients trying to update then db will be the source of truth. Others argue that client should always be responsible for updating the timestamp.

Auditing is a planned feature for this backend project. And I'm currently evaluating which framework to use. My current considerations are javers and envers.
Both has its [pros and cons](https://javers.org/blog/2017/12/javers-vs-envers-comparision.html)
I will mostly use javers since it's a relatively new one compared to envers and is independent of the db type.
I will come back to auditing once I'm done with defining the Entities in the codebase.

### Following Best Practices using JPA

Currently going through this [blog](https://protsenko.dev/spring-data-jpa-best-practices-entity-design-guide/). Still
trying to understand what each annotation does in jpa. Like difference between @Entity and @Table or how to do joins using
JPA.