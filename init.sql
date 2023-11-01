create extension if not exists "uuid-ossp";

create table product (
    id uuid primary key default uuid_generate_v4(),
    name varchar(100) not null,
    description varchar(200) not null,
    category varchar(50) not null,
    price float not null
);