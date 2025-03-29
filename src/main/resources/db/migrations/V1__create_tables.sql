create table tb_user_auth (id bigint generated by default as identity, login varchar(255) not null unique, password varchar(255) not null, role varchar(255) not null, primary key (id));
create table tb_category (id bigint generated by default as identity, name varchar(255), primary key (id));
create table tb_order (order_status integer, client_id bigint, id bigint generated by default as identity, moment timestamp(6) with time zone, primary key (id));
create table tb_order_item (price float(53), quantity integer, order_id bigint not null, product_id bigint not null, primary key (order_id, product_id));
create table tb_payment (moment timestamp(6) with time zone, order_id bigint not null, primary key (order_id));
create table tb_product (price float(53), id bigint generated by default as identity, description varchar(255), img_url varchar(255), name varchar(255), primary key (id));
create table tb_product_category (category_id bigint not null, product_id bigint not null, primary key (category_id, product_id));
create table tb_user (id bigint generated by default as identity, email varchar(255), name varchar(255), password varchar(255), phone varchar(255), primary key (id));
alter table if exists tb_order add constraint FKi0x0rv7d65vsceuy33km9567n foreign key (client_id) references tb_user;
alter table if exists tb_order_item add constraint FK4h5xid5qehset7qwe5l9c997x foreign key (product_id) references tb_product;
alter table if exists tb_order_item add constraint FKgeobgl2xu916he8vhljktwxnx foreign key (order_id) references tb_order;
alter table if exists tb_payment add constraint FKokaf4il2cwit4h780c25dv04r foreign key (order_id) references tb_order;
alter table if exists tb_product_category add constraint FK5r4sbavb4nkd9xpl0f095qs2a foreign key (category_id) references tb_category;
alter table if exists tb_product_category add constraint FKgbof0jclmaf8wn2alsoexxq3u foreign key (product_id) references tb_product;
