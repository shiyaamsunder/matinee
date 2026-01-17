# Matinee - Movie Reservation system

using this document like a scratchbook for my outlines and design. will separate it out as needed. 

1. User Authentication and Authorization
- Users should be able to sign up and log in.
- You also need roles for users, such as admin and regular user. Admins should be able to manage movies and showtimes.
- Regular users should be able to reserve seats for a showtime.

"You can create the initial admin using seed data. Only admins should be able to promote other users to admin and be able to do things related to movie management, reporting, etc."

2. Movie Management
- Admins should be able to add, update, and delete movies.
- Each movie should have a title, description, and poster image.
- Movies should be categorized by genre.
- Movies should have showtimes.
- 
3. Reservation Management
- Users should be able to reserve seats for a showtime, see the available seats, and select the seats they want.
- Users should be able to get the movies and their show times for a specific date.
- Users should be able to see their reservations and cancel them (only upcoming ones).
- Admins should be able to see all reservations, capacity, and revenue.


# DB Schema Design - 17/01/2025

###  User types

Two types of roles
1. Admin
2. User

Admin - Highest level of authority
- can add movies
- can schedule movies
- can promote regular user to admin
- can reserve seats


User - Regular User
- can view movies/showtimes
- can reserve seats


Rough outline for the entities needed for the project

###  User 
User Entity 
- user_id uuid pk
- role varchar (admin|user)
- username varchar
- password varchar (encrypted)

idx on username ( for admins to search using username)


###  Movie
Movie Entity
- movie_id uuid pk
- title varchar
- image blob/varchar (image/link)
- description varchar
- rating numeric
- genre varchar
- release_date datetime

idx on title
idx on genre

###  Screen
Screen entity (if the theatre has multiple screens)
- screen_id uuid pk
- screen_name varchar
- capacity int
- audio_type varchar
- video_type varchar

idx on screen_name

###  Showtime
Entity that has the records of all the showtimes for a movie
- showtime_id uuid pk 
- screen_id uuid fk on Screen(screen_id)
- movie_id  uuid fk on Movie(movie_id)
- time_start datetime
- time_end   datetime

idx on movie_id

### Reservation
Entity that links Showtimes -> Movies -> Users

- reservation_id uuid pk
- user_id uuid fk on User(user_id)
- showtime_id uuid fk on Showtime(showtime_id)
- count int
- price numeric (maybe)
- completed boolean
- cancelled boolean

idx on user_id
