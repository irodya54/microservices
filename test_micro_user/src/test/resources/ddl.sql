drop table if exists users;
drop table if exists car;

create table if not exists users
(
    id bigserial primary key,
    birthdate date,
    lastname  varchar(255),
    name      varchar(255),
    username  varchar(255) not null unique
);

create table if not exists car
(
    id bigint primary key,
    model varchar(255) not null unique ,
    number  varchar(255),
    user_id bigint references users(id)
);