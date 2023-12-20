create database if not exists cg_lazada_plus_project;
use cg_lazada_plus_project;

create table if not exists user_role(
user_role_id int primary key auto_increment,                     
user_role varchar(50),
is_delete bit(1) default 0
);

insert into user_role(
	user_role)
    values
    ('customer'),
    ('admin');
    
create table user(
user_id int primary key auto_increment,
user_name varchar(50),
user_password varchar(50),
user_role_id int default 1,
is_active bit(1) default 1,
is_delete bit(1) default 0,
foreign key (user_role_id)
references user_role(user_role_id)
);

insert into `user`
	(user_name, user_password, user_role_id)
    values
    ('huy', '123', 1),
    ('giang', '123', 1),
    ('tu', '123', 2),
    ('long', '123', 1);
    
create table customer_membership(
customer_membership_id int primary key auto_increment,
customer_membership_name varchar(15),
customer_membership_point_reference int,
customer_membership_promotion_percent double,
is_delete bit(1) default 0
);

insert into customer_membership
(customer_membership_name, customer_membership_point_reference, customer_membership_promotion_percent)
values
('not rank', 0, 0),
('bronze', 100, 2 ),
('silver', 250, 5 ),
('gold', 500, 10 );

create table customer(
customer_id int primary key auto_increment,
user_id int,
customer_name varchar(50),
customer_address varchar(50),
customer_balance double,
customer_point int,
customer_membership_id int,
is_delete bit(1) default 0,
foreign key (user_id)
references user(user_id),
foreign key (customer_membership_id)
references customer_membership(customer_membership_id)
);

insert into customer
(user_id, customer_name, customer_address, customer_balance, customer_point, customer_membership_id)
values
(1, 'Nguyen Ngoc Dang Huy', 'HCMC', 1000000, 499, 3),
(2, 'Vu Phuong Giang', 'HCMC', 0, 120, 2),
(4, 'Le Phi Long', 'HCMC', 0, 0, 1);

create table `admin`(
admin_id int primary key auto_increment,
user_id int,
admin_name varchar(50),
is_delete bit(1) default 0,
foreign key (user_id)
references user(user_id)
);

insert into `admin`
(user_id, admin_name)
values
(3, 'Nguyen Hoang Tu');

create table category(
category_id int primary key auto_increment,
category_name varchar(50),
is_delete bit(1) default 0
);

insert into category (category_name) 
values ('Electronic device'),
('Healthcare'),
('Fashion');

create table product(
product_id int primary key auto_increment,
user_id int,
product_name varchar(50),
product_quantity double,
product_cost double,
is_delete bit(1) default 0,
foreign key (user_id)
references user(user_id)
);

insert into product(user_id,product_name,product_quantity,product_cost)
values (1, 'phone', 5, 5000),
		(2, 'laptop', 10, 1000),
		(2, 'mascara', 3, 2000),
		(1, 'sport shoe', 1, 3000),
		(1, 'perfume', 2, 6000);



create table product_category(
product_id int,
category_id int,
is_delete bit(1) default 0,
foreign key (product_id)
references product(product_id),
foreign key (category_id)
references category(category_id)
);

insert into product_category
(product_id, category_id)
values
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 2);



create table purchase_order(
purchase_order_id int primary key auto_increment,
product_id int,
buyer_id int,
seller_id int,
purchase_order_date datetime,
purchase_order_address varchar(255),
purchase_order_quantity int,
purchase_order_unit_price varchar(10),
purchase_order_total_cost double,
purchase_order_final_cost double,
is_delete bit(1) default 0,
foreign key (product_id)
references product(product_id)
);

create table review(
review_id int primary key auto_increment,
customer_id int,
product_id int,
review_point int,
review_date datetime,
review_detail text,
is_delete bit(1) default 0,
foreign key (customer_id)
references customer(customer_id),
foreign key (product_id)
references product(product_id)
);

create table mail(
mail_id int primary key auto_increment,
user_id int,
sender_id int,
mail_message text,
is_delete bit(1) default 0,
foreign key (user_id)
references user(user_id)
);