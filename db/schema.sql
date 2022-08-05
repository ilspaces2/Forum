create table posts (
  id serial primary key,
  name varchar(2000),
  description text,
  created timestamp without time zone not null default now(),
  username varchar(2000)
);

insert into posts (name) values ('О чем этот форум?');
insert into posts (name) values ('Правила форума.');