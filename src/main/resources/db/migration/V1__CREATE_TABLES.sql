create table app_user (
                          id serial primary key,
                          password varchar(64) not null,
                          username varchar(64) not null unique
);

create table todo(
                     id serial primary key,
                     title varchar(64) not null,
                     completed BOOLEAN not null
);



