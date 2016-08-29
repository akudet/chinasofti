/*
1.创建以上3张表(3分)
2.添加以上数据(3分)
3.查询销售数量超过100的产品的产品号(4分)
4.查询购买了产品号“P0002”的客户编号、客户名和电话，查询结果按 客户名降序排列(5分)
5.显示客户“C004”在2008年 购买的产品号、数量(5分)
*/

drop table if exists customer;
create table customer (
	CusNo varchar(20) primary key,
	CusName varchar(10),
	Address varchar(10),
	Tel varchar(20)
);

insert into customer values("C001", "杨婷", "北京", "010-5328953");
insert into customer values("C002", "李和平", "上海", "021-62359651");
insert into customer values("C003", "叶新", "成都", "024-3222781");
insert into customer values("C004", "冯辰诚", "上海", "021-87235965");

drop table if exists Product;
create table Product (
	ProNo varchar(20) primary key,
	ProName varchar(20),
	Price decimal(10,2),
	Sotcks decimal
);

insert into Product values("P0001", "液晶电视", 5600, 300);
insert into Product values("P0002", "空调", 2390, 460);
insert into Product values("P0003", "洗衣机", 3700, 600);
insert into Product values("P0004", "电热水器", 890, 120);

drop table if exists ProOut;
create table ProOut (
	SaleDate date,
	CusNo varchar(20),
	ProNo varchar(20),
	Quantity decimal,
	primary key (SaleDate, CusNo, ProNo)
);

insert into ProOut values("2007-10-27", "C001", "P0001", 3);
insert into ProOut values("2007-11-06", "C004", "P0003", 40);
insert into ProOut values("2007-12-27", "C001", "P0003", 5);
insert into ProOut values("2008-3-15", "C002", "P0002", 12);
insert into ProOut values("2008-05-02", "C003", "P0002", 21);
insert into ProOut values("2008-05-02", "C003", "P0001", 9);
insert into ProOut values("2008-09-21", "C004", "P0001", 30);
insert into ProOut values("2008-11-21", "C004", "P0001", 73);
