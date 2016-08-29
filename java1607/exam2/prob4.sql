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

drop table if exists Product;
create table Product (
	ProNo varchar(20) primary key,
	ProName varchar(20),
	Price decimal(10,2),
	Sotcks decimal
);

drop table if exists Product;
create table ProOut (
	SaleDate date,
	CusNo varchar(20),
	ProNo varchar(20),
	Quantity decimal,
	primary key (CusNo, ProNo)
);
