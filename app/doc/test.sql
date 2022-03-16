create table testx(
  no int not null primary key,
  dt timestamp not null default now()
);


insert into testx(no) values(1);