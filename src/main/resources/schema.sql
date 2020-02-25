create table restaurant(
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(128) NOT NULL,
	pincode INTEGER NOT NULL ,
	menu_id INTEGER  NOT NULL ,
	rating ENUM('ONE_STAR', 'TWO_STAR', 'THREE_STAR', 'FOUR_STAR', 'FIVE_STAR'),
	opening_time TIME ,
	closing_time TIME ,
	day_off ENUM('MONDAY', 'TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY','SUNDAY'),
	cuisine ENUM('NORTH_INDIAN', 'CHINESE', 'SOUTH_INDIAN', 'ITALIAN'),
    delivery_charges INTEGER NOT NULL

);

create table menu(
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	restaurant_id INTEGER NOT NULL ,
	dishes TEXT NOT NULL
);


create table dish(
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR (255) NOT NULL,
	price INTEGER NOT NULL ,
	dish_type ENUM('VEGAN', 'NON_VEG', 'VEG')
);

create table customer_order(
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	restaurant_id INTEGER NOT NULL,
	customer_id INTEGER NOT NULL,
	order_price INTEGER NOT NULL ,
	order_time DATETIME,
	delivery_time DATETIME,
	estimated_delivery_time DATETIME,
    order_status ENUM('CREATED','PREPARING', 'PREPARED', 'PICKED','ON_WAY','DELIVERED'),
    payment_mode ENUM('COD', 'UPI', 'NET_BANKING', 'CREDIT_CARD', 'DEBIT_CARD'),
    payment_status ENUM('COMPLETED','REFUND_INITIATED', 'REFUNDED'),
    dishes text NOT NULL
);

create table customer(
  id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name text NOT NULL ,
  phone_number text NOT NULL ,
  address text NOT NULL
);

create table restaurant_order
(
    id               INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_id         INTEGER NOT NULL,
    restaurant_id   INTEGER    NOT NULL,
    order_time       DATETIME,
    preparation_time DATETIME
)