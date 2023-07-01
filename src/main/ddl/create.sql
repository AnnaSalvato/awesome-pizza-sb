create sequence identity_seq start with 1 increment by 50;

create table order_aw (status varchar(1) not null, id bigint not null, order_date TIMESTAMP not null, username varchar(50), primary key (id));
create table pizza (id bigint not null, order_id bigint, primary key (id));
create table pizza_ingredients (pizza_id bigint not null, ingredient varchar(50) not null);

alter table if exists pizza add constraint FKlawx3ldijgey9eufpy468m0qm foreign key (order_id) references order_aw;
alter table if exists pizza_ingredients add constraint FKbmkay60qrmenad7mc32udtvab foreign key (pizza_id) references pizza;
