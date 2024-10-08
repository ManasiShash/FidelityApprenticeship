create table customers( 
customerid serial primary key,
customername varchar(255) not null,
contactname varchar(255),
address varchar(255), 
city varchar(255), 
postalcode varchar(10),
country varchar(50) default 'Canada')

create table Suppliers( 
supplierid serial primary key,
supplierrname varchar(255) not null,
contactname varchar(255),
address varchar(255), 
city varchar(255), 
postalcode varchar(10),
country varchar(50));

create table Shippers(
shipperid serial primary key,
companyname varchar(255) not null unique,
phone varchar(50)
);

create table Products(
productid serial primary key,
productname varchar(255) not null,
supplierid int references Suppliers(supplierid) on delete cascade,
category varchar(255),
unit varchar(50),
price decimal(10,2));

create table orders(
orderid serial primary key,
customerid int references customers(customerid) on delete cascade,
shipperid int references Shippers(shipperid) on delete cascade,
orderdate date not null,
shippeddate date,
constraint chk_shipped_date check(shippeddate>orderdate));

create table Orderdetails(
orderdetailsid serial primary key,
orderid int references orders(orderid)on delete cascade,
productid int references Products(productid)on delete cascade,
quantity int not null check(quantity>10),
Price decimal(10,2));

insert into customers(customername,contactname,address,city, postalcode,country)
values('finch','finch','123 street','toronto','560070','Canada');
insert into customers(customername,contactname,address,city, postalcode,country)
values('Dinesh','Dinesh','124 street','Vanc','560071','Canada');

insert into Suppliers(supplierrname,contactname,address,city, postalcode,country)
values('AckSuppliers','Ack','100th lane','Montreal','2y5','Canada');
insert into Suppliers(supplierrname,contactname,address,city, postalcode,country)
values('QuertySuppliers','Querty','140th lane','Seattle','98004','USA');

insert into Shippers(shipperid,companyname, Phone)
values(1,'Fast Shipping', '5555');
insert into Shippers(shipperid,companyname, Phone)
values(2,'Slow Shipping', '6666');

insert into orders(customerid,shipperid,orderdate,shippeddate)
values (1,1,'2024-10-01','2024-10-05');
insert into orders(customerid,shipperid,orderdate,shippeddate)
values (2,2,'2024-10-03','2024-10-08');

insert into Products(productid, productname, supplierid,category,unit,price)
values(1,'Laptop',1,'Electronics','Piece',1200.50);
insert into Products(productid, productname, supplierid,category,unit,price)
values(2,'tablet',1,'Electronics','Piece',700.50);

insert into Orderdetails(orderid,productid,quantity,price)
values(1,1,11,1200.50);
insert into Orderdetails(orderid,productid,quantity,price)
values(2,2,15,700.50);

/*violatons*/

insert into orders(customerid,shipperid,orderdate,shippeddate)
values (2,2,'2024-10-09','2024-10-08');

insert into Orderdetails(orderid,productid,quantity,price)
values(1,1,2,1200.50);





