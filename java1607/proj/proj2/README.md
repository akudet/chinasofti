# 电子商务平台
# Team Contract
## Team Member
* Jintong Wu(巫金桐)

### Personal Goal
* Jintong Wu : be fluent about e-comm platform, another project which can be as an instruction of the ability to use java main framework to develop java web project.

### How quality of work will be maintained
* follow the design spec, and don't look more.
* using git branch to develop a feature
* code style, follow [the java standard guide](http://www.oracle.com/technetwork/java/codeconvtoc-136057.html)
* work assignment : every 3 days I will revisit what have done as
a whole and plan the next phase work
* work/day : ~3hrs

# Design Doc
## Overview
### Motivation
as a b2c platform, we are going to build a platform to help consumer buy the goods the want and help company to sell their products to the potential people. Like many such thing, this app will have a centralized place to show various products. For consumers they will be able to add their loving items to shopcart and buy them.
For sellers they can add new products to sell or delare they as a seller of an existing product.

The key purposes that the application will address:

## Design Essence

### Concepts
#### Product
Someting people can exchange through internet.

Purpose:

Operational Principle: If a seller want to sell something,
the create a product and delare it as a seller of this product.

#### Shopping cart
a gathering of products which customers want to buy

Purpose: customer want to buy many items at once

Operational Principle:A customer can add many different kind products to a cart,
and buy the in one operation.

### Data Model

### User Interface

### Security Concerns

## Challenges
* the product vary, what if we want dispaly it differently
* how to advise the proper product
* general modeling problem

# Teamwork Plan
## Stakeholders

### Consumer & Sellers
these are our primar users. we envision that this app will be help fro consumer to but the goods they want at a competing price, and help sellers to sell the product to a huge range of customer.

## Tasks
the tasks are divided into 3 categories : User Interface, Database, Server
below is an outline of the tasks per category

## User Interface(MVP)

### Products(4hrs)
* Create a widget for display products as a list
* Create a way of showing products by popular, latest and discount
* Create a way of searching products by category

## Server(MVP)

### Products(2hrs)
* Create a way of forwarding latest, popular, discount request to db
* Create a way of forwarding search by category to db

## Database(MVP)

### Products(1hr)
* Create a latestProducts method that return latest products
* Create a popularProducts method that return popular products
* Create a discountProducts method that return dicounted products

## Calendar
## Risks
## Minimum Viable Product
