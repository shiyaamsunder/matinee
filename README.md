# Matinee - Full Stack Movie Reservation Application

A personal project to showcase my skills that I have learnt so far in fullstack.

Planning this project to have intermediate to advanced topics/desings implemented. Based on the project idea in [roadmap.sh](https://roadmap.sh/projects/movie-reservation-system)

## What I'm planning to do?
1. Full-blown backend server that can handle movie showtime scheduling, reservations etc.,
2. Frontend + Mobile application for the users to view/purchase movie tickets etc.,
3. Proper DB maintained by following db migrations, auditing.
4. And more (will update this list as the project gets shaped up)

## What I have done so far?
1. Project Setup - Backend - Java + Postgres + Flyway (db migration)
2. Initial level of DB Schema Design.

Checkout my [devlog](docs/devlog.md) for more information on how I'm building project. (Contains my thoughts, notes
, best practices that I'm trying to follow)

## Local Setup

Software required

1. Java 25 
2. Docker (I personally use Rancher Desktop with WSL integration.)

After the installing the required software, clone the repo.

Start the docker container from the project root.

Right now it spins up a postgres instance and an adminer instance.
```shell
docker compose up -d
``` 

Then navigate to the `server` directory. 
Start flyway migration to set up DB and test ata.
```shell
./mvnw flyway:migrate
```
Then run the backend application
```shell
./mvnw spring-boot:run
```